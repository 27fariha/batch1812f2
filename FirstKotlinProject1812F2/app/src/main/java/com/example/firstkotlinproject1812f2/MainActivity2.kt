package com.example.firstkotlinproject1812f2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
    fun OnCalculaute(view:View){
        var currentYear=Calendar.getInstance().get(Calendar.YEAR);
       // var dobyear=editTextAge.text.toString().toInt(); //get data from input
      //  var age=currentYear-dobyear; //calculate
     //  textViewAge.text="Your Age is :"+ age; //set text in text view

        textViewAge.text="Age is :"+(currentYear -editTextAge.text.toString().toInt());
    }
}