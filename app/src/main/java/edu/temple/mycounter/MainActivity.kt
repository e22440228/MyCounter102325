package edu.temple.mycounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import edu.temple.mycounter.ui.theme.MyCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCounterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counter(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Counter(modifier: Modifier = Modifier) {

    var counter by rememberSaveable { mutableIntStateOf(0) }

        Column (modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){

        Button(onClick = {
            counter++
        }) {
            Image(painter = painterResource(android.R.drawable.arrow_up_float), contentDescription = "Up Arrow")
        }
        Text(
            text = counter.toString(),
            fontSize = 180.sp
        )
        Button(onClick = {
            counter--
        }) {
            Image(painter = painterResource(android.R.drawable.arrow_down_float), contentDescription = "Down Arrow")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyCounterTheme {
        Greeting("John")
    }
}

@Preview(showBackground = true)
@Composable
fun counterPreview() {
    MyCounterTheme {
        Counter()
    }
}

