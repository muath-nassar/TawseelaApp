package com.muath.tawseelaapp.muath.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.muath.tawseelaapp.R
import kotlinx.android.synthetic.main.fragment_login.*
import com.muath.tawseelaapp.muath.RegistrationActivity
import com.muath.tawseelaapp.muath.applogic.AuthenticationListener
import com.muath.tawseelaapp.muath.applogic.Registration


class LoginFragment : Fragment(), AuthenticationListener {
    lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_login, container, false)
        return root
    }

    override fun onResume() {
        super.onResume()
        btnClickRegisterNew.setOnClickListener {
            val mActivity = activity as RegistrationActivity
            mActivity.swipeFragment(mActivity.signUpFragment)
        }
        //press on login
        btnLogin.setOnClickListener {
            if (isAllFieldsCompleted()){
                val credentials = getUsernameAndPasswordWitTrim()
                loginUser(credentials["username"],credentials["password"])
            }else{
                Toast.makeText(activity,"من فضلك أدخل اسم المستخدم و كلمة المرور",Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun loginUser(username: CharSequence?, password: CharSequence?) {
       Registration(activity!!).loginWithUsernameAndPassword(username.toString(),password.toString(),this)
    }

    private fun isAllFieldsCompleted(): Boolean{
        return (etUsername.text!!.isNotEmpty() && etPassword.text!!.isNotEmpty())
    }
    private fun getUsernameAndPasswordWitTrim():Map<String,CharSequence>{
        return mapOf("username" to etUsername.text!!.toString().trim(),"password" to etPassword.text!!.toString().trim() )
    }

    override fun onAuthenticated() {

    }

    override fun onError() {

    }

    override fun onLoggedIn() {
        Toast.makeText(context,"تمت عملية التأكيد بنحاح",Toast.LENGTH_LONG).show()
        //do if mobile authenticated

        //do if mobile not authenticated

    }

    override fun onLogFail() {
        Toast.makeText(context,"هناك خطأ في عملية التحقق",Toast.LENGTH_LONG).show()
    }


}