package br.com.fiap.projetofiapesg.screens.loginpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginPageViewModel: ViewModel() {

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    fun onEmailChange(email : String){
        _email.value = email
    }

    fun onPasswordChange(password: String){
        _password.value = password
    }
}