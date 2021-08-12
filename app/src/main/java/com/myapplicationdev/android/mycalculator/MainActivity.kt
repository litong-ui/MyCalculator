package com.myapplicationdev.android.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var dot = false
    var isNewOp=true

    fun btnOnClick(view: View) {
        if(isNewOp) {
            textView.setText("")
        }
        isNewOp=false

        val btnSelected = view as Button
        var msg : String = textView.text.toString()
        when(btnSelected.id){
            btn0.id -> msg += "0"
            btn1.id -> msg += "1"
            btn2.id -> msg += "2"
            btn3.id -> msg += "3"
            btn4.id -> msg += "4"
            btn5.id -> msg += "5"
            btn6.id -> msg += "6"
            btn7.id -> msg += "7"
            btn8.id -> msg += "8"
            btn9.id -> msg += "9"
            btnDot.id ->{
                if(dot == false){
                    msg += "."
                }
                dot = true
            }
        }
        textView.text = "$msg"
    }

    var op="X"
    var oldNumber=""

    fun btnOPOnClick(view: View) {
        val btnSelected = view as Button
        when(btnSelected.id){
            btnDivide.id -> op = "÷"
            btnMultiply.id -> op = "X"
            btnPlus.id -> op = "+"
            btnMinus.id -> op = "-"
        }
        oldNumber = textView.text.toString()
        isNewOp = true
        dot = false
    }

    fun btnEqualOnClick(view: View) {
        val newNumber = textView.text.toString()
        var finalNumber:Double?=null
        when(op) {
            "X"-> {finalNumber=oldNumber.toDouble() * newNumber.toDouble()}
            "÷"-> {finalNumber=oldNumber.toDouble() / newNumber.toDouble()}
            "-"-> {finalNumber=oldNumber.toDouble() - newNumber.toDouble()}
            "+"-> {finalNumber=oldNumber.toDouble() + newNumber.toDouble()}
        }
        textView.setText(finalNumber.toString())
        isNewOp=true
    }

    fun btnClearOnClick(view: View)
    {
        val btnSelected = view as Button
        when(btnSelected.id){
            btnAC.id -> textView.setText("0")
        }
        isNewOp=true
        dot=false
    }

}