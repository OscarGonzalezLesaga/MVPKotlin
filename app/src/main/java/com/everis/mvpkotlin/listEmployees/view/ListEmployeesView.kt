package com.everis.mvpkotlin.listEmployees.view

import com.everis.mvpkotlin.listEmployees.model.entities.Employee

interface ListEmployeesView {
    fun showListEmployees(listEmployees: List<Employee>)

    fun showErrorServer()
}