package com.everis.mvpkotlin.login.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.everis.mvpkotlin.R

class LoginActivity : AppCompatActivity(), LoginView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
