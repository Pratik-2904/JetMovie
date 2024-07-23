package com.example.jetmovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetmovie.navagation.Navigation
import com.example.jetmovie.ui.theme.JetMovieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetMovieTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetMovieTheme {
        content()
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        Navigation()
    }
}
