package com.kotlin.learning

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class NumberPalindrome : AppCompatActivity(){
    lateinit var instrksnTV: TextView;
    lateinit var numberInputBox : EditText;
    lateinit var checkButton : Button;
    lateinit var resultTV : TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primenumber);
        instrksnTV = findViewById<TextView>(R.id.instrksn_tv1);
        instrksnTV.setText(R.string.number_palindrome_instrksn);
        numberInputBox =  findViewById<EditText>(R.id.number_input);
        checkButton = findViewById<Button>(R.id.check_button);
        checkButton.setOnClickListener { view ->
            val input : String = numberInputBox.getText().toString();
            if(input.isEmpty())
                numberInputBox.setHintTextColor(getResources().getColor(android.R.color.holo_red_dark));
            else{
                val inputNumber = Integer.parseInt(input);
                var result : String = "";
                if(isPalindrome(inputNumber))
                    result = Integer.toString(inputNumber) + " is a Palindrome";
                else
                    result = Integer.toString(inputNumber) + " is not a Palindrome";

                resultTV.setText(result);

            }

        }

        resultTV = findViewById<TextView>(R.id.result_text);
    }

    private fun isPalindrome(number : Int) : Boolean{
        var temp : Int = number;
        var sum : Int = 0;
        while(temp != 0){
            sum = (sum*10)+(temp%10);

            temp = temp/10;
        }
        if(number == sum)
            return true
        return false;
    }
}