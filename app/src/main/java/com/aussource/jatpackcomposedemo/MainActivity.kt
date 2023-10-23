package com.aussource.jatpackcomposedemo

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aussource.jatpackcomposedemo.model.Puppy
import com.aussource.jatpackcomposedemo.ui.theme.myTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myTheme {
                myApp { puppy ->
                    startActivity(ProfileActivity.newIntent(this, puppy = puppy))
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun myApp(navigateToProfile: (Puppy) -> Unit) {
        Scaffold(content = { padding ->
            Modifier.padding(padding)
            barkHomeContent(navigateToProfile = navigateToProfile)
        })
    }

    @Preview("Light Theme", widthDp = 360, heightDp = 640)
    @Composable
    private fun lightPreview() {
        myTheme() {
            myApp {}
        }
    }

    @Preview("Dark Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun darkTheme() {
        myTheme(darkTheme = true) {
            myApp {}
        }
    }
}
