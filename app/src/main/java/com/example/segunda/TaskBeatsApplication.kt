package com.example.segunda

import android.app.Application
import androidx.room.Room
class TaskBeatsAplication: Application(){
    private lateinit var database: AppDataBase

    override fun onCreate(){

        super.onCreate()

        database= Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java, "taskbeats-database"
        ).build()


    }

    fun getAppDataBase(): AppDataBase {
        return  database
    }

}