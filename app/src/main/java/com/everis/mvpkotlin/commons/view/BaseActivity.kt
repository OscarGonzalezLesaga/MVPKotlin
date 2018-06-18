package com.everis.mvpkotlin.commons.view

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource)
        linkView()
        linkPresenter()
        logic()
    }


    @get:LayoutRes
    protected abstract val layoutResource: Int

    abstract fun linkView()
    abstract fun linkPresenter()
    abstract fun logic()
}
