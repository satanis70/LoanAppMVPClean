package com.ermilov.loanappmvpclean.registration.data.model

import com.google.gson.annotations.SerializedName

class UserModel (
    @SerializedName("name")
    val name: String?,
    @SerializedName("password")
    val password: String?
)