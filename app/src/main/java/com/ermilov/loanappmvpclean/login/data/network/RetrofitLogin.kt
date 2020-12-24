package com.ermilov.loanappmvpclean.login.data.network

import com.ermilov.loanappmvpclean.util.Constans
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitLogin {

    private val gson = GsonBuilder()
            .setLenient()
            .create()

    private val retrofit = Retrofit.Builder()
            .baseUrl(Constans.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    private var loginservice = retrofit.create(LoanApiLogin::class.java)

    fun getRetrofitService(): LoanApiLogin{
        return this.loginservice
    }

}