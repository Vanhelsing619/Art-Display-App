package com.example.artdisplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artdisplay.ui.theme.ArtDisplayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtDisplayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppPreview()
                }
            }
        }
    }
}

@Composable
fun AppDisplay() {
    var result by remember { mutableStateOf(0) }
    var ImageResource=0
    var TextResource=0
    var TextResource2=0
    if(result ==0){
        ImageResource=R.drawable._kq8ryntn6l91
        TextResource=R.string.Art_name1
        TextResource2=R.string.artist_name1
    }
    else if(result==1){
        ImageResource=R.drawable._w5ayay8wf3b1
        TextResource=R.string.Art_name2
        TextResource2=R.string.artist_name2
    }
    else if(result==2){
        ImageResource=R.drawable._blayzqho9ya1
        TextResource=R.string.Art_name3
        TextResource2=R.string.artist_name3
    }
    Column (modifier= Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ){
    Image(painter = painterResource(id = ImageResource), contentDescription = null)
        Spacer(modifier = Modifier.height(30.dp))
        Text(stringResource(id = TextResource) ,fontSize = 20.sp)
        Spacer(modifier = Modifier.height(5.dp))
        Text(stringResource(id = TextResource2), fontSize = 15.sp,fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(10.dp))
        Row (modifier=Modifier,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(onClick = { if(result>0)
            {
                result--
            }
                             },modifier=Modifier) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {if(result<2) {
                result++
            }
            }) {
                Text(text = "    Next     ")

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    ArtDisplayTheme {
        AppDisplay()
    }
}