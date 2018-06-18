package com.everis.mvpkotlin.login.view

interface LoginView {

    fun manageEmptyUser()

    fun manageEmptyPassword()

    fun manageEmptyLogin()

    fun manageErrorLogin()

    fun manageLoginOk()
}