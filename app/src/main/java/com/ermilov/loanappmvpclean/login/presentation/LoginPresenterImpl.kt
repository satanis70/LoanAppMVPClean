package com.ermilov.loanappmvpclean.login.presentation

import android.util.Log
import android.util.Patterns
import com.ermilov.loanappmvpclean.R
import com.ermilov.loanappmvpclean.login.domain.LoginUseCase
import com.ermilov.loanappmvpclean.login.ui.interfaces.LoginView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class LoginPresenterImpl(private val loginUseCase: LoginUseCase) : LoginPresenter{

    private var view: LoginView? = null
    var disposable: Disposable? = null

    override fun attachView(view: LoginView) {
        this.view = view
    }

    override fun detachView() {
        this.disposable?.dispose()
        this.disposable = null
        this.view = null
    }

    override fun onLoginButtonClicked(userName: String, password: String) {
        disposable = loginUseCase(userName, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success -> handleRegistrationSucces(success) },
                        {error -> doOnError(error)})
    }

    override fun isNameValid(userName: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(userName).matches()
    }

    override fun isPasswordValid(password: String): Boolean {
        return password.length>4
    }

    private fun doOnError(e: Throwable){
        Log.e("MSGLOG", e.message.toString())
        if (e.message.toString() == "HTTP 404 "){
            view?.showToastError(R.string.loginerror)
        }
    }

    private fun handleRegistrationSucces(msg: String){
        if (msg == "HTTP 404 "){
            view?.showToastError(R.string.loginerror)
        } else {
            Log.i("MSGLOG", msg)
            view?.loginSuccess()
        }

    }
}