package com.example.m1lesson54_roomdb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.m1lesson54_roomdb.database.dao.StudentDao
import com.example.m1lesson54_roomdb.database.entity.Student

@Database(entities = [Student::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "my_db")
                    .allowMainThreadQueries()
                    .addMigrations(MIGRATION_1_2)
                    .build()
            }
            return INSTANCE!!
        }

        // yangi ustun qoshilganda versiyani birga oshirib migrationni ham korsatib qoyish kerak
        private val MIGRATION_1_2 = object : Migration(1, 2){
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    "ALTER TABLE student ADD COLUMN email TEXT not null default ''")
            }
        }

    }
}

