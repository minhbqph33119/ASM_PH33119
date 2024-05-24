package com.example.asm_ph33119.src

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.asm_ph33119.R


@Preview(showBackground = true)
@Composable
fun ProductDetail(){
    val buttonColors = listOf(Color(0xFFFF0F0F0), Color(0xFFB4916C), Color(0xFFE4CBAD))
    var soLong = remember {mutableIntStateOf(1) }


    val selectedButton = remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {

            Box(
                Modifier
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(0.5f)) {


                Image(
                    painter = painterResource(id = R.drawable.sp2),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.94f)
                        .clip(RoundedCornerShape(bottomStart = 30.dp))
                        .align(Alignment.TopEnd),
                    contentScale = ContentScale.FillHeight

                )
                IconButton(onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .size(55.dp)
                        .align(Alignment.TopStart)
                        .shadow(2.dp, shape = RoundedCornerShape(5.dp))
                        .background(color = Color.White, shape = RoundedCornerShape(5.dp))
                    ,



                    ) {
                    Icon(imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "",
                        tint = Color.Black,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .shadow(2.dp, shape = RoundedCornerShape(30.dp))
                        .background(Color.White, shape = RoundedCornerShape(30.dp))
                        .padding(10.dp)
                        .align(Alignment.CenterStart)
                        .zIndex(1f),


                    ) {
                    buttonColors.forEachIndexed { index, color ->
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(35.dp)
                                .clip(CircleShape)
                                .background(color)
                                .clickable { selectedButton.value = index + 1 }
                                .padding(8.dp)
                        ) {
                            if (selectedButton.value == index + 1) {
                                Box(
                                    modifier = Modifier
                                        .size(20.dp)
                                        .clip(CircleShape)
                                        .background(Color.White)
                                        .padding(8.dp)
                                )
                            }

                        }
                        Spacer(modifier = Modifier.height(8.dp))

                    }
                }

            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Minimal Stand",
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 16.dp)
        )


        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "$ 50",
                fontFamily = FontFamily.Serif,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
            )
            TangGiamSoLuong(soLong)
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Icon(Icons.Default.Star, contentDescription = "",
                tint = Color(0xffF2C94C)
            )
            Text(text = "4.5",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 10.dp, end = 30.dp)
            )

            Text(text = "( 50 reviews )",
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(start = 10.dp, end = 30.dp),
                color = Color(0xff808080)
            )

        }
        Text(text = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home. ",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 15.dp),
            fontFamily = FontFamily.Serif,
            color = Color(0xff606060)
        )

        Row(modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(55.dp)
                    .shadow(2.dp, shape = RoundedCornerShape(5.dp))
                    .background(color = Color.White, shape = RoundedCornerShape(5.dp))
                ,



                ) {
                Icon(imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "",
                    tint = Color.Black,
                    modifier = Modifier.size(30.dp)
                )
            }
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF242424)
                ),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            ) {
                Text(
                    text = "Add all to my cart",
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier.padding(8.dp)
                )

            }
        }

    }
}

@Composable
fun TangGiamSoLuong(soLong: MutableIntState){
    val contex = LocalContext.current
    Row(
        modifier = Modifier.fillMaxWidth(0.4f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {


        IconButton(onClick = { soLong.value +=1 },
            modifier = Modifier
                .background(Color(0xffE0E0E0), shape = RoundedCornerShape(5.dp))
                .size(30.dp),

            ) {
            Icon(Icons.Default.Add, contentDescription = "", Modifier.size(24.dp))
        }
        Text(text = "" + soLong.value)
        IconButton(onClick = {
            if (soLong.value>1){
                soLong.value-=1
            }else{
                Toast.makeText(contex, "Số lượng không thể nhỏ hơn 1", Toast.LENGTH_SHORT).show()
            }
        },
            modifier = Modifier
                .background(Color(0xffE0E0E0), shape = RoundedCornerShape(5.dp))
                .size(30.dp),

            ) {
            Icon(Icons.Default.Remove, contentDescription = "", )
        }
    }
}