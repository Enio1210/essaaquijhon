package com.example.segunda

import android.app.Application
import android.window.OnBackInvokedDispatcher
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TaskDetailViewModel  (
    private val taskDao: TaskDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    fun execute(taskAction: TaskAction) {
        when (taskAction.actionType) {
            ActionType.DELETE.name -> deleteById(taskAction.task!!.id)
            // aqui eu estou inserindo algo na lista
            ActionType.CREATE.name -> insertIntoDataBase(taskAction.task!!)
            // atualizou a lista
            ActionType.UPDATE.name -> updateIntoDataBase(taskAction.task!!)
        }
    }

    private fun deleteById(id: Int) {
        viewModelScope.launch {
            taskDao.deleteById(id)
        }
    }

    private fun insertIntoDataBase(task: Task) {
        viewModelScope.launch {
            taskDao.insert(task)

        }
    }

    private fun updateIntoDataBase(task: Task) {
        viewModelScope.launch{
            taskDao.insert(task)
            // aqui eu atualizo minh alista

        }
    }

    companion object {

        fun getVMFactory(application: Application): ViewModelProvider.Factory {
            val dataBaseInstance = (application as TaskBeatsAplication).getAppDataBase()
            val dao = dataBaseInstance.taskDao()

            val factory =  object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return TaskDetailViewModel(dao) as T
                }
            }
            return factory

        }
    }
}
