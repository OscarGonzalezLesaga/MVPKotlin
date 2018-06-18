package com.everis.mvpkotlin.listEmployees.model.service

import com.everis.mvpkotlin.commons.service.ParamServer.Companion.LIST_EMPLOYEES_END_POINT
import com.everis.mvpkotlin.listEmployees.model.entities.Employee
import retrofit2.Call
import retrofit2.http.GET

interface IListEmployeesService {

    @GET(LIST_EMPLOYEES_END_POINT)
    fun getListEmployees(): Call<List<Employee>>
}