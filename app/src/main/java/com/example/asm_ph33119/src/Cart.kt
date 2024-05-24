package com.example.asm_ph33119.src

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.asm_ph33119.R
import com.example.asm_ph33119.data.Products

val cartLists = listOf(
    Products(1, "Black Simple Lamp", 100.0,  R.drawable.sp1, false),
    Products(2, "Minimal Stand", 200.0,  R.drawable.sp2, false),
    Products(3, "Coffee Chair", 300.0,  R.drawable.sp3, false),
    Products(4, "Simple Desk", 400.0,  R.drawable.sp4, false),
    Products(5, "Black Simple Lamp", 100.0,  R.drawable.sp1, false),
    Products(6, "Minimal Stand", 200.0,  R.drawable.sp2, false),
    Products(7, "Coffee Chair", 300.0,  R.drawable.sp3, false),
    Products(8, "Simple Desk", 400.0,  R.drawable.sp4, false),
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cart(navControl: NavHostController) {
    var code by remember { mutableStateOf("") }
    // Sử dụng trạng thái để theo dõi số lượng của từng sản phẩm
    val quantities = remember { cartLists.map { mutableStateOf(1) } }

    // Tính tổng số tiền dựa trên số lượng và giá của từng sản phẩm
    val total = quantities.indices.sumOf { index -> cartLists[index].price * quantities[index].value }

    Box(modifier = Modifier.fillMaxSize().padding(top = 26.dp)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 26.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 26.dp)
            ) {
                Row(
                    modifier = Modifier.align(Alignment.CenterStart),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        Icons.Default.ArrowBackIosNew,
                        contentDescription = "",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { navControl.popBackStack()}
                    )
                }
                Text(
                    text = "My cart",
                    color = Color(0xFF303030),
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            LazyColumn(modifier = Modifier
                .padding(top = 10.dp)
                .weight(1f)
            ) {
                items(cartLists.size) { index ->
                    CartItem(index, quantities[index])
                    if (index < cartLists.size - 1) {
                        Divider(
                            color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color.White)
                .padding(15.dp)
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                        .padding(bottom = 10.dp)
                ) {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = code,
                        onValueChange = { code = it },
                        label = { Text("Enter your promo code") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = Color.Gray
                        ),
                        trailingIcon = {
                            IconButton(
                                onClick = { /* Xử lý khi nhấn vào nút */ },
                                modifier = Modifier
                                    .background(
                                        Color(0xFF303030),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                            ) {
                                Icon(Icons.Default.NavigateNext,
                                    contentDescription = "",
                                    tint = Color.White)
                            }
                        }
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Total:",
                        fontSize = 25.sp,
                        color = Color(0xff808080),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "$$total",
                        fontSize = 25.sp,
                        color = Color(0xff303030),
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF242424)
                    ),
                    shape = RoundedCornerShape(5.dp),
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Check out",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif
                    )
                }
            }
        }
    }
}

@Composable
fun CartItem(index: Int, quantity: MutableState<Int>) {
    val cart = cartLists[index]
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(5.dp)
            .padding(top = 10.dp, bottom = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        painter = painterResource(id = cart.image),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Column(modifier = Modifier.padding(start = 20.dp)) {
                        Text(text = cart.name, color = Color(0xff606060), fontSize = 15.sp)
                        Text(text = "$${cart.price}", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 20.dp))
                        TangGiam(quantity)
                    }
                }
                Column(
                    modifier = Modifier.align(Alignment.Top)
                ) {
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp)
                            .padding(0.dp) // space between the borders
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Cancel,
                            contentDescription = "",
                            Modifier.size(30.dp),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TangGiam(soLuong: MutableState<Int>){
    val context = LocalContext.current
    Row(
        modifier = Modifier.fillMaxWidth(0.5f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = { soLuong.value += 1 },
            modifier = Modifier
                .background(Color(0xffE0E0E0), shape = RoundedCornerShape(5.dp))
                .size(30.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "", Modifier.size(24.dp), tint = Color(0xff808080))
        }
        Text(text = "${soLuong.value}")
        IconButton(
            onClick = {
                if (soLuong.value > 1) {
                    soLuong.value -= 1
                } else {
                    Toast.makeText(context, "Số lượng không thể nhỏ hơn 1", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .background(Color(0xffE0E0E0), shape = RoundedCornerShape(5.dp))
                .size(30.dp)
        ) {
            Icon(Icons.Default.Remove, contentDescription = "", tint = Color(0xff808080))
        }
    }
}


@Composable
fun CartItem(index: Int) {
    var soLuong = remember { mutableIntStateOf(1) }
    val cart = cartLists[index]
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(5.dp)
            .padding(top = 10.dp, bottom = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        painter = painterResource(id = cart.image),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Column(modifier = Modifier.padding(start = 20.dp)) {
                        Text(text = cart.name, color = Color(0xff606060), fontSize = 15.sp)
                        Text(text = "$${cart.price}", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 20.dp))
                        TangGiam(soLuong)
                    }
                }
                Column(
                    modifier = Modifier.align(Alignment.Top)
                ) {
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp)
                            .padding(0.dp) // space between the borders
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Cancel,
                            contentDescription = "",
                            Modifier.size(30.dp),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TangGiam(soLuong: MutableIntState){
    val contex = LocalContext.current
    Row(
        modifier = Modifier.fillMaxWidth(0.5f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {


        IconButton(onClick = { soLuong.value +=1 },
            modifier = Modifier
                .background(Color(0xffE0E0E0), shape = RoundedCornerShape(5.dp))
                .size(30.dp),

            ) {
            Icon(Icons.Default.Add, contentDescription = "", Modifier.size(24.dp), tint = Color(0xff808080))
        }
        Text(text = "" + soLuong.value)
        IconButton(onClick = {
            if (soLuong.value>1){
                soLuong.value-=1
            }else{
                Toast.makeText(contex, "Số lượng không thể nhỏ hơn 1", Toast.LENGTH_SHORT).show()
            }
        },
            modifier = Modifier
                .background(Color(0xffE0E0E0), shape = RoundedCornerShape(5.dp))
                .size(30.dp),

            ) {
            Icon(Icons.Default.Remove, contentDescription = "", tint = Color(0xff808080))
        }
    }
}

