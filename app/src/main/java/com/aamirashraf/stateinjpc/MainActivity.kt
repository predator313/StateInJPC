package com.aamirashraf.stateinjpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.aamirashraf.stateinjpc.ui.theme.StateInJPCTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //state is very important concept in the ui building
            //mainly related to dynamic ui
            //how ours ui looks at the given moment
            //think state as livedata
            //remember simply remember the last state
            //it will not recreate the state again and set the old state back
            //when recomposition happen
            Column(modifier = Modifier.fillMaxSize()) {
                val color= remember {
                    mutableStateOf(Color.Yellow)
                }
                BoxColor(modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()){
                    color.value=it
                }
                Box(modifier = Modifier.background(
                    color.value

                ).weight(1f)
                    .fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun BoxColor(
    modifier:Modifier=Modifier,
    updateColor:(Color)->Unit

){
//    val color= mutableStateOf(Color.Yellow)
    //if we don't use the remember than it will reset the background color back to the yellow
    //we only see the clickable effect but the color remain yellow

    //to really want to change the color we need to use the remembe also

    Box(modifier = modifier
        .background(
            color =Color.Red
        )
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat()
                )
            )

        }
    )
}