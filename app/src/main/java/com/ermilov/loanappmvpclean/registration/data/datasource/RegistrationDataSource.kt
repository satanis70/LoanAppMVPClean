package com.ermilov.loanappmvpclean.registration.data.datasource

import com.ermilov.loanappmvpclean.registration.data.model.UserModel
import io.reactivex.Single

interface RegistrationDataSource {
    fun registration(username: String, password: String): Single<UserModel>
}