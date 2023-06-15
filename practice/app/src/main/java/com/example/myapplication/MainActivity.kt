package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
   lateinit var editname: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editname = findViewById(R.id.e1);

    }

    fun buttonClick(v: View){
        val intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)
        finish()

    }
}