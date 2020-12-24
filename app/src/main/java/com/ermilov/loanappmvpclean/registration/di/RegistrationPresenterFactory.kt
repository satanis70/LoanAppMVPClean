package com.ermilov.loanappmvpclean.registration.di

import com.ermilov.loanappmvpclean.registration.data.datasource.RegistrationDataSourceImpl
import com.ermilov.loanappmvpclean.registration.data.repository.RegistrationRepositoryImpl
import com.ermilov.loanappmvpclean.registration.domain.RegistrationUseCase
import com.ermilov.loanappmvpclean.registration.presentation.RegistrationPresenter
import com.ermilov.loanappmvpclean.registration.presentation.RegistrationPresenterImpl

object RegistrationPresenterFactory {

    fun create() : RegistrationPresenter{
        val registrationDataSource = RegistrationDataSourceImpl()
        val registrationRepository = RegistrationRepositoryImpl(registrationDataSource)
        val registrationUseCase = RegistrationUseCase(registrationRepository)

        return RegistrationPresenterImpl(registrationUseCase)
    }

}