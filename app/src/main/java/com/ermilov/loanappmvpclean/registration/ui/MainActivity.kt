package com.ermilov.loanappmvpclean.registration.ui

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.ermilov.loanappmvpclean.R
import com.ermilov.loanappmvpclean.login.ui.LoginActivity
import com.ermilov.loanappmvpclean.registration.di.RegistrationPresenterFactory
import com.ermilov.loanappmvpclean.registration.presentation.RegistrationPresenter
import com.ermilov.loanappmvpclean.registration.ui.interfaces.RegistrationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RegistrationView {
    private var registrationPresenter: RegistrationPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        registrationPresenter = RegistrationPresenterFactory.create()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registrationPresenter?.attachView(this)
        buttonRegistration.setOnClickListener {
            onRegistrationClick()
        }

        textViewSignIn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
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

    private fun onRegistrationClick(){
        val userName = editName.text.toString()
        val userPassword = editPassword.text.toString()
        if (registrationPresenter?.isNameValid(userName)==true &&
                registrationPresenter?.isPasswordValid(userPassword)==true){
            registrationPresenter?.onRegistrationButtonClicked(userName, userPassword)
        } else if (userName.isEmpty()||userPassword.isEmpty()) {
            Toast.makeText(applicationContext, R.string.inputLoginPassword, Toast.LENGTH_SHORT).show()
        } else if(registrationPresenter?.isNameValid(userName)==false){
            showUserNameError()
        } else if(registrationPresenter?.isPasswordValid(userPassword)==false){
            showPasswordError()
        }
    }

    override fun registrationSuccess() {
        Toast.makeText(applicationContext, R.string.succesulRegistration, Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun showToastError(error: Int) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
         if (id == R.id.change_theme) {
            when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
                Configuration.UI_MODE_NIGHT_YES ->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                Configuration.UI_MODE_NIGHT_NO ->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
        return super.onOptionsItemSelected(item)
    }



}