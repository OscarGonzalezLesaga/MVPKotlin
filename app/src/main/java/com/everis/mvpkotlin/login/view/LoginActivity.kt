package com.everis.mvpkotlin.login.view

import android.content.Intent
import android.view.View
import com.everis.mvpkotlin.R
import com.everis.mvpkotlin.commons.view.BaseActivity
import com.everis.mvpkotlin.commons.view.showSnackbar
import com.everis.mvpkotlin.listEmployees.view.ListEmployeesActivity
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
        showSnackbar(getString(R.string.error_incorrect_login))
    }

    override fun manageLoginOk() {
        var intent = Intent(this, ListEmployeesActivity::class.java)
        startActivity(intent)
    }

    override fun manageEmptyUser() {
        showSnackbar(getString(R.string.error_empty_user))
    }

    override fun manageEmptyPassword() {
        showSnackbar(getString(R.string.error_empty_password))
    }

    override fun manageEmptyLogin() {
        showSnackbar(getString(R.string.error_empty_login))
    }

    override fun onClick(view: View?) {
        when (view) {
            buttonRegister -> {
                presenter.manageLoginUser(userLoginEditText.text.toString(), passwordLoginEditText.text.toString())
            }
        }
    }


}
