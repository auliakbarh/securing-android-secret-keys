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
        val apiKey = Secrets().getAPI_KEY(packageName)
        val baseUrl = Secrets().getBASE_URL(packageName)
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
            text = "Api Key: $apiKey",
            modifier = modifier
        )
        Text(
            text = "Base URL: $baseUrl",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SecureAppTheme {
        Greeting("Default API Key", "Default Base URL")
    }
}