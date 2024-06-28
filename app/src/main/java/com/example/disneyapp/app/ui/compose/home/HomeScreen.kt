package com.example.disneyapp.app.ui.compose.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.test.annotation.ExperimentalTestApi
import com.example.disneyapp.R
import com.example.disneyapp.common.nav.NavRoutes

@Composable
fun HomeScreen(navController: NavController) {
    val options = listOf(
        Pair("Characters List", NavRoutes.ROUTE_DISNEY)
    )

    @OptIn(ExperimentalTestApi::class)
    val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )

    val backgroundImage: Painter = painterResource(R.drawable.disney_background)

    Image(
        painter = backgroundImage,
        contentDescription = "Background Image",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            "DISNEY APP",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 60.dp),
            color = Color.White,
            fontSize = 45.sp
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            GridOption(name = options[0].first) {
                if (options[0].second.isNotEmpty()) {
                    navController.navigate(options[0].second)
                }
            }
        }
    }
}

@Composable
fun GridOption(name: String, perform: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .clickable { perform() },
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.card_image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White.copy(alpha = 0.5f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    name,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
            }
        }
    }
}