package com.example.tutorial_03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.tutorial_03.models.Calculator

class MainActivity : AppCompatActivity() {

    lateinit var edtNumber1: EditText
    lateinit var edtNumber2:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNumber1 = findViewById(R.id.edtNumber1)
        edtNumber2 = findViewById(R.id.edtNumber2)
    }

    fun buttonClick(v: View){
        var ans = 0.0
        val calculator = Calculator(edtNumber1.text.toString().toDouble(),edtNumber2.text.toString().toDouble())
        when(v.id){
            R.id.btnPlus -> {
                ans = calculator.add()

                val intent = Intent(this, Activity_2::class.java) //navigate to activity_2 create the intent object
                intent.putExtra("answer", ans) // pass the ans for Activity 2 using putExtra method
                startActivity(intent) // start the activity 2 using intent object
                finish()
            }
            R.id.btnMinus -> {
                ans = calculator.subtract()

                val intent = Intent(this, Activity_2::class.java)
                intent.putExtra("answer", ans)
                startActivity(intent)
                finish()
            }
            R.id.btnMultiply ->{
                ans = calculator.multiply()

                val intent = Intent(this, Activity_2::class.java)
                intent.putExtra("answer", ans)
                startActivity(intent)
                finish()
            }
            R.id.btnDivide -> {
                ans = calculator.divide()

                val intent = Intent(this, Activity_2::class.java)
                intent.putExtra("answer", ans)
                startActivity(intent)
                finish()
            }
        }

    }

}