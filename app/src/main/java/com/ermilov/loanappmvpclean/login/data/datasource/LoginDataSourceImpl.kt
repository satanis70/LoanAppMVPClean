package com.ermilov.loanappmvpclean.login.data.datasource

import com.ermilov.loanappmvpclean.login.data.network.RetrofitLogin
import com.ermilov.loanappmvpclean.registration.data.model.UserModel
import com.ermilov.loanappmvpclean.registration.data.network.RetrofitRegistration
import io.reactivex.Single

class LoginDataSourceImpl: LoginDataSource {
    companion object{
        val service = RetrofitLogin().getRetrofitService()
    }

    override fun login(username: String, password: String): Single<String> =
        service.signIn(UserModel(name = username, password =  password))

}