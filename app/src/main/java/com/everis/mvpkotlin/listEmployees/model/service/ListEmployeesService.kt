package com.everis.mvpkotlin.listEmployees.model.service

import com.everis.mvpkotlin.commons.service.ParamServer.Companion.DOMAIN
import com.everis.mvpkotlin.listEmployees.model.entities.Employee
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class ListEmployeesService : IListEmployeesService {

    val service = Retrofit.Builder()
            .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create())
            .addConverterFactory(
                    GsonConverterFactory.create())
            .baseUrl(DOMAIN)
            .build().create(IListEmployeesService::class.java)

    override fun getListEmployees(): Call<List<Employee>> {
        return service.getListEmployees()
    }


}