package com.everis.mvpkotlin.login.view

import android.view.View
import com.everis.mvpkotlin.R
import com.everis.mvpkotlin.commons.view.BaseActivity
import com.everis.mvpkotlin.login.presenter.ILoginPresenter
import com.everis.mvpkotlin.login.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginView, View.OnClickListener {


    lateinit var presenter: ILoginPresenter

    override val layoutResource: Int
        get() = R.layout.activity_login

    override fun linkView() {
        buttonRegister.setOnClickListener(this)
    }

    override fun linkPresenter() {
        presenter = LoginPresenter(this)
    }

    override fun logic() {
    }

    override fun manageErrorLogin() {

    }

    override fun manageLoginOk() {
    }

    override fun manageEmptyUser() {
    }

    override fun manageEmptyPassword() {
    }

    override fun manageEmptyLogin() {

    }

    override fun onClick(view: View?) {
        when (view) {
            buttonRegister -> {
                presenter.manageLoginUser(userLoginEditText.text.toString(), passwordLoginEditText.text.toString())
            }
        }
    }


}
