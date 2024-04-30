package com.example.nikestore

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.nikestore.ui.theme.MyBlack
import com.example.nikestore.ui.theme.MyBlue

@Composable
fun StartScreen(navController: NavHostController) {
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MyBlue
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ){
            Image(
                painter = painterResource(id = R.drawable.nike) ,
                contentDescription = "Nike Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth(0.4f)
            )
            Text(
                text = "NIKE",
                fontFamily = FontFamily(listOf(Font(R.font.futura_consended_extra_black))),
                color = Color.White,
                fontSize = 65.sp,
            )
            Button(
                onClick = {
                          navController.navigate("HomeScreen")
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 50.dp, end = 50.dp, top = 20.dp)
                ) {
                Text(
                    text = "Let’s check the store",
                    color = MyBlack,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}