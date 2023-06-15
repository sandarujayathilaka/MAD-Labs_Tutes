package com.example.lab_03

import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.lab_03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //The purpose of this line of code is to create an instance of the ActivityMainBinding class,
        // which provides direct references to the views in the layout file. This allows the activity
        // to access and manipulate the views in the layout without having to call the findViewById()
        // method for each view. After this line of code, the binding variable will refer to the instance of the ActivityMainBinding class,
//     and can be used to access the views in the layout file. For example, binding.textView would refer to the
//     TextView defined in the layout file with an android:id attribute of @+id/textView.

        binding.btnSubmit.setOnClickListener {
            showAlertBox(
                this,
                binding.edtName.text.toString(),
                binding.edtEmail.text.toString(),
                binding.edtPhone.text.toString(),
                binding.edtPassword.text.toString(),
                binding.edtRePassword.text.toString()
            )
        }

        binding.btnCancel.setOnClickListener{
            binding.edtName.setText("")
            binding.edtEmail.setText("")
            binding.edtPhone.setText("")
            binding.edtPassword.setText("")
            binding.edtRePassword.setText("")
        }


    }

    fun showAlertBox(
        context: Context,
        name: String,
        email: String,
        phone: String,
        password: String,
        rePassword: String
    ) {
        val builder = AlertDialog.Builder(context)
        val message = "Email: $email\n" +
                "Phone: $phone\n" +
                "Passwords: ${if (password == rePassword) "Matching" else "Not Matching"}."
        builder.setTitle("Welcome $name!")
        builder.setMessage(message)
        builder.setPositiveButton("Ok") { _, _ ->
            Toast.makeText(context, "Submitted", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("Cancel") { _, _ ->
        }
        val dialog = builder.create()
        dialog.show()
    }


}