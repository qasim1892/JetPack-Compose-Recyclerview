package com.aussource.jatpackcomposedemo

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aussource.jatpackcomposedemo.model.Puppy
import com.aussource.jatpackcomposedemo.ui.theme.MyTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp { puppy ->
                    startActivity(ProfileActivity.newIntent(this, puppy = puppy))
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyApp(navigateToProfile: (Puppy) -> Unit) {
        Scaffold(content = { padding ->
            Modifier.padding(padding)
            BarkHomeContent(navigateToProfile = navigateToProfile)
        })
    }

    @Preview("Light Theme", widthDp = 360, heightDp = 640)
    @Composable
    private fun LightPreview() {
        MyTheme() {
            MyApp {}
        }
    }

    @Preview("Dark Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun DarkTheme() {
        MyTheme(darkTheme = true) {
            MyApp {}
        }
    }
}
