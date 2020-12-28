package com.muath.tawseelaapp.muath.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.muath.tawseelaapp.R
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.etPassword
import kotlinx.android.synthetic.main.fragment_login.etUsername
import kotlinx.android.synthetic.main.fragment_sign_up.*
import com.muath.tawseelaapp.muath.MobileVerificationActivity
import com.muath.tawseelaapp.muath.RegistrationActivity
import com.muath.tawseelaapp.muath.applogic.AuthenticationListener
import com.muath.tawseelaapp.muath.applogic.Registration
import com.muath.tawseelaapp.muath.applogic.Validation

import com.muath.tawseelaapp.muath.models.User

class SignUpFragment : Fragment(), AuthenticationListener {
    private lateinit var user: User
    private lateinit var root: View
    lateinit var documentId:String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_sign_up, container, false)
        return root
    }

    override fun onResume() {
        super.onResume()


        btnClickLogin.setOnClickListener {
            val mActivity = activity as RegistrationActivity
            mActivity.swipeFragment(mActivity.loginFragment)
        }
        btnSignUp.setOnClickListener {
                if (validateInputs()){
                    registerNewUser()
                }
        }
    }

    //methods
    private fun isAllFieldsCompleted(): Boolean{
        return (etUsername.text!!.isNotEmpty() && etPassword.text!!.isNotEmpty() && etMobile.text!!.isNotEmpty())
    }
    private fun sendMobileForVerification(user: User){
        val mIntent = Intent(activity, MobileVerificationActivity::class.java)
        mIntent.putExtra("user",user)
        mIntent.putExtra("mobileNumber" , "+970"+etMobile.text.toString())
        activity!!.startActivity(mIntent)
    }

    private fun validateInputs(): Boolean{
        val pass = etPassword.text.toString()
        val username = etUsername.text.toString()+"@testapp.com"
        val mobile = etMobile.text.toString()
        if (pass.length >= 8
            && Validation.email(username)
            && mobile.length == 9
            && Validation.hasNumber(pass)
            && Validation.isNumeric(mobile)
                ) return true
        return false
    }

    private fun registerNewUser(){
        if (isAllFieldsCompleted()){
            user = User(
                etUsername.text.toString().trim(),
                "+970"+etMobile.text.toString()
            )
            val email = etUsername.text.toString().trim()+"@testapp.com"
            Registration(activity!!).addNewUserToAuth(email,etPassword.text.toString(),this)


        }

    }

    override fun onAuthenticated() {
        sendMobileForVerification(user)
    }

    override fun onError() {
        Toast.makeText(activity,"يجب ملئ جميع المعلومات",Toast.LENGTH_LONG).show()
    }

    override fun onLoggedIn() {

    }

    override fun onLogFail() {
    }


}