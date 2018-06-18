package com.everis.mvpkotlin.login.model

import android.support.annotation.IntDef

class TypeErrorLogin {

    companion object {
        const val USER_EMPTY = 0
        const val PASSWORD_EMPTY = 1
        const val ALL_EMPTY = 2
        const val PARAMS_OK = 3
    }

    @Target(AnnotationTarget.TYPE)
    @IntDef(USER_EMPTY, PASSWORD_EMPTY, ALL_EMPTY, PARAMS_OK)
    @Retention(AnnotationRetention.SOURCE)
    annotation class TypeError
}