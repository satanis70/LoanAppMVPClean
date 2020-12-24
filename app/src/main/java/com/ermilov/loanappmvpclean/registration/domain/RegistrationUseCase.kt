package com.ermilov.loanappmvpclean.registration.domain

import com.ermilov.loanappmvpclean.registration.data.model.UserModel
import com.ermilov.loanappmvpclean.registration.domain.repository.RegistrationRepository
import io.reactivex.Single

class RegistrationUseCase(private val registrationRepository: RegistrationRepository)  {

    operator fun invoke(username: String, password: String) : Single<UserModel> =
        registrationRepository.registration(username, password)

}