package com.muath.tawseelaapp.muath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_mobile_verification.*
import com.muath.tawseelaapp.muath.models.User
import java.lang.NullPointerException
import java.util.concurrent.TimeUnit
import com.muath.tawseelaapp.R

class MobileVerificationActivity : AppCompatActivity() {
    private var smsCode: String? = "fakeToReplace"
    private lateinit var mobileNumber: String
    var code = ""
    private lateinit var storedVerificationId: String
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    lateinit var auth: FirebaseAuth
    private var user: User? = null
    val TAG = "mmm"
    private val TIME_FOR_TIMER = 60000L
    private var timer = 60
    lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile_verification)
        auth = Firebase.auth
        try {
            user = intent.getParcelableExtra("user")!!

        } catch (e: Exception) {
            e.printStackTrace()
        }
        try {
            mobileNumber = intent.getStringExtra("mobileNumber")!!
            Toast.makeText(this, "جاري التحقق من $mobileNumber", Toast.LENGTH_LONG).show()
            Log.d(TAG, "-------------> $mobileNumber <-------------")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        countDownTimer = object : CountDownTimer(TIME_FOR_TIMER, 1000L) {

            override fun onTick(p0: Long) {
                tvTimer.text = (timer--).toString()
            }

            override fun onFinish() {
                btnReSend.visibility = View.VISIBLE
                progressBarMobileWait.visibility = View.GONE
                tvTimer.text = "0"
                timer = 60
            }

        }
        //----------------
        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                // This callback will be invoked in two situations:
                // 1 - Instant verification. In some cases the phone number can be instantly
                //     verified without needing to send or enter a verification code.
                // 2 - Auto-retrieval. On some devices Google Play services can automatically
                //     detect the incoming verification SMS and perform verification without
                //     user action.
                Log.d(TAG, "onVerificationCompleted:$credential")
                smsCode = credential.smsCode
                //   signInWithPhoneAuthCredential(credential)

            }

            override fun onVerificationFailed(e: FirebaseException) {
                // This callback is invoked in an invalid request for verification is made,
                // for instance if the the phone number format is not valid.
                Log.w(TAG, "onVerificationFailed", e)
                clearAll()
                if (e is FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                    // ...
                    Log.e(TAG, "Invalid Request")
                    e.printStackTrace()
                    Toast.makeText(
                        applicationContext,
                        "طلب خاطئ !!. أبلغنا عن الخطأ من فضلك",
                        Toast.LENGTH_LONG
                    ).show()
                } else if (e is FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                    // ...
                    Log.e(TAG, "The SMS quota for the project has been exceeded")
                    e.printStackTrace()
                    Toast.makeText(applicationContext, "خطأ في حجم الرسالة !!", Toast.LENGTH_LONG)
                        .show()
                }

                // Show a message and update the UI
                // ...
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
                Log.d(TAG, "onCodeSent:$verificationId")

                // Save verification ID and resending token so we can use them later
                storedVerificationId = verificationId
                resendToken = token

                // ...
                progressBarMobileWait.visibility = View.VISIBLE
                btnReSend.visibility = View.GONE
                countDownTimer.start()
            }
        }
        sendVerification()


    }

    private fun clearAll() {
        etNum1.text.clear()
        etNum2.text.clear()
        etNum3.text.clear()
        etNum4.text.clear()
        etNum5.text.clear()
        etNum6.text.clear()
        etNum1.requestFocus()
    }

    override fun onStart() {
        super.onStart()
        etNum1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().trim().isNotEmpty())
                    etNum2.requestFocus()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        etNum2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().trim().isNotEmpty())
                    etNum3.requestFocus()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        etNum3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().trim().isNotEmpty())
                    etNum4.requestFocus()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        etNum4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().trim().isNotEmpty())
                    etNum5.requestFocus()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        etNum5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().trim().isNotEmpty())
                    etNum6.requestFocus()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        etNum6.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().trim().isNotEmpty())
                    codeEnteredListener()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        btnVerify.setOnClickListener { codeEnteredListener() }
        btnReSend.setOnClickListener { sendVerification() }

    }

    private fun sendVerification() {
        if (user != null) {
            verfiyPhoneNumber(mobileNumber)

        } else {
            Toast.makeText(this, "هناك خطأ في العملية", Toast.LENGTH_LONG).show()

        }
    }

    private fun verfiyPhoneNumber(phoneNumber: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)       // Phone number to verify
            .setTimeout(TIME_FOR_TIMER.toLong(), TimeUnit.MILLISECONDS) // Timeout and unit
            .setActivity(this)                 // Activity (for callback binding)
            .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    /*    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
            auth.signInWithCredential(credential)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        doWhenUpdateFinish()
                        Log.d(TAG, "signInWithCredential:success")

                      //  val user = task.result?.user
                        // ...
                    } else {
                        clearAll()
                        // Sign in failed, display a message and update the UI
                        Log.w(TAG, "signInWithCredential:failure", task.exception)
                        if (task.exception is FirebaseAuthInvalidCredentialsException) {
                            // The verification code entered was invalid
                        }

                    }
                }
        }*/
    fun isAll6NumbersEntered(
        text1: String,
        text2: String,
        text3: String,
        text4: String,
        text5: String,
        text6: String
    ): Boolean {
        return (text1.isNotEmpty() && text2.isNotEmpty() && text3.isNotEmpty() && text4.isNotEmpty() && text5.isNotEmpty() && text6.isNotEmpty())
    }

    private fun codeEnteredListener() {
        if (
            isAll6NumbersEntered(
                etNum1.text.toString(),
                etNum2.text.toString(),
                etNum3.text.toString(),
                etNum4.text.toString(),
                etNum5.text.toString(),
                etNum6.text.toString()
            )
        ) {

            //All completed
            code = ""
            code += etNum1.text.toString().trim()
            code += etNum2.text.toString().trim()
            code += etNum3.text.toString().trim()
            code += etNum4.text.toString().trim()
            code += etNum5.text.toString().trim()
            code += etNum6.text.toString().trim()
            //check code
            val id = getSharedPreferences("RegPref", MODE_PRIVATE).getString("userId", "")

            if (code == smsCode)
                updateMobileNumber(id!!, user!!.mobile!!)
            else
                Toast.makeText(this, "رمز التحقق خاطئ. \nأعد المحاولة من فضلك", Toast.LENGTH_LONG)
                    .show()

        } else
            Toast.makeText(this, "يجب عليك ملئ جميع الأرقام", Toast.LENGTH_LONG).show()
    }

    private fun doWhenUpdateFinish() {
        try {
            countDownTimer.onFinish()
            countDownTimer.cancel()
            // add intent for home screen here
            val mInt = Intent(this, MapsActivityRegisteration::class.java)
            startActivity(mInt)
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
        Toast.makeText(this, "Mobile number added successfully", Toast.LENGTH_LONG).show()
    }

    private fun updateMobileNumber(id: String, number: String) {
        Firebase.firestore.collection("users").document(id).update("mobile", number)
            .addOnSuccessListener {
                doWhenUpdateFinish()
            }
            .addOnFailureListener {
                Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
                updateMobileNumber(id, number)
            }
    }
}