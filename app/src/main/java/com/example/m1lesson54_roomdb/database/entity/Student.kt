package com.example.m1lesson54_roomdb.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var age: Int,
    @ColumnInfo(name = "phone_number")
    var phoneNumber: String,
    var email:String
)
