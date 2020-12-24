package com.ermilov.loanappmvpclean.registration.data.datasource

import com.ermilov.loanappmvpclean.registration.data.model.UserModel
import com.ermilov.loanappmvpclean.registration.data.network.LoanApiServicesRegistration
import com.ermilov.loanappmvpclean.registration.data.network.RetrofitRegistration
import io.reactivex.Single
import retrofit2.Call

class RegistrationDataSourceImpl: RegistrationDataSource{

    companion object{
        val service = RetrofitRegistration().getRetrofitService()
    }

    override fun registration(username: String, password: String): Single<UserModel> =
        service.createUser(UserModel(name = username, password = password))
}