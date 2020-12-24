package com.ermilov.loanappmvpclean.login.domain

import com.ermilov.loanappmvpclean.login.domain.repository.LoginRepository
import com.ermilov.loanappmvpclean.registration.data.model.UserModel
import io.reactivex.Single

class LoginUseCase(private val loginRepository: LoginRepository) {
    operator fun invoke(username:String, password:String) : Single<String> =
            loginRepository.login(username, password)
}