package com.muath.tawseelaapp.muath.applogic

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.util.Log
import android.widget.Toast
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.GeoPoint
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.muath.tawseelaapp.muath.models.User
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class Registration(private val context: Context) {
    private lateinit var userId: String
    val firestore = Firebase.firestore
    val auth = Firebase.auth

    private fun registerNewUserToFireStore(
        user: User,
        uid: String,
        listener: AuthenticationListener
    ) {

        if (!user.name.isNullOrEmpty()) {
            val map = mapOf(
                "name" to user.name,
                "mobile" to "",
                "latLng" to GeoPoint(0.toDouble(), 0.toDouble())
            )
            firestore.collection("users").document(uid)
                .set(map)
                .addOnSuccessListener {
                    Log.i("mmm", "${user.name} added successfully")
                    listener.onAuthenticated()


                }.addOnFailureListener {
                    Log.e("mmm", "${user.name} did not push to FIREBASE")
                    listener.onError()


                }
        }
    }

     fun registerNewUser(
         user: User,
         uid: String,
         listener: AuthenticationListener
    ): Boolean {
        val status = false
        val countDownLatch = CountDownLatch(1)

        if (!user.name.isNullOrEmpty()) {
            val map = mapOf(
                "name" to user.name,
                "mobile" to "",
                "latLng" to GeoPoint(0.toDouble(), 0.toDouble())
            )
            firestore.collection("users").document(uid)
                .set(map)
                .addOnSuccessListener {
                    Log.i("mmm", "${user.name} added successfully")
                    listener.onAuthenticated()
                    countDownLatch.countDown()

                }.addOnFailureListener {
                    Log.e("mmm", "${user.name} did not push to FIREBASE")
                    listener.onError()
                    countDownLatch.countDown()
                }
        }
        countDownLatch.await(5, TimeUnit.SECONDS)
        return status
    }

    fun addNewUserToAuth(email: String, pass: String, listener: AuthenticationListener) {
        var i = 0
        val user = User(email.substringBefore("@"))
        auth.createUserWithEmailAndPassword(email, pass)
            .addOnSuccessListener { authResult ->
                Toast.makeText(context, "تمت الاضافة بنجاح. شكرا لثقتكم بنا.", Toast.LENGTH_LONG)
                    .show()
                userId = authResult.user!!.uid
                writeUserIdToSharedPreferences(userId)
                Log.e("mmm", "---->" + (++i).toString() + "<----")
                registerNewUserToFireStore(user, userId, listener)
            }
            .addOnFailureListener {
                Toast.makeText(
                    context,
                    "عذرا. حصل خطأ أثناء عملية التسجيل. يرجى الاعادة.",
                    Toast.LENGTH_LONG
                ).show()
                Log.e("muath", it.message!!)
                listener.onError()
            }
    }

    private fun writeUserIdToSharedPreferences(id: String): Boolean {
        val sharedPreferences = context.getSharedPreferences("RegPref", MODE_PRIVATE)
        return sharedPreferences.edit().putString("userId", id).commit()

    }

    fun loginWithUsernameAndPassword(
        username: String,
        pass: String,
        listener: AuthenticationListener
    ) {
        val email = username + "@testapp.com"
        auth.signInWithEmailAndPassword(email, pass)
            .addOnSuccessListener {
                listener.onLoggedIn()
            }
            .addOnFailureListener { exp ->
                Toast.makeText(context, exp.localizedMessage, Toast.LENGTH_LONG).show()
                listener.onLogFail()
            }
    }

    fun updateLocation(latLng: LatLng, listener: MapListener) {
        val geoPoint = GeoPoint(latLng.latitude, latLng.longitude)
        val id = context.getSharedPreferences("RegPref", MODE_PRIVATE).getString("userId", "")
        firestore.collection("users").document(id!!).update(mapOf("latLng" to geoPoint))
            .addOnSuccessListener {
                //when updated
                Toast.makeText(context, "location updated", Toast.LENGTH_LONG).show()
                listener.onSuccess()
            }.addOnFailureListener {
                Toast.makeText(context, it.localizedMessage, Toast.LENGTH_LONG).show()
                listener.onError()
            }
    }


}