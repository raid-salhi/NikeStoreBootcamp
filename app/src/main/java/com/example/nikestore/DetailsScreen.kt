package com.example.nikestore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.nikestore.ui.theme.MyBackground
import com.example.nikestore.ui.theme.MyBlack
import com.example.nikestore.ui.theme.MyBlue

//@Preview(showBackground = true)
@Composable
fun DetailsScreen(navHostController: NavHostController, sharedViewmodel: SharedViewmodel){
    val shoe = sharedViewmodel.myShoe.value
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MyBackground
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = { navHostController.popBackStack() },
                        colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White, contentColor = MyBlack)
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "back button",
                            modifier = Modifier.size(26.dp)
                        )
                    }
                    Text(
                        text = "Nike shop",
                        fontFamily = FontFamily(listOf(Font(R.font.raleway_bold))),
                        color = MyBlack,
                        fontSize = 16.sp,
                    )
                    // This invisible Box is to force the row to split the line into 3
                    // so we will have at the start the iconButton and in the middle the text
                    Box(modifier = Modifier.background(Color.Transparent))
                }
                Text(
                    text = shoe.name,
                    fontFamily = FontFamily(listOf(Font(R.font.raleway_bold))),
                    color = MyBlack,
                    fontSize = 32.sp,
                )
                Text(
                    text = "Men's shoes",
                    fontFamily = FontFamily(listOf(Font(R.font.raleway_bold))),
                    color = Color.Gray,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
                Text(
                    text = "$${shoe.price}",
                    fontFamily = FontFamily(listOf(Font(R.font.raleway_bold))),
                    color = MyBlack,
                    fontSize = 24.sp,
                )
                Image(
                    painter = painterResource(id = shoe.pic),
                    contentDescription = "shoe pic",
                    modifier = Modifier
                        .height(300.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 20.dp, bottom = 20.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "The Max Air 270 unit delivers unrivaled, all-day comfort. The sleek, running-inspired design roots you to everything Nike",
                    color = Color.Gray,
                    fontSize = 14.sp,
                )
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(10.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MyBlue, contentColor = Color.White)
            ) {
                Icon(
                    painterResource(id = R.drawable.cart) ,
                    contentDescription = "cart icon",
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp, end = 5.dp)
                        .size(24.dp)
                )
                Text(
                    text = "Add To Cart",
                    fontSize = 14.sp,
                )
            }
        }
    }
}