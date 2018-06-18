package com.everis.mvpkotlin.listEmployees.view

import com.everis.mvpkotlin.R
import com.everis.mvpkotlin.commons.view.BaseActivity
import com.everis.mvpkotlin.listEmployees.model.entities.Employee
import com.everis.mvpkotlin.listEmployees.presenter.IListEmployeesPresenter
import com.everis.mvpkotlin.listEmployees.presenter.ListEmployeesPresenter

class ListEmployeesActivity : BaseActivity(), ListEmployeesView {


    lateinit var presenter: IListEmployeesPresenter

    override val layoutResource: Int
        get() = R.layout.activity_list_employees

    override fun linkView() {
    }

    override fun linkPresenter() {
        presenter = ListEmployeesPresenter(this)
    }

    override fun logic() {
        presenter.getListEmployees()
    }

    override fun showListEmployees(listEmployees: List<Employee>?) {
    }

    override fun showErrorServer() {
    }

}
