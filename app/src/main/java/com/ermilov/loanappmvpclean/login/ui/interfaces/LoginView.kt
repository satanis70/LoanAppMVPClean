package com.ermilov.loanappmvpclean.login.ui.interfaces

interface LoginView {
    fun showUserNameError()
    fun showPasswordError()
    fun loginSuccess()
    fun showToastError(error: Int)
}