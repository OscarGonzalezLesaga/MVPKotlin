package com.everis.mvpkotlin

import com.everis.mvpkotlin.login.presenter.ILoginPresenter
import com.everis.mvpkotlin.login.presenter.LoginPresenter
import com.everis.mvpkotlin.login.view.LoginView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class LoginTest {

    @Mock
    lateinit var view: LoginView

    lateinit var presenter: ILoginPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = LoginPresenter(view)
    }

    @Test
    fun testManageEmptyLogin() {
        presenter.manageLoginUser("", "")
        verify(view, times(1)).manageEmptyLogin()
    }

    @Test
    fun testManageEmptyUserLogin() {
        presenter.manageLoginUser("", "testing")
        verify(view, times(1)).manageEmptyUser()
    }

    @Test
    fun testManageEmptyPasswordLogin() {
        presenter.manageLoginUser("testing", "")
        verify(view, times(1)).manageEmptyPassword()
    }

    @Test
    fun testManageErrorLogin() {
        presenter.manageLoginUser("testing", "testing")
        verify(view, times(1)).manageErrorLogin()
    }

    @Test
    fun testCorrectLogin() {
        presenter.manageLoginUser("TallerMVP", "123456")
        verify(view, times(1)).manageLoginOk()
    }


}