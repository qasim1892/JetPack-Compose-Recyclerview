package com.aussource.jatpackcomposedemo

import android.net.wifi.hotspot2.pps.HomeSp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aussource.jatpackcomposedemo.model.Puppy
import com.aussource.jatpackcomposedemo.ui.theme.Typography
import com.aussource.jatpackcomposedemo.ui.theme.graySurface

@Composable
fun puppyListItems(
    puppy: Puppy, navigationToProfile: (Puppy) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = graySurface),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
    ) {
        Row(Modifier.clickable { navigationToProfile(puppy) }) {
            puppyImage(puppy)
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .align(alignment = Alignment.CenterVertically)
            ) {
                Text(text = puppy.title, style = Typography.titleSmall)
                Text(text = "View Details", style = Typography.bodyMedium)
            }
        }
    }

}

@Composable
private fun puppyImage(puppy: Puppy) {
    Image(
        painter = painterResource(id = puppy.puppyImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}
