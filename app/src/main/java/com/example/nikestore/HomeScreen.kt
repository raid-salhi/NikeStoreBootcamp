package com.example.nikestore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MyBackground
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end=20.dp, top = 10.dp),
        ){
            Text(
                text = "Explore",
                fontFamily = FontFamily(listOf(Font(R.font.raleway_bold))),
                color = MyBlack,
                fontSize = 32.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}