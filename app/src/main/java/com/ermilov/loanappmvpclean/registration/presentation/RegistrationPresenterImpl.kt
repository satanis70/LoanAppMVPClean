package com.ermilov.loanappmvpclean.registration.presentation

import android.util.Log
import android.util.Patterns
import com.ermilov.loanappmvpclean.R
import com.ermilov.loanappmvpclean.registration.data.model.UserModel
import com.ermilov.loanappmvpclean.registration.domain.RegistrationUseCase
import com.ermilov.loanappmvpclean.registration.ui.interfaces.RegistrationView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RegistrationPresenterImpl(private val registrationUseCase: RegistrationUseCase)
    : RegistrationPresenter{

    private var view: RegistrationView? = null
    var disposable: Disposable? = null

    override fun attachView(view: RegistrationView) {
        this.view = view
    }

    override fun detachView() {
        this.disposable?.dispose()
        this.disposable = null
        this.view = null
    }

    override fun onRegistrationButtonClicked(userName: String, password: String) {

        disposable = registrationUseCase(userName, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe ({ success -> handleRegistrationSucces(success) },
                    {error -> doOnError(error)})
    }

    override fun isNameValid(userName: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(userName).matches()
    }

    override fun isPasswordValid(password: String): Boolean {
        return password.length>4
    }

    private fun doOnError(e: Throwable){
        Log.e("MSGREG", e.message.toString())
        if (e.message.toString() == "HTTP 400 "){
            view?.showToastError(R.string.dublicateRegistration)
        }
    }

    private fun handleRegistrationSucces(msg: UserModel){
        if (msg.toString() == "HTTP 400 "){
            view?.showToastError(R.string.dublicateRegistration)
        } else {
            Log.i("MSGREG", msg.name.toString()+msg.password.toString())
            view?.registrationSuccess()
        }

    }



}