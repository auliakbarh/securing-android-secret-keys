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
        // inside of an Activity, `getString` is called directly
        // inside of an Activity, `getString` is called directly
        val baseUrl: String = getString(R.string.base_url)
        val googleMapApiKey: String = getString(R.string.google_maps_api_key)
        // inside of another class (requires a context object to exist)
        // inside of another class (requires a context object to exist)
        // val secretValue: String = context.getString(R.string.base_url)
        setContent {
            SecureAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting(baseUrl, googleMapApiKey)
                }
            }
        }
    }
}

@Composable
fun Greeting(baseUrl: String, googleMapApiKey: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Exposing Base URL: $baseUrl",
            modifier = modifier
        )
        Text(
            text = "Exposing Google API Key: $googleMapApiKey",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SecureAppTheme {
        Greeting("Default Base URL", "Google Map API Key")
    }
}