package com.ermilov.loanappmvpclean.registration.ui.interfaces

interface RegistrationView {

    fun showUserNameError()
    fun showPasswordError()
    fun registrationSuccess()
    fun showToastError(error: Int)
}