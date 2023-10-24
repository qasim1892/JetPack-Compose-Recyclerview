package com.aussource.jatpackcomposedemo

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.aussource.jatpackcomposedemo.model.Puppy

@Composable
fun ProfileScreen(puppy: Puppy, onNavIconPressed: () -> Unit = { }) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints(modifier = Modifier.weight(1f)) {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {

                }
            }
        }
    }

    @Composable
    fun profileHeader(
        scrollState: ScrollState,
        puppy: Puppy,
        containerHeight: Dp
    ) {
        val offset=(scrollState.value/2)
            // val offsetDp=with(LocalDensity.current)(offset.toDp)
    }
}