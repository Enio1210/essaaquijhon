package com.example.segunda

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    @Query("Select * from task")
    fun getAll(): LiveData<List<Task>>

    //UPDATE encotrar a tarefa que queremos
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(task: Task)
    // deleta todos
    @Query( " Delete from task")
    suspend fun deleteAll()

    // deletar por id
    @Query( " Delete from task where id= :id")
    suspend fun deleteById(id:Int)
}
