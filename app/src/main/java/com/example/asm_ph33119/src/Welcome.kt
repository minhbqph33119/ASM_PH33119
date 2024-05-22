package com.example.asm_ph33119.src

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.asm_ph33119.R
import java.util.Locale


@Composable
fun Welcome(navControl: NavHostController){
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.welcome),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds)
        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .fillMaxWidth()
        ) {
            Text(
                text = "make your".toUpperCase(Locale.getDefault()),
                fontSize = 29.sp,
                fontFamily = FontFamily.Serif,
                color = Color(0xFF606060),
                modifier = Modifier.padding(start = 30.dp)
            )
            Text(
                text = "HOME BEAUTIFUL".toUpperCase(Locale.getDefault()),
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                color = Color(0xFF303030),
                modifier = Modifier.padding(start = 30.dp, top = 10.dp)
            )
            Text(
                text = "The best simple place where you discover most wonderful furnitures and make your home beautiful",
                color = Color(0xFF808080),
                fontSize = 17.sp,
                modifier = Modifier
                    .width(340.dp)
                    .padding(top = 50.dp, end = 10.dp)
                    .align(Alignment.End),
                letterSpacing = 0.1.em,
                lineHeight = 32.sp,

            )
            Button(
                onClick = { navControl.navigate("Login") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF242424)
                ),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(top = 120.dp)
                    .height(65.dp)
                ) {
                Text(
                    text = "Get Started",
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier.padding(10.dp)
                    )

            }
        }

    }
}