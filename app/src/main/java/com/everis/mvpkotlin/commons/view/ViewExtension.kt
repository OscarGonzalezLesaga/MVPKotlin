package com.everis.mvpkotlin.commons.view

import android.support.design.widget.Snackbar

fun BaseActivity.showSnackbar(title: String, duration: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(this.window.decorView.rootView, title, duration).show()
}