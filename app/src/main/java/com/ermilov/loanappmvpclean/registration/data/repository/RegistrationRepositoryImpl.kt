package com.ermilov.loanappmvpclean.registration.data.repository

import com.ermilov.loanappmvpclean.registration.data.datasource.RegistrationDataSource
import com.ermilov.loanappmvpclean.registration.data.model.UserModel
import com.ermilov.loanappmvpclean.registration.domain.repository.RegistrationRepository
import io.reactivex.Single

class RegistrationRepositoryImpl(private val dataSource: RegistrationDataSource) : RegistrationRepository {
    override fun registration(username: String, password: String): Single<UserModel> =
        dataSource.registration(username, password)
}