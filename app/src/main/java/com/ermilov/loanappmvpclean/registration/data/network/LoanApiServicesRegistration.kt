package com.ermilov.loanappmvpclean.registration.data.network

import com.ermilov.loanappmvpclean.registration.data.model.UserModel
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoanApiServicesRegistration {
    @Headers("Content-Type: application/json")
    @POST("registration")
    fun createUser(@Body userData: UserModel): Single<UserModel>
}