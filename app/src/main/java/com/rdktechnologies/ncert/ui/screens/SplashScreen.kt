package com.rdktechnologies.ncert.ui.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rdktechnologies.ncert.R
import com.rdktechnologies.ncert.ui.theme.BlueWhite
import com.rdktechnologies.ncert.ui.theme.NCERTTheme
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    logo:Int = getLogo(),
    text:String="",
    afterDelay: () -> Unit={}
) {
    var startAnimation by remember { mutableStateOf(false) }
    val offsetState by animateDpAsState(
        targetValue = if (startAnimation) 0.dp else 100.dp,
        animationSpec = tween(
            durationMillis = 1000,
        )
    )

    val alphaState by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )

    LaunchedEffect(key1 = true, block = {
        startAnimation = true
        // delay of 3000 ms
        delay(3000)
        afterDelay()
    })
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BlueWhite),
        contentAlignment = Alignment.Center
    ) {

        Column {
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .offset(y = offsetState)
                    .alpha(alpha = alphaState)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = logo),
                contentDescription = "ncert app logo"
            )
            Text(
                text = text, modifier = Modifier
                    .offset(y = offsetState)
                    .alpha(alpha = alphaState),
                fontSize=54.sp,
                fontStyle = FontStyle(0),
                fontFamily = FontFamily(Font(R.font.roboto_bold))
            )
        }

    }
}

@Composable
fun getLogo(): Int {
    return if (isSystemInDarkTheme()) {
        R.drawable.logo
    } else {
        R.drawable.logo
    }
}

@Preview
@Composable
fun PreviewSplashScreen() {
    val context = LocalContext.current
    SplashScreen(logo = getLogo(),text =context.resources.getString(R.string.splash_text))
}

@Preview
@Composable
fun PreviewSplashScreenDarkTeam() {
    val context = LocalContext.current
    NCERTTheme(darkTheme = true) {
        SplashScreen(logo = getLogo(), text = context.resources.getString(R.string.splash_text))
    }
}