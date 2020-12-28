package com.muath.tawseelaapp.muath.applogic

interface AuthenticationListener {
    fun onAuthenticated()
    fun onError()
    fun onLoggedIn()
    fun onLogFail()
}