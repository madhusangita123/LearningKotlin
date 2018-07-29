package com.kotlin.learning

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class FiboNacciActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{

    lateinit var mNumberDropDown : Spinner;
    lateinit var mFibiSeriesTv : TextView;
    var numberAdapter : ArrayAdapter<Int>? = null;
    var numbers : Array<Int>? = null;
    var selectedValue: Int = 9;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fibonacci);

        mNumberDropDown = findViewById(R.id.number_dropdown) as Spinner;
        numbers = getNumberArray();
        numberAdapter = ArrayAdapter<Int>(this,android.R.layout.simple_spinner_dropdown_item,numbers);
        mNumberDropDown.setAdapter(numberAdapter);
        mNumberDropDown.setSelection(9);
        mNumberDropDown.setOnItemSelectedListener(this);

        selectedValue  = mNumberDropDown.getSelectedItem() as Int;
        printFibonacci(selectedValue);
    }

    private fun printFibonacci( number : Int){
        var fibonacciSeries : String = returnFibonaccis(number);
        mFibiSeriesTv = findViewById<TextView>(R.id.fibo_series_tv);
        mFibiSeriesTv.setText(fibonacciSeries);
    }

    private fun  getNumberArray() : Array<Int>? {
       var numberArray : Array<Int>? = null;
        val list: ArrayList<Int> = ArrayList();
        for(i in 1..100){
           list.add(i);
        }
        numberArray = list.toTypedArray();
        return numberArray;
    }

    private fun  returnFibonaccis( n : Int) : String{
        var fibonacciSeries : String = "";
        var x : Int = 1;
        var y : Int = 1;
        fibonacciSeries = fibonacciSeries+" "+x+" "+y;

        var i : Int = 3;
        var sum : Int = 0;
        do{
            sum = x+y;
            fibonacciSeries += " "+sum;
            x = y;
            y = sum;
            i++;
        }while(i<=n);

        return fibonacciSeries;
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        selectedValue = numbers?.get(position) as Int;
        printFibonacci(selectedValue);
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}