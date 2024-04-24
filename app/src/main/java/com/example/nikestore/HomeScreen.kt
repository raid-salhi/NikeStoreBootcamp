package com.example.nikestore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nikestore.ui.theme.MyBackground
import com.example.nikestore.ui.theme.MyBlack
import com.example.nikestore.ui.theme.MyBlue

@Preview(showBackground = true)
@Composable
fun HomeScreen(){
    val categories = listOf("All Shoes","Outdoor","Tennis","Running")
    val shoes = listOf(
        Shoe(name="Nike Jordan", category = "Outdoor", price = 302.00, pic = R.drawable.nike_shoe_1),
        Shoe(name="Nike Air Max", category = "Tennis", price = 752.00, pic = R.drawable.nike_shoe_2),
        Shoe(name="Nike Essential", category = "Running", price = 182.34, pic = R.drawable.nike_shoe_3),
        Shoe(name="Nike Zoom", category = "Outdoor", price = 593.33, pic = R.drawable.nike_shoe_4)
    )
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
            LazyRow(modifier = Modifier.padding(top = 14.dp)) {
                items(items=categories){
                    CategoryCard(category=it)
                }
            }
            LazyRow(modifier = Modifier.padding(top = 14.dp)) {
                items(items=shoes){
                    ShoeCard(shoe=it)
                }
            }

        }
    }
}

@Composable
fun ShoeCard(shoe: Shoe) {
    Card(
        modifier = Modifier.width(150.dp).padding(end = 14.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column (Modifier.padding(12.dp)){
            Image(
                painter = painterResource(id = shoe.pic),
                contentDescription = "shoe pic",
                modifier = Modifier.height(100.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "BEST SELLER",
                color = MyBlue,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 10.dp)
            )
            Text(
                text = shoe.name,
                color = MyBlack,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                text = "$${shoe.price}",
                color = MyBlack,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }
}

@Composable
fun CategoryCard(category: String) {
    Box(
        modifier = Modifier
            .padding(end=14.dp)
            .size(width = 100.dp, height = 40.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White),
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
