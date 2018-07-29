package com.kotlin.learning

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class PrimeNumber : AppCompatActivity(){

    lateinit var numberInput : EditText;
    lateinit var checkButton : Button;
    lateinit var resultText : TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primenumber);
        numberInput = findViewById<EditText>(R.id.number_input);
        checkButton = findViewById<Button>(R.id.check_button);
        resultText = findViewById<TextView>(R.id.result_text);

        checkButton.setOnClickListener { view ->
            val inputText : String = numberInput.getText().toString();
            if(inputText.isEmpty())
                numberInput.setHintTextColor(getResources().getColor(android.R.color.holo_red_dark));
            else {
                val result : String;
                val number: Int = Integer.parseInt(inputText);
                if(isPrime(number)){
                    result = Integer.toString(number) + " is a prime number.";
                }else{
                    result = Integer.toString(number) + " is not a prime number.";
                }
                resultText.setText(result);
            }
        }
    }

    private fun isPrime(number : Int):Boolean{
        if(number == 2 || number == 3)
            return true;

        if(number % 2 == 0)
            return false;

        var sqrt : Int = Math.sqrt(number.toDouble()).toInt() + 1;
        var i :Int = 3;
        while ( i < sqrt){
            if((number as Int) % i == 0)
                return false;
            i+=2;
        }

        return true;
    }
}