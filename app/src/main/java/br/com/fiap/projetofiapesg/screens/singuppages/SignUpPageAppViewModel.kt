package br.com.fiap.projetofiapesg.screens.singuppages

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.IO_PARALLELISM_PROPERTY_NAME

class SignUpPageAppViewModel: ViewModel() {

    private val _checkError = MutableLiveData<Boolean>()
    val checkError: LiveData<Boolean> = _checkError

    private val _razaoSocial = MutableLiveData<String>()
    val razaoSocial : LiveData<String> = _razaoSocial

    private val _cargo = MutableLiveData<String>()
    val cargo : LiveData<String> = _cargo

    private val _cnpj = MutableLiveData<String>()
    val cnpj : LiveData<String> = _cnpj

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _confirmPassword = MutableLiveData<String>()
    val confirmPassword : LiveData<String> = _confirmPassword

    fun onCheckError(error: Boolean){
        _checkError.value = error
    }

    fun onRazaoSocial(razaoSocial : String){
        _razaoSocial.value = razaoSocial
    }

    fun onCargoChange(cargo: String){
        _cargo.value = cargo
    }

    fun onCnpjChange(cnpj: String){
        _cnpj.value = cnpj
    }

    fun onEmailChange(email: String){
        _email.value = email
    }

    fun onPasswordChange(password: String){
        _password.value = password
    }

    fun confirmPassword(confirm: String){
        _confirmPassword.value = confirm
    }
}