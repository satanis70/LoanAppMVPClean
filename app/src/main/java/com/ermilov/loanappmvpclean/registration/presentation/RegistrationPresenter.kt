package com.ermilov.loanappmvpclean.registration.presentation

import com.ermilov.loanappmvpclean.registration.ui.interfaces.RegistrationView

interface RegistrationPresenter {

    fun attachView(view: RegistrationView)
    fun detachView()
    fun onRegistrationButtonClicked(userName: String, password: String)
    fun isNameValid(userName: String) : Boolean
    fun isPasswordValid(password: String) : Boolean
}