package com.ermilov.loanappmvpclean.login.di

import com.ermilov.loanappmvpclean.login.data.datasource.LoginDataSourceImpl
import com.ermilov.loanappmvpclean.login.data.repository.LoginRepositoryImpl
import com.ermilov.loanappmvpclean.login.domain.LoginUseCase
import com.ermilov.loanappmvpclean.login.presentation.LoginPresenter
import com.ermilov.loanappmvpclean.login.presentation.LoginPresenterImpl

object LoginPresenterFactory {

    fun create(): LoginPresenter{
        val loginDataSource = LoginDataSourceImpl()
        val loginRepository = LoginRepositoryImpl(loginDataSource)
        val loginUseCase = LoginUseCase(loginRepository)

        return LoginPresenterImpl(loginUseCase)

    }
}