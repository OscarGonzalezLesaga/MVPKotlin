package com.everis.mvpkotlin

import com.everis.mvpkotlin.listEmployees.model.entities.Employee
import com.everis.mvpkotlin.listEmployees.model.service.IListEmployeesService
import com.everis.mvpkotlin.listEmployees.presenter.IListEmployeesPresenter
import com.everis.mvpkotlin.listEmployees.presenter.ListEmployeesPresenter
import com.everis.mvpkotlin.listEmployees.view.ListEmployeesView
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import org.mockito.Mockito.`when` as whenever

class ListEmployeesPresenterTest {
    @Mock
    lateinit var view: ListEmployeesView

    @Mock
    lateinit var callEmployees: Call<List<Employee>>

    lateinit var responseOk: Response<List<Employee>>

    @Mock
    lateinit var listEmployees: List<Employee>

    @Mock
    lateinit var service: IListEmployeesService

    lateinit var presenter: IListEmployeesPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = ListEmployeesPresenter(view, service)
        responseOk = Response.success(listEmployees)
    }

    @Test
    fun testLoadListEmployeesOK() {
        whenever(service.getListEmployees()).thenReturn(callEmployees)
        Mockito.doAnswer {
            var callback = it.getArgument(0) as Callback<List<Employee>>
            callback.onResponse(callEmployees, responseOk)
        }.`when`(callEmployees).enqueue(ArgumentMatchers.any())

        presenter.getListEmployees()
        Mockito.verify(view, Mockito.times(1)).showListEmployees(listEmployees)
    }

    @Test
    fun testLoadListEmployeesIncorrect() {
        whenever(service.getListEmployees()).thenReturn(callEmployees)
        Mockito.doAnswer {
            var callback = it.getArgument(0) as Callback<List<Employee>>
            callback.onFailure(callEmployees, Throwable())
        }.`when`(callEmployees).enqueue(ArgumentMatchers.any())

        presenter.getListEmployees()
        Mockito.verify(view, Mockito.times(1)).showErrorServer()
    }


}