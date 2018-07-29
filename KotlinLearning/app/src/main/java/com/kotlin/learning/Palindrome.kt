package com.kotlin.learning

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Palindrome : AppCompatActivity(){

    lateinit var stringInput : EditText
    lateinit var checkButton : Button
    lateinit var resultText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palindrome)
        stringInput = findViewById<EditText>(R.id.string_input)
        checkButton = findViewById<Button>(R.id.check_button)
        resultText = findViewById<TextView>(R.id.result_text)

        checkButton.setOnClickListener { view ->
            val inputString : String = stringInput.text.toString()
            if(inputString.isEmpty())
                stringInput.setHintTextColor(resources.getColor(android.R.color.holo_red_dark))
            else {
                var result : String? = null
                if(isPalindrome(inputString))

                    result = inputString + " is a palindrome."

                else result = inputString + " is not a palindrome."

                resultText.text = result
            }
        }
    }

    private fun isPalindrome(string : String) : Boolean{

        var reversedString : String = ""

        var i : Int = string.length-1;
        while(i>=0){
            reversedString += string.get(i)
            i--;
        }
        if(reversedString.equals(string))
            return true

        return false
    }
}