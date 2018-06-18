package com.everis.mvpkotlin.listEmployees.presenter

import com.everis.mvpkotlin.listEmployees.model.entities.Employee
import com.everis.mvpkotlin.listEmployees.model.service.IListEmployeesService
import com.everis.mvpkotlin.listEmployees.model.service.ListEmployeesService
import com.everis.mvpkotlin.listEmployees.view.ListEmployeesView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListEmployeesPresenter(private var view: ListEmployeesView) : IListEmployeesPresenter, Callback<List<Employee>> {

    var service: IListEmployeesService = ListEmployeesService()

    override fun getListEmployees() {
        service.getListEmployees().enqueue(this)
    }

    override fun onFailure(call: Call<List<Employee>>?, t: Throwable?) {
        view.showErrorServer()
    }

    override fun onResponse(call: Call<List<Employee>>?, response: Response<List<Employee>>?) {
        var responseOK = response?.isSuccessful ?: false
        if (responseOK) {
            view.showListEmployees(response?.body())
        } else {
            view.showErrorServer()
        }
    }

}