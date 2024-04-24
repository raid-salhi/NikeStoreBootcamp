package com.example.nikestore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nikestore.ui.theme.MyBackground
import com.example.nikestore.ui.theme.MyBlack
@Preview(showBackground = true)
@Composable
fun HomeScreen(){
    val categories = listOf("All Shoes","Outdoor","Tennis","Running")
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MyBackground
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp, top = 10.dp),
        ){
            Text(
                text = "Explore",
                fontFamily = FontFamily(listOf(Font(R.font.raleway_bold))),
                color = MyBlack,
                fontSize = 32.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Select Category",
                color = MyBlack,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 24.dp)
            )
            LazyRow(modifier = Modifier.padding(top = 14.dp, bottom =14.dp)) {
                items(items=categories){
                    CategoryCard(category=it)
                }
            }

        }
    }
}

@Composable
fun CategoryCard(category: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .size(width = 100.dp, height = 40.dp)
            .padding(end = 14.dp),
        contentAlignment = Alignment.Center
        ){
        Text(
            text = category,
            color = MyBlack,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}
