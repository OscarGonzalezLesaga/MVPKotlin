package com.everis.mvpkotlin.login.presenter

interface ILoginPresenter {
    fun manageLoginUser(user: String, password: String)
}