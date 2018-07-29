package com.kotlin.learning

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ArmstrongNumber : AppCompatActivity(){

    lateinit var instrksnTV: TextView;
    lateinit var numberInputBox : EditText;
    lateinit var checkButton : Button;
    lateinit var resultTV : TextView;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primenumber);
        instrksnTV = findViewById<TextView>(R.id.instrksn_tv1);
        instrksnTV.setText(R.string.number_armstrong_instrksn);
        numberInputBox =  findViewById<EditText>(R.id.number_input);
        checkButton = findViewById<Button>(R.id.check_button);
        checkButton.setOnClickListener { view ->
            val input : String = numberInputBox.getText().toString();
            if(input.isEmpty())
                numberInputBox.setHintTextColor(getResources().getColor(android.R.color.holo_red_dark));
            else{
                val inputNumber = Integer.parseInt(input);
                var result : String = "";
                if(isArmstrong(inputNumber))
                    result = Integer.toString(inputNumber) + " is a Armstrong number";
                else
                    result = Integer.toString(inputNumber) + " is not a Armstrong number.";

                resultTV.setText(result);

            }

        }

        resultTV = findViewById<TextView>(R.id.result_text);
    }

    private fun isArmstrong(number : Int):Boolean{

        var temp : Int = number;
        var sum : Int = 0;
        while(temp != 0){
            sum += findcube((temp%10),3);
            temp = temp/10;
        }
        if(sum == number)
            return true;
        return false;
    }

    private fun findcube(number : Int, n : Int) : Int{
        var cube : Int = 1;
        for( i : Int in 1..n){
            cube = cube * number;
        }
        return cube;
    }
}