package com.example.m1lesson54_roomdb.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.m1lesson54_roomdb.database.entity.Student
import com.example.m1lesson54_roomdb.databinding.ItemStudentBinding

class StudentAdapter(private val list: List<Student>) : RecyclerView.Adapter<StudentAdapter.Vh>() {

    inner class Vh(private var itemStudentBinding: ItemStudentBinding) :
        RecyclerView.ViewHolder(itemStudentBinding.root) {
        fun onBind(student: Student, position: Int) {
            itemStudentBinding.nameTv.text = student.name
            itemStudentBinding.ageTv.text = student.age.toString()
            itemStudentBinding.phoneTv.text = student.phoneNumber
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

}