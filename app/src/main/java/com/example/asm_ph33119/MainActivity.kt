package com.example.asm_ph33119

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.asm_ph33119.src.BottomNavigation
import com.example.asm_ph33119.src.Cart
import com.example.asm_ph33119.src.Favorite
import com.example.asm_ph33119.src.Login
import com.example.asm_ph33119.src.ProductInformation
import com.example.asm_ph33119.src.Signin
import com.example.asm_ph33119.src.Welcome
import com.example.asm_ph33119.ui.theme.ASM_PH33119Theme
import com.example.asm_ph33119.ui.theme.Screens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ASM_PH33119Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navControl = rememberNavController()

                    NavHost(navController = navControl, startDestination = "Welcome") {
                        composable("Welcome"){
                            Welcome(navControl)
                        }
                        composable(Screens.Login.screen){
                            Login(navControl)
                        }
                        composable(Screens.Signin.screen){
                            Signin(navControl)
                        }
                        composable("Home"){
                            BottomNavigation(navControl)
                        }
                        composable(Screens.ProductInformation.screen){
                            ProductInformation(navControl)
                        }
                        composable(Screens.Cart.screen){
                            Cart(navControl)
                        }

                    }
                }
            }
        }
    }
}

