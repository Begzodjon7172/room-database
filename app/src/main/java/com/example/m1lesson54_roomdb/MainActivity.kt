package com.example.m1lesson54_roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m1lesson54_roomdb.adapters.StudentAdapter
import com.example.m1lesson54_roomdb.database.AppDatabase
import com.example.m1lesson54_roomdb.database.entity.Student
import com.example.m1lesson54_roomdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val appDatabase by lazy {
        AppDatabase.getInstance(this)
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var list: ArrayList<Student>
    private lateinit var studentAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            list = appDatabase.studentDao().getAllStudents()
            studentAdapter = StudentAdapter(list)
            rv.adapter = studentAdapter

            saveBtn.setOnClickListener {
                val student = Student(
                    name = nameEt.text.toString(),
                    age = ageEt.text.toString().toInt(),
                    phoneNumber = phoneEt.text.toString(),
                    email = "b@mail.ru"
                )
                appDatabase.studentDao().addStudent(student)
                list.add(student)
                studentAdapter.notifyItemInserted(list.size)
            }


        }
    }
}