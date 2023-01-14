package com.rdktechnologies.ncert.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rdktechnologies.ncert.R
import com.rdktechnologies.ncert.component.GridView
import com.rdktechnologies.ncert.component.TopBar
import com.rdktechnologies.ncert.ui.theme.BlueWhite
import com.rdktechnologies.ncert.ui.theme.NCERTTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navigateToListScreen: () -> Unit={}
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BlueWhite),
    ) {
        Image(
            painter = painterResource(R.drawable.ic_bg_shape_blue),
            contentDescription = "background_image",
            contentScale = ContentScale.Fit
        )
        Scaffold(
            backgroundColor = Color.Transparent,   // Make the background transparent
            topBar = {
               TopBar()
            },
        ){
            GridView()
        }
    }
}






@Preview
@Composable
fun PreviewHomeScreen() {
    val context = LocalContext.current
    HomeScreen(navigateToListScreen = {})
}

@Preview
@Composable
fun PreviewHomeScreenDarkTheme() {
    NCERTTheme(darkTheme = true) {
        HomeScreen(navigateToListScreen = {})
    }
}