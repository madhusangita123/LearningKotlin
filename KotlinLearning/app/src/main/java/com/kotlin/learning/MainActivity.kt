package com.kotlin.learning

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    var program_names : Array<String>? = arrayOf("Fibonacci series", "Prime number", "String Palindrome", "Integer Palindrome", "Armstrong number")
    lateinit  var listProgramsView : ListView;
    var programsAdapter : ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listProgramsView = findViewById(R.id.list_programs) as ListView
        programsAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,program_names)
        listProgramsView.setAdapter(programsAdapter)

        listProgramsView.setOnItemClickListener { parent, view, position, id ->

            when(position){

                0-> startActivity(Intent(this,FiboNacciActivity::class.java) );
                1-> startActivity(Intent(this,PrimeNumber::class.java) );
                2-> startActivity(Intent(this,Palindrome::class.java) );
                3-> startActivity(Intent(this,NumberPalindrome::class.java) );
                4-> startActivity(Intent(this,ArmstrongNumber::class.java) );
            }
        }
    }
}
