package com.example.segunda

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class TaskListViewModel(
    taskDao: TaskDao,

    ) : ViewModel() {

    //dessa forma temos o livedata dentro do viewmodel.
    val taskListLiveData: LiveData<List<Task>> = taskDao.getAll()

    companion object {


        fun create(application: Application): TaskListViewModel {

            val dataBaseInstance = (application
                    as TaskBeatsAplication).getAppDataBase()
            val dao = dataBaseInstance.taskDao()
            return TaskListViewModel(dao)
        }
    }
}