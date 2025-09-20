package com.jacks_lan.thetodolistapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jacks_lan.thetodolistapp.ui.theme.TheToDoListAppTheme

@Composable
fun StandardTopAppBar(
    onNavigateUp: () -> Unit = {},
    title: String = "Title Here",
    showBackArrow: Boolean = true,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                color = if (!isSystemInDarkTheme()) {
                    Color(0xFFCCCACA)
                } else {
                    Color.Black
                }
            ),
    ) {
        if (showBackArrow) {
            IconButton(
                onClick = onNavigateUp,
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    tint = if (!isSystemInDarkTheme()) {Color.Black} else {Color.White},
                    contentDescription = "Back Arrow",
                )
            }
        }

        Text(
            text = title,
            color = if (!isSystemInDarkTheme()) {Color.Black} else {Color.White},
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(name = "Light Mode", showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark Mode", showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewTopAppBar() {
    TheToDoListAppTheme {
        StandardTopAppBar()
    }
}