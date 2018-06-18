package com.everis.mvpkotlin.listEmployees.view

import android.support.v7.widget.LinearLayoutManager
import com.everis.mvpkotlin.R
import com.everis.mvpkotlin.commons.view.BaseActivity
import com.everis.mvpkotlin.commons.view.showSnackbar
import com.everis.mvpkotlin.listEmployees.model.entities.Employee
import com.everis.mvpkotlin.listEmployees.presenter.IListEmployeesPresenter
import com.everis.mvpkotlin.listEmployees.presenter.ListEmployeesPresenter
import com.everis.mvpkotlin.listEmployees.view.adapter.EmployeesAdapter
import kotlinx.android.synthetic.main.activity_list_employees.*

class ListEmployeesActivity : BaseActivity(), ListEmployeesView {


    lateinit var presenter: IListEmployeesPresenter
    lateinit var adapter: EmployeesAdapter

    override val layoutResource: Int
        get() = R.layout.activity_list_employees

    override fun linkView() {
        listEmployees.layoutManager = LinearLayoutManager(this)
        adapter = EmployeesAdapter(context = this)
        listEmployees.adapter = adapter
    }

    override fun linkPresenter() {
        presenter = ListEmployeesPresenter(this)
    }

    override fun logic() {
        presenter.getListEmployees()
    }

    override fun showListEmployees(listEmployees: List<Employee>) {
        adapter.employeeList = listEmployees
        adapter.notifyDataSetChanged()
    }

    override fun showErrorServer() {
        showSnackbar(getString(R.string.error_load_employees))
    }

}
