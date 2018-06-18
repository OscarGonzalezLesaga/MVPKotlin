package com.everis.mvpkotlin.listEmployees.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.everis.mvpkotlin.R
import com.everis.mvpkotlin.listEmployees.model.entities.Employee

class EmployeesAdapter(var employeeList: List<Employee> = ArrayList(), var context: Context) : RecyclerView.Adapter<EmployeesAdapter.EmployeeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_employee_list, parent, false))
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bind(employeeList[position])
    }

    class EmployeeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(employee: Employee) {

        }
    }
}