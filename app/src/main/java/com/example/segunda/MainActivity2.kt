package com.example.segunda

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels

class MainActivity2 : AppCompatActivity() {


    private var task: Task? = null
    private lateinit var btnDone: Button


    private val viewModel:TaskDetailViewModel by viewModels{TaskDetailViewModel.getVMFactory(application)
    }


    companion object {
        private const val TASK_DETAIL_EXTRA = "task.extra.detail"

        fun start(context: Context, task: Task?): Intent {
            val intent = Intent(context, MainActivity2::class.java)
                .apply {
                    putExtra(TASK_DETAIL_EXTRA, task)
                }

            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        task = intent.getSerializableExtra(TASK_DETAIL_EXTRA) as Task?

        val edtTitle = findViewById<EditText>(R.id.edit_task_title)

        btnDone = findViewById<Button>(R.id.btn_done)

        if (task != null) {
            edtTitle.setText(task!!.title)
        }

        btnDone.setOnClickListener {
            // Aqui, você está extraindo o texto inserido nos campos
            val title = edtTitle.text.toString()

// aqui verifica es o texto estar vazinho
            if (title.isNotEmpty()) {
                if (task == null) {
                    addOrUpdateTask(0, title, ActionType.CREATE)

                } else {
                    addOrUpdateTask(task!!.id, title, ActionType.UPDATE)
                }
            } else {

            }
        }
    }
    private fun addOrUpdateTask(
        id: Int,
        title: String,
        actionType: ActionType
    ) {
        val task = Task(id, title)
        // viewModel.execute(task,actionType)
        performAction(task, actionType)
    }

    private fun performAction (task: Task, actionType: ActionType) {
        val taskAction = TaskAction(task, actionType.name)
        viewModel.execute(taskAction)
        finish()
    }



}