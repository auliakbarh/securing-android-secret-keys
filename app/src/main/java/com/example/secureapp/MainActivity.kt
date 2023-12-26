package com.example.secureapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.secureapp.ui.theme.SecureAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val apiKey: String = BuildConfig.API_KEY
        val baseUrl: String = BuildConfig.BASE_URL
        setContent {
            SecureAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting(apiKey, baseUrl)
                }
            }
        }
    }
}

@Composable
fun Greeting(apiKey: String, baseUrl: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Exposing api key: $apiKey",
            modifier = modifier
        )
        Text(
            text = "Exposing base url: $baseUrl",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val apiKey: String = BuildConfig.API_KEY
    val baseUrl: String = BuildConfig.BASE_URL
    SecureAppTheme {
        Greeting(apiKey, baseUrl)
    }
}