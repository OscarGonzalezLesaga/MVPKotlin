package com.everis.mvpkotlin.listEmployees.view.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.everis.mvpkotlin.R
import com.everis.mvpkotlin.listEmployees.model.entities.Employee
import kotlinx.android.synthetic.main.item_employee_list.view.*

class EmployeesAdapter(var employeeList: List<Employee> = ArrayList(), var context: Context) : RecyclerView.Adapter<EmployeesAdapter.EmployeeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_employee_list, parent, false))
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {

        var backgroundColor = if (position % 2 == 0) {
            ContextCompat.getColor(context, R.color.colorPrimaryTransparent)
        } else {
            ContextCompat.getColor(context, R.color.white)
        }

        holder.bind(employeeList[position], backgroundColor)
    }

    class EmployeeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(employee: Employee, backgroundColor: Int) {
            itemView.nameText.text = employee.name
            itemView.emailText.text = employee.email
            itemView.usernameText.text = employee.username
            itemView.setBackgroundColor(backgroundColor)
        }
    }
}