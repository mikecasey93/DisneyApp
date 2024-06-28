package com.example.disneyapp.app.ui.compose.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.disneyapp.app.ui.compose.SliceStringFunction.cutString
import com.example.disneyapp.common.nav.routes.DisneyInput


@Composable
fun DisneyDetailsScreen(disneyInput: DisneyInput) {
    Column(
    verticalArrangement = Arrangement.spacedBy(8.dp),
    modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Text(
            "${disneyInput.name}",
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(40.dp))
        Image(
            painter = rememberAsyncImagePainter(model = disneyInput.image),
            contentDescription = "",
            modifier = Modifier
                .size(250.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(40.dp))
        ClickableUrlText(url = disneyInput.sourceUrl ?: "")
        Text(
            "${cutString(disneyInput.updatedAt)}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally),
            fontSize = 20.sp
        )
    }
}

@Composable
fun ClickableUrlText(url: String) {
    val annotatedText = buildAnnotatedString {
        append(url)
        addStyle(
            style = SpanStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            ),
            start = 0,
            end = url.length
        )
        addStringAnnotation(
            tag = "URL",
            annotation = url,
            start = 0,
            end = url.length
        )
    }
    val context = LocalContext.current
    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = "URL",
                start = offset,
                end = offset
            ).firstOrNull()?.let { annotation ->
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(annotation.item))
                context.startActivity(intent)
            }
        },
        style = TextStyle(
            fontSize = 20.sp
        ),
    )
}