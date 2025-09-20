package com.example.mycalculator.ui.theme


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

import androidx.lifecycle.ViewModel


class CalculatorViewModel: ViewModel() {
    private val Privatefirstinput = mutableStateOf("")
    private val Privatesecondinput = mutableStateOf("")
    private val Privateoperationinput = mutableStateOf("")
    private val PrivateresultText = mutableStateOf("")
    private val PrivateresultTextInt = mutableStateOf(0)
    private val Privatemulti_token = mutableStateOf(0)
    private val PrivateresultFloat = mutableStateOf(0f)
    var firstinput : MutableState<String> = Privatefirstinput

    var secondinput : MutableState<String> = Privatesecondinput

    val resultText : MutableState<String> = PrivateresultText
    var resultTextInt : MutableState<Int> = PrivateresultTextInt
    val operationsinput : MutableState<String> = Privateoperationinput
    var multi_token : MutableState<Int> = Privatemulti_token
    var result_Float : MutableState<Float> = PrivateresultFloat


    fun Buttonlogic(buttoninput: String){
        while (multi_token.value == 0){
            if(operationsinput.value ==""){
                firstinput.value += buttoninput
            }
            multi_token.value = 1
        }
        while (multi_token.value == 1){
            if(operationsinput.value !=""){
                secondinput.value += buttoninput
            }
            multi_token.value = 0
        }
    }

    fun opButtonHandle(opInput: String){
        if(firstinput.value!="" && (firstinput.value.endsWith("0") || firstinput.value.endsWith("1") || firstinput.value.endsWith("2") || firstinput.value.endsWith("3") || firstinput.value.endsWith("4") || firstinput.value.endsWith("5") || firstinput.value.endsWith("6") || firstinput.value.endsWith("7") || firstinput.value.endsWith("8") || firstinput.value.endsWith("9") ))
        {
            operationsinput.value = opInput
            if(firstinput.value!= "" && operationsinput.value!= "" && secondinput.value!=""){
                firstinput.value = firstinput.value+ operationsinput.value + secondinput.value
                operationsinput.value = ""
                secondinput.value = ""
            }
        }
        else{
            operationsinput.value =
                ""
        }
    }
}