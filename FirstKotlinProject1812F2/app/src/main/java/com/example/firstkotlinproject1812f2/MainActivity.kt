package com.example.firstkotlinproject1812f2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToast.setOnClickListener {
            Toast.makeText(this,"This is First Kotlin App",Toast.LENGTH_LONG).show()
        }
    }

    fun onSubmit(v:View){
        var intent=Intent(this,MainActivity2::class.java)
        startActivity(intent)
    }

}