package com.example.mycalculator.ui.theme


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorUI(){
    var firstinput by remember{
        mutableStateOf("")
    }
    var secondinput by remember{
        mutableStateOf("")
    }
    val resultText = remember {
        mutableStateOf("")
    }
    var resultTextInt by remember {
        mutableStateOf(0)
    }
    val operationsinput = remember {
        mutableStateOf("")
    }
    var multi_token by remember {
        mutableStateOf(0)
    }
    var result_Float by remember {
        mutableStateOf(0f)
    }
    val context = LocalContext.current

    val scrollState = rememberScrollState()



    fun Buttonlogic(buttoninput: String){
        while (multi_token == 0){
            if(operationsinput.value ==""){
                firstinput += buttoninput
            }
            multi_token = 1
        }
        while (multi_token == 1){
            if(operationsinput.value !=""){
                secondinput += buttoninput
            }
            multi_token = 0
        }
    }

    fun opButtonHandle(opInput: String){
        if(firstinput!="" && (firstinput.endsWith("0") || firstinput.endsWith("1") || firstinput.endsWith("2") || firstinput.endsWith("3") || firstinput.endsWith("4") || firstinput.endsWith("5") || firstinput.endsWith("6") || firstinput.endsWith("7") || firstinput.endsWith("8") || firstinput.endsWith("9") ))
        {
            operationsinput.value = opInput
            if(firstinput!= "" && operationsinput.value!= "" && secondinput!=""){
                firstinput = firstinput+ operationsinput.value + secondinput
                operationsinput.value = ""
                secondinput = ""
            }
        }
        else{
            operationsinput.value =
                ""
        }
    }

    Column(modifier = Modifier.fillMaxHeight()) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(0.27f)
            .background(color = Color.Black),
            Alignment.BottomEnd,

            ){
            if(resultText.value == ""){
                if(resultTextInt == 0 && firstinput == "" && secondinput ==""){
                    Text(text = "0", fontSize = 60.sp,color = Color.White)
                }
                else{
                    Row(modifier = Modifier.horizontalScroll(scrollState)) {
                        Text(text = firstinput + operationsinput.value + secondinput, fontSize = 60.sp,color = Color.White, maxLines = 1, softWrap = false)
                    }
                }
            }
            else{
                Row(modifier = Modifier.horizontalScroll(scrollState)) {
                    Text(
                        text = resultText.value,
                        fontSize = 60.sp,
                        color = Color.White,
                        maxLines = 1,
                        softWrap = false
                    )
                }
            }
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(0.73f)
            .background(color = Color.Black)){
            Column {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, vertical = 8.dp), horizontalArrangement = Arrangement.SpaceEvenly){
                    Button(onClick = {  resultTextInt = 0
                                        firstinput = ""
                                        secondinput = ""
                                        resultText.value = ""
                                        operationsinput.value = "" },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "AC", color = Color.White, fontSize = 25.sp)
                    }

                    Button(onClick = {
                        if(!firstinput.startsWith("-") && firstinput == ""){
                            firstinput = "-$firstinput"
                        }
                    },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "+/-", color = Color.White, fontSize = 25.sp)
                    }
                    Button(onClick = {
                       if(firstinput!= "" && operationsinput.value == "") {
                           firstinput = firstinput.substring(0,firstinput.length-1)
                      }
                        else if(operationsinput.value !="" && secondinput == "") {
                           operationsinput.value = operationsinput.value.substring(0,operationsinput.value
                               .length-1)
                      }
                       else if(firstinput!= "" && operationsinput.value !="" && secondinput!= "") {
                           secondinput = secondinput.substring(0,secondinput.length-1)
                      }
                                     },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "⌫", color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                       }
                    Button(onClick = { opButtonHandle("÷") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                     Text(text = "÷", color = Color.White, fontSize = 35.sp)
                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, vertical = 8.dp), horizontalArrangement = Arrangement.SpaceEvenly){
                    Button(onClick = { Buttonlogic("7") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "7", color = Color.White, fontSize = 35.sp)
                    }

                    Button(onClick = { Buttonlogic("8") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "8", color = Color.White, fontSize = 35.sp)
                    }
                    Button(onClick = { Buttonlogic("9") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "9", color = Color.White, fontSize = 35.sp)
                    }
                    Button(onClick = { opButtonHandle("×") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "×", color = Color.White, fontSize = 35.sp)
                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, vertical = 8.dp), horizontalArrangement = Arrangement.SpaceEvenly){
                    Button(onClick = { Buttonlogic("4") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "4", color = Color.White, fontSize = 35.sp)
                    }

                    Button(onClick = { Buttonlogic("5") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "5", color = Color.White, fontSize = 35.sp)
                    }
                    Button(onClick = { Buttonlogic("6") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "6", color = Color.White, fontSize = 35.sp)
                    }
                    Button(onClick = {opButtonHandle("-") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "-", color = Color.White, fontSize = 35.sp)
                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, vertical = 8.dp), horizontalArrangement = Arrangement.SpaceEvenly){
                    Button(onClick = { Buttonlogic("1") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "1", color = Color.White, fontSize = 35.sp)
                    }

                    Button(onClick = { Buttonlogic("2") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "2", color = Color.White, fontSize = 35.sp)
                    }
                    Button(onClick = { Buttonlogic("3") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "3", color = Color.White, fontSize = 35.sp)
                    }
                    Button(onClick = { opButtonHandle("+") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "+", color = Color.White, fontSize = 35.sp)
                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, vertical = 8.dp), horizontalArrangement = Arrangement.SpaceBetween){
                    Button(onClick = { Buttonlogic("0") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)
                        .weight(0.3f)) {
                        Text(text = "0", color = Color.White, fontSize = 35.sp)
                    }
                    Button(onClick = {
                                     if(operationsinput.value == "" && firstinput == "" && !firstinput.contains(".")){
                                         firstinput += "0."
                                     }
                                     else if(operationsinput.value == "" && firstinput != "" && !firstinput.contains(".")){
                                         firstinput += "."
                                     }
                                    else if(operationsinput.value != "" && secondinput == "" && !secondinput.contains(".")){
                                        secondinput += "0."
                                     }
                                    else if(operationsinput.value != ""  && secondinput != ""&& !secondinput.contains(".")){
                                         secondinput += "."
                                     }
                                     },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = ".", color = Color.White, fontSize = 35.sp)
                    }
                    Button(onClick = {
                        if(operationsinput.value == "+"){
                            if(firstinput.contains(".") || secondinput.contains(".")){
                                result_Float = firstinput.toFloat() + secondinput.toFloat()
                                resultText.value = result_Float.toString()
                            }
                            else{
                                resultTextInt = firstinput.toInt() + secondinput.toInt()
                                resultText.value = resultTextInt.toString()
                            }
                            firstinput = resultText.value
                            secondinput = ""
                            operationsinput.value = ""

                            resultTextInt = 0
                            resultText.value = ""
                        }
                        if(operationsinput.value == "-"){
                            if(firstinput.contains(".") || secondinput.contains(".")){
                                result_Float = firstinput.toFloat() - secondinput.toFloat()
                                resultText.value = result_Float.toString()
                            }
                            else{
                                resultTextInt = firstinput.toInt() - secondinput.toInt()
                                resultText.value = resultTextInt.toString()
                            }
                            firstinput = resultText.value
                            secondinput = ""
                            operationsinput.value = ""
                            resultTextInt = 0
                            resultText.value = ""
                        }
                        if(operationsinput.value == "×"){
                            if(firstinput.contains(".") || secondinput.contains(".")){
                                result_Float = firstinput.toFloat() * secondinput.toFloat()
                                resultText.value = result_Float.toString()
                            }
                            else{
                                resultTextInt = firstinput.toInt() * secondinput.toInt()
                                resultText.value = resultTextInt.toString()
                            }
                            firstinput = resultText.value
                            secondinput = ""
                            operationsinput.value = ""
                            resultTextInt = 0
                            resultText.value = ""
                        }
                        if(operationsinput.value == "÷"){
                            if(secondinput!="0"){
                                result_Float = firstinput.toFloat() / secondinput.toFloat()
                                resultText.value = result_Float.toString()
                                firstinput = resultText.value
                            }
                            else{
                                Toast.makeText(context,"Invalid format used",Toast.LENGTH_SHORT).show()
                                firstinput = ""
                            }
                            secondinput = ""
                            operationsinput.value = ""
                            resultTextInt = 0
                            resultText.value = ""
                            result_Float = 0f
                        }
                    },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "=", color = Color.White, fontSize = 35.sp)
                    }
                }
            }
        }
    }
}