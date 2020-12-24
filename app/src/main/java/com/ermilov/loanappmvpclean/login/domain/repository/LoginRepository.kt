package com.ermilov.loanappmvpclean.login.domain.repository

import com.ermilov.loanappmvpclean.registration.data.model.UserModel
import io.reactivex.Single

interface LoginRepository {
    fun login(username: String, password:String): Single<String>
}