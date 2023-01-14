package com.rdktechnologies.ncert.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rdktechnologies.ncert.R

@Preview
@Composable
fun TopBar(){
    Box(modifier= Modifier.fillMaxWidth()){
        Row(Modifier.fillMaxWidth()){
            Image(modifier = Modifier
                .weight(1f)
                .padding(start = 29.dp, top = 16.dp)
                ,alignment = Alignment.CenterStart,painter = painterResource(id = R.drawable.ic_hamburger),
                contentDescription ="hamburger icon")
            Spacer(modifier = Modifier.weight(2f))
            Image(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 29.dp, top = 16.dp),
                alignment = Alignment.CenterEnd,
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "hamburger icon")
        }
    }
}