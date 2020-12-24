package com.ermilov.loanappmvpclean.login.data.network

import com.ermilov.loanappmvpclean.registration.data.model.UserModel
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoanApiLogin {
    @Headers("Content-Type: application/json")
    @POST("login")
    fun signIn(@Body userModel: UserModel): Single<String>
}