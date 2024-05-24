package com.example.asm_ph33119.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bed
import androidx.compose.material.icons.outlined.Chair
import androidx.compose.material.icons.outlined.ChairAlt
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.TableBar
import androidx.compose.material.icons.rounded.Bed
import androidx.compose.material.icons.rounded.Chair
import androidx.compose.material.icons.rounded.ChairAlt
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.TableBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.asm_ph33119.data.Categories

class CategorySection {
}

val items = listOf(
    Categories(1, "Popular", Icons.Outlined.Star, false),
    Categories(2, "Chair", Icons.Outlined.ChairAlt, false),
    Categories(3, "Table", Icons.Outlined.TableBar, false),
    Categories(4, "Armchair", Icons.Outlined.Chair, false),
    Categories(4, "Bed", Icons.Outlined.Bed, false),


    )
@Preview
@Composable
fun CategoriesSection () {
    LazyRow(modifier = Modifier.padding(10.dp).background(Color.White).padding(5.dp)) {
        items(items.size) { index ->
            CategoryItem(index)
        }
    }
}


@Composable
fun CategoryItem(index: Int) {
    val category = items[index]
    val itemWidth = 100.dp // Set a fixed width for each item
    val padding = 16.dp

    Box(
        modifier = Modifier
            .width(itemWidth)
            .height(100.dp)
            .padding(start = padding, end = if (index == items.size - 1) padding else 0.dp, top = padding)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xffF5F5F5) )
            .clickable { },
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(8.dp), // Add padding inside the item for better spacing
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally

        ) {
            Icon(imageVector = category.image,
                modifier = Modifier.size(24.dp),
                contentDescription = "Category",
                tint = MaterialTheme.colorScheme.onSecondaryContainer)
            Spacer(Modifier.height(8.dp))
            Text(text = category.name, style = MaterialTheme.typography.labelLarge)
        }
    }
}