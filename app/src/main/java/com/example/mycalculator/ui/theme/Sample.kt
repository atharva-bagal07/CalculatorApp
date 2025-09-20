package com.example.mycalculator.ui.theme


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calcu(viewModel: CalculatorViewModel){
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxHeight()) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(0.27f)
            .background(color = Color.Black),
            Alignment.BottomEnd,

            ){
            if(viewModel.resultText.value == ""){
                if(viewModel.resultTextInt.value == 0 && viewModel.firstinput.value == "" && viewModel.secondinput.value ==""){
                    Text(text = "0", fontSize = 60.sp,color = Color.White)
                }
                else{
                    Text(text = viewModel.firstinput.value + viewModel.operationsinput.value + viewModel.secondinput.value, fontSize = 60.sp,color = Color.White)
                }
            }
            else{
                Text(text = viewModel.resultText.value, fontSize = 60.sp,color = Color.White)
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
                    Button(onClick = {  viewModel.resultTextInt.value = 0
                        viewModel.firstinput.value = ""
                        viewModel.secondinput.value = ""
                        viewModel.resultText.value = ""
                        viewModel.operationsinput.value = "" },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "AC", color = Color.White, fontSize = 25.sp)
                    }

                    Button(onClick = {
                        if(!viewModel.firstinput.value.startsWith("-") && viewModel.firstinput.value == ""){
                            viewModel.firstinput.value = "-"+ viewModel.firstinput.value
                        }
                    },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "+/-", color = Color.White, fontSize = 25.sp)
                    }
                    Button(onClick = {
                        if(viewModel.firstinput.value!= "" && viewModel.operationsinput.value == "") {
                            viewModel.firstinput.value = viewModel.firstinput.value.substring(0,viewModel.firstinput.value.length-1)
                        }
                        else if(viewModel.operationsinput.value !="" && viewModel.secondinput.value == "") {
                            viewModel.operationsinput.value = viewModel.operationsinput.value.substring(0,viewModel.operationsinput.value
                                .length-1)
                        }
                        else if(viewModel.firstinput.value!= "" && viewModel.operationsinput.value !="" && viewModel.secondinput.value!= "") {
                            viewModel.secondinput.value = viewModel.secondinput.value.substring(0,viewModel.secondinput.value.length-1)
                        }
                    },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "⌫", color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                    }
                    Button(onClick = { viewModel.opButtonHandle("÷") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "÷", color = Color.White, fontSize = 35.sp)
                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, vertical = 8.dp), horizontalArrangement = Arrangement.SpaceEvenly){
                    Button(onClick = { viewModel.Buttonlogic("7") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "7", color = Color.White, fontSize = 35.sp)
                    }

                    Button(onClick = { viewModel.Buttonlogic("8") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "8", color = Color.White, fontSize = 35.sp)
                    }
                    Button(onClick = { viewModel.Buttonlogic("9") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "9", color = Color.White, fontSize = 35.sp)
                    }
                    Button(onClick = { viewModel.opButtonHandle("×") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "×", color = Color.White, fontSize = 35.sp)
                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, vertical = 8.dp), horizontalArrangement = Arrangement.SpaceEvenly){
                    Button(onClick = { viewModel.Buttonlogic("4") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "4", color = Color.White, fontSize = 35.sp)
                    }

                    Button(onClick = { viewModel.Buttonlogic("5") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "5", color = Color.White, fontSize = 35.sp)
                    }
                    Button(onClick = { viewModel.Buttonlogic("6") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "6", color = Color.White, fontSize = 35.sp)
                    }
                    Button(onClick = {viewModel.opButtonHandle("-") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "-", color = Color.White, fontSize = 35.sp)
                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, vertical = 8.dp), horizontalArrangement = Arrangement.SpaceEvenly){
                    Button(onClick = { viewModel.Buttonlogic("1") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "1", color = Color.White, fontSize = 35.sp)
                    }

                    Button(onClick = { viewModel.Buttonlogic("2") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "2", color = Color.White, fontSize = 35.sp)
                    }
                    Button(onClick = { viewModel.Buttonlogic("3") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "3", color = Color.White, fontSize = 35.sp)
                    }
                    Button(onClick = { viewModel.opButtonHandle("+") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = "+", color = Color.White, fontSize = 35.sp)
                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, vertical = 8.dp), horizontalArrangement = Arrangement.SpaceBetween){
                    Button(onClick = { viewModel.Buttonlogic("0") },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)
                        .weight(0.3f)) {
                        Text(text = "0", color = Color.White, fontSize = 35.sp)
                    }
                    Button(onClick = {
                        if(viewModel.operationsinput.value == "" && viewModel.firstinput.value == "" && !viewModel.firstinput.value.contains(".")){
                            viewModel.firstinput.value += "0."
                        }
                        else if(viewModel.operationsinput.value == "" && viewModel.firstinput.value != "" && !viewModel.firstinput.value.contains(".")){
                            viewModel.firstinput.value += "."
                        }
                        else if(viewModel.operationsinput.value != "" && viewModel.secondinput.value == "" && !viewModel.secondinput.value.contains(".")){
                            viewModel.secondinput.value += "0."
                        }
                        else if(viewModel.operationsinput.value != ""  && viewModel.secondinput.value != ""&& !viewModel.secondinput.value.contains(".")){
                            viewModel.secondinput.value += "."
                        }
                    },modifier = Modifier
                        .size(85.dp)
                        .clip(shape = CircleShape)) {
                        Text(text = ".", color = Color.White, fontSize = 35.sp)
                    }
                    Button(onClick = {
                        if(viewModel.operationsinput.value == "+"){
                            if(viewModel.firstinput.value.contains(".") || viewModel.secondinput.value.contains(".")){
                                viewModel.result_Float.value = viewModel.firstinput.value.toFloat() + viewModel.secondinput.value.toFloat()
                                viewModel.resultText.value = viewModel.result_Float.value.toString()
                            }
                            else{
                                viewModel.resultTextInt.value = viewModel.firstinput.value.toInt() + viewModel.secondinput.value.toInt()
                                viewModel.resultText.value = viewModel.resultTextInt.value.toString()
                            }
                            viewModel.firstinput.value = viewModel.resultText.value
                            viewModel.secondinput.value = ""
                            viewModel.operationsinput.value = ""

                            viewModel.resultTextInt.value = 0
                            viewModel.resultText.value = ""
                        }
                        if(viewModel.operationsinput.value == "-"){
                            if(viewModel.firstinput.value.contains(".") || viewModel.secondinput.value.contains(".")){
                                viewModel.result_Float.value = viewModel.firstinput.value.toFloat() - viewModel.secondinput.value.toFloat()
                                viewModel.resultText.value = viewModel.result_Float.value.toString()
                            }
                            else{
                                viewModel.resultTextInt.value = viewModel.firstinput.value.toInt() - viewModel.secondinput.value.toInt()
                                viewModel.resultText.value = viewModel.resultTextInt.value.toString()
                            }
                            viewModel.firstinput.value = viewModel.resultText.value
                            viewModel.secondinput.value = ""
                            viewModel.operationsinput.value = ""
                            viewModel.resultTextInt.value = 0
                            viewModel.resultText.value = ""
                        }
                        if(viewModel.operationsinput.value == "×"){
                            if(viewModel.firstinput.value.contains(".") || viewModel.secondinput.value.contains(".")){
                                viewModel.result_Float.value = viewModel.firstinput.value.toFloat() * viewModel.secondinput.value.toFloat()
                                viewModel.resultText.value = viewModel.result_Float.value.toString()
                            }
                            else{
                                viewModel.resultTextInt.value = viewModel.firstinput.value.toInt() * viewModel.secondinput.value.toInt()
                                viewModel.resultText.value = viewModel.resultTextInt.value.toString()
                            }
                            viewModel.firstinput.value = viewModel.resultText.value
                            viewModel.secondinput.value = ""
                            viewModel.operationsinput.value = ""
                            viewModel.resultTextInt.value = 0
                            viewModel.resultText.value = ""
                        }
                        if(viewModel.operationsinput.value == "÷"){
                            if(viewModel.secondinput.value!="0"){
                                viewModel.result_Float.value = viewModel.firstinput.value.toFloat() / viewModel.secondinput.value.toFloat()
                                viewModel.resultText.value = viewModel.result_Float.value.toString()
                                viewModel.firstinput.value = viewModel.resultText.value
                            }
                            else{
                                Toast.makeText(context,"Invalid format used",Toast.LENGTH_SHORT).show()
                                viewModel.firstinput.value = ""
                            }
                            viewModel.secondinput.value = ""
                            viewModel.operationsinput.value = ""
                            viewModel.resultTextInt.value = 0
                            viewModel.resultText.value = ""
                            viewModel.result_Float.value = 0f
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