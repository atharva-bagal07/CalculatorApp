package com.example.mycalculator

import android.annotation.SuppressLint
import android.os.Bundle

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.app.ComponentActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycalculator.ui.theme.Calcu
import com.example.mycalculator.ui.theme.CalculatorUI
import com.example.mycalculator.ui.theme.CalculatorViewModel
import com.example.mycalculator.ui.theme.MyCalculatorTheme

@SuppressLint("RestrictedApi")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: CalculatorViewModel = viewModel()
            MyCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Calcu(viewModel)
                    CalculatorUI()

                }
            }
        }
    }
}

