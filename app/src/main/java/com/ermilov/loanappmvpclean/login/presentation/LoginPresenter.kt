package com.ermilov.loanappmvpclean.login.presentation

import com.ermilov.loanappmvpclean.login.ui.LoginActivity
import com.ermilov.loanappmvpclean.login.ui.interfaces.LoginView
import com.ermilov.loanappmvpclean.registration.ui.interfaces.RegistrationView

interface LoginPresenter {

    fun attachView(view: LoginView)
    fun detachView()
    fun onLoginButtonClicked(userName: String, password: String)
    fun isNameValid(userName: String) : Boolean
    fun isPasswordValid(password: String) : Boolean

}