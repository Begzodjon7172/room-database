package com.example.m1lesson54_roomdb.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.m1lesson54_roomdb.database.entity.Student

@Dao
interface StudentDao {

    @Query("select * from student order by name")
    fun getAllStudents(): ArrayList<Student>

    @Insert
    fun addStudent(student: Student)

    @Delete
    fun deleteStudent(student: Student)

    @Update
    fun updateStudent(student: Student)

    @Query("select * from student where id = :id")
    fun getStudentById(id: Int): Student

    @Query("select * from student where name like '%' || :word || '%'")
    fun getStudentsByName(word: String): List<Student>
}