package com.ermilov.loanappmvpclean.registration.data.network

import com.ermilov.loanappmvpclean.util.Constans
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitRegistration {

    private val gson = GsonBuilder()
                .setLenient()
                .create()

       private var  retrofit = Retrofit.Builder()
                .baseUrl(Constans.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()


    private var registrationService = retrofit
            .create(LoanApiServicesRegistration::class.java)

    fun getRetrofitService(): LoanApiServicesRegistration {
        return this.registrationService
    }
}