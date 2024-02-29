package com.example.segunda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Button = findViewById<Button>(R.id.deletebtn)

        Button.setOnClickListener {
            openTaskListDetail()
        }

    }
    private fun openTaskListDetail() {
        val intent = MainActivity2.start(this, null)
        startActivity(intent)
    }
}