package com.aussource.jatpackcomposedemo

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.aussource.jatpackcomposedemo.model.DataProvider
import com.aussource.jatpackcomposedemo.model.Puppy

@Composable
fun barkHomeContent() {
    val puppies = remember {
        DataProvider.puppyList
    }
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 8.dp, horizontal = 16.dp
        )
    ) {
        items(items = puppies, itemContent = {
            puppyListItems(puppy = it)
        })
    }
}


