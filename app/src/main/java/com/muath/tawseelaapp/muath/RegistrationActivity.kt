package com.muath.tawseelaapp.muath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.muath.tawseelaapp.R
import com.muath.tawseelaapp.muath.fragments.LoginFragment
import com.muath.tawseelaapp.muath.fragments.SignUpFragment

class RegistrationActivity : AppCompatActivity() {
    lateinit var  loginFragment : LoginFragment
    lateinit var  signUpFragment: SignUpFragment
    lateinit var fm : FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        fm = supportFragmentManager
        loginFragment = LoginFragment()
        signUpFragment = SignUpFragment()
       swipeFragment(loginFragment)

    }
    fun swipeFragment(fragment: Fragment){
        fm.beginTransaction().replace(R.id.mainFrame,fragment).commit()
    }
}