package com.everis.mvpkotlin.login.view

import com.everis.mvpkotlin.R
import com.everis.mvpkotlin.commons.view.BaseActivity

class LoginActivity : BaseActivity(), LoginView {

    override val layoutResource: Int
        get() = R.layout.activity_login

    override fun linkView() {
    }

    override fun linkPresenter() {
    }

    override fun logic() {
    }

    override fun showErrorLogin() {
    }

    override fun manageLoginOk() {
    }

}
