package com.everis.mvpkotlin.login.presenter

import com.everis.mvpkotlin.login.model.TypeErrorLogin
import com.everis.mvpkotlin.login.model.TypeErrorLogin.Companion.ALL_EMPTY
import com.everis.mvpkotlin.login.model.TypeErrorLogin.Companion.PARAMS_OK
import com.everis.mvpkotlin.login.model.TypeErrorLogin.Companion.PASSWORD_EMPTY
import com.everis.mvpkotlin.login.model.TypeErrorLogin.Companion.USER_EMPTY
import com.everis.mvpkotlin.login.view.LoginView

class LoginPresenter(private val view: LoginView) : ILoginPresenter {

    private val USER_OK = "TallerMVP"
    private val PASSWORD = "123456"

    override fun manageLoginUser(user: String, password: String) {
        when (isParamsLoginCorrect(user, password)) {
            ALL_EMPTY -> view.manageEmptyLogin()
            USER_EMPTY -> view.manageEmptyUser()
            PASSWORD_EMPTY -> view.manageEmptyPassword()
            PARAMS_OK -> {
                if (USER_OK == user && PASSWORD == password) {
                    view.manageLoginOk()
                } else {
                    view.manageErrorLogin()
                }
            }
        }

    }

    private fun isParamsLoginCorrect(user: String, password: String): @TypeErrorLogin.TypeError Int {
        return if (user.isNullOrEmpty() && password.isNullOrEmpty()) {
            ALL_EMPTY
        } else {
            when {
                user.isNullOrEmpty() -> USER_EMPTY
                password.isNullOrEmpty() -> PASSWORD_EMPTY
                else -> PARAMS_OK
            }
        }
    }
}