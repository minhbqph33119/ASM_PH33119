package com.example.asm_ph33119.compose

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
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.rounded.ShoppingBag
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.asm_ph33119.R
import com.example.asm_ph33119.data.Products

val favoriteLists = listOf(
    Products(1, "Black Simple Lamp", 100.0,  R.drawable.sp1, false),
    Products(2, "Minimal Stand", 200.0,  R.drawable.sp2, false),
    Products(3, "Coffee Chair", 300.0,  R.drawable.sp3, false),
    Products(4, "Simple Desk", 400.0,  R.drawable.sp4, false),

    Products(5, "Black Simple Lamp", 100.0,  R.drawable.sp1, false),
    Products(6, "Minimal Stand", 200.0,  R.drawable.sp2, false),
    Products(7, "Coffee Chair", 300.0,  R.drawable.sp3, false),
    Products(8, "Simple Desk", 400.0,  R.drawable.sp4, false),
    )

@Preview
@Composable
fun FavoriteSection(){
    LazyColumn {items(favoriteLists.size) { index ->
        FavoriteItem(index)
        if (index < favoriteLists.size - 1) {
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
    }
}

@Composable
fun FavoriteItem(index: Int){
    val fav = favoriteLists[index]
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(5.dp)
            .padding(top = 10.dp, bottom = 10.dp),
        contentAlignment = Alignment.Center
    ){
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
                        painter = painterResource(id = fav.image),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Column(modifier = Modifier.padding(start = 20.dp)) {
                        Text(text = fav.name, color = Color(0xff606060))
                        Text(text = "$${fav.price}")
                    }
                }
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(10.dp) // margin
                            .width(35.dp)
                            .height(35.dp)
                            .padding(0.dp) // space between the borders
                            .padding(0.dp) // padding
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Cancel,
                            contentDescription = "",
                            Modifier.size(30.dp),
                        )
                    }
                    IconButton(
                        onClick = { cartList.add(fav) },
                        modifier = Modifier
                            .padding(10.dp) // margin
                            .width(35.dp)
                            .height(35.dp)
                            .background(
                                Color(0xFF606060).copy(alpha = 0.5f),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(0.dp) // space between the borders
                            .padding(0.dp) // padding
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingBag,
                            contentDescription = "",
                            Modifier.size(20.dp),
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}