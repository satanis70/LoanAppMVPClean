package com.ermilov.loanappmvpclean.login.data.repository

import com.ermilov.loanappmvpclean.login.data.datasource.LoginDataSource
import com.ermilov.loanappmvpclean.login.domain.repository.LoginRepository
import com.ermilov.loanappmvpclean.registration.data.model.UserModel
import io.reactivex.Single

class LoginRepositoryImpl(private val dataSource: LoginDataSource): LoginRepository {
    override fun login(username: String, password: String): Single<String> =
            dataSource.login(username = username, password = password)
}