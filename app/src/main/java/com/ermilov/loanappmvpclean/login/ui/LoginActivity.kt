package com.ermilov.loanappmvpclean.login.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ermilov.loanappmvpclean.R
import com.ermilov.loanappmvpclean.login.di.LoginPresenterFactory
import com.ermilov.loanappmvpclean.login.presentation.LoginPresenter
import com.ermilov.loanappmvpclean.login.ui.interfaces.LoginView
import kotlinx.android.synthetic.main.login_activity.*


class LoginActivity : AppCompatActivity(), LoginView {
    private var loginPresenter: LoginPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        loginPresenter = LoginPresenterFactory.create()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        loginPresenter?.attachView(this)
        buttonSignIn.setOnClickListener {
            onLoginClick()
        }
    }

    override fun showUserNameError() {
        Toast.makeText(applicationContext, R.string.inputCorrectEmail,
                Toast.LENGTH_SHORT).show()
    }

    override fun showPasswordError() {
        Toast.makeText(applicationContext, R.string.inputCorrectPassword,
                Toast.LENGTH_SHORT).show()
    }

    override fun loginSuccess() {
        Toast.makeText(applicationContext, R.string.succesulLogin, Toast.LENGTH_SHORT).show()
    }

    override fun showToastError(error: Int) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show()
    }

    private fun onLoginClick(){
        val username = editNameSignIn.text.toString()
        val password = editPasswordSignIn.text.toString()
        if (loginPresenter?.isNameValid(username)==true&&loginPresenter?.isPasswordValid(password)==true){
            loginPresenter?.onLoginButtonClicked(username, password)
        } else if (username.isEmpty()||password.isEmpty()) {
                Toast.makeText(applicationContext, R.string.inputLoginPassword, Toast.LENGTH_SHORT).show()
            } else if(loginPresenter?.isNameValid(username)==false){
                showUserNameError()
            } else if(loginPresenter?.isPasswordValid(password)==false){
                showPasswordError()
            }
        }

}
