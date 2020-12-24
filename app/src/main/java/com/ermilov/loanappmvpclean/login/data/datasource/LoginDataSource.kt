package com.ermilov.loanappmvpclean.login.data.datasource

import com.ermilov.loanappmvpclean.registration.data.model.UserModel
import io.reactivex.Single

interface LoginDataSource {
    fun login(username:String, password:String): Single<String>
}