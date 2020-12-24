package com.ermilov.loanappmvpclean.registration.domain.repository

import com.ermilov.loanappmvpclean.registration.data.model.UserModel
import io.reactivex.Single

interface RegistrationRepository {
    fun registration(username:String, password:String): Single<UserModel>
}