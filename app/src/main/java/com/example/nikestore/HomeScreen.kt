package com.example.nikestore

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    val allShoes = listOf(
        Shoe(name="Nike Jordan", category = "Outdoor", price = 302.00, pic = R.drawable.nike_shoe_1),
        Shoe(name="Nike Air Max", category = "Tennis", price = 752.00, pic = R.drawable.nike_shoe_2),
        Shoe(name="Nike Essential", category = "Running", price = 182.34, pic = R.drawable.nike_shoe_3),
        Shoe(name="Nike Zoom", category = "Outdoor", price = 593.33, pic = R.drawable.nike_shoe_4)
    )
    val catSelected = remember {
        mutableStateOf("All Shoes")
    }
    val selectedShoes = remember {
        mutableStateOf(allShoes)

    }
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MyBackground
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp),
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
                    CategoryCard(category=it,categorySelected = catSelected.value){
                        catSelected.value =it
                        if (catSelected.value=="All Shoes")
                            selectedShoes.value = allShoes
                        else
                            selectedShoes.value = allShoes.filter { shoe ->
                                shoe.category==catSelected.value
                            }
                    }
                }
            }
            LazyRow(modifier = Modifier.padding(top = 14.dp)) {
                items(items=selectedShoes.value){
                    ShoeCard(shoe=it)
                }
            }
            Text(
                text = "New Arrivals",
                color = MyBlack,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 24.dp)
            )
            NewArrivalsCard()
            Text(
                text = "New Arrivals",
                color = MyBlack,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 24.dp)
            )
            TopSoldCard()
        }
    }
}

@Composable
fun TopSoldCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 14.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp,Color(0xff11C2E0)),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp, start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.nike_shoe_5),
                contentDescription = "shoe pic",
                modifier = Modifier.height(100.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Get Your \n Pair Now !",
                color = Color(0xff11C2E0),
                fontSize = 32.sp,
                fontFamily = FontFamily(listOf(Font(R.font.futura_consended_extra_black))),
            )
        }
    }
}

@Composable
fun NewArrivalsCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 14.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Summer Sale",
                    color = MyBlack,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "15% OFF",
                    color = Color(0xff674DC5),
                    fontSize = 36.sp,
                    fontFamily = FontFamily(listOf(Font(R.font.futura_consended_extra_black))),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.nike_shoe_4),
                contentDescription = "shoe pic",
                modifier = Modifier.height(100.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun ShoeCard(shoe: Shoe) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .padding(end = 14.dp),
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
fun CategoryCard(category: String, categorySelected: String,onClick : () -> Unit) {
    val backColor = if (category==categorySelected) MyBlue else Color.White
    val textColor= if (category==categorySelected) Color.White else MyBlack
    Box(
        modifier = Modifier
            .padding(end = 14.dp)
            .size(width = 100.dp, height = 40.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(backColor)
            .clickable {
                onClick.invoke()
            },
        contentAlignment = Alignment.Center
        ){
        Text(
            text = category,
            color = textColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}
