package com.jacks_lan.thetodolistapp.presentation.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.jacks_lan.thetodolistapp.ui.theme.TheToDoListAppTheme

@Composable
fun PrimaryButton(
    onClick: () -> Unit = {},
    text: String = "Primary Button",
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (!isSystemInDarkTheme()) Color.Black else Color.White,
            contentColor = if (!isSystemInDarkTheme()) Color.White else Color.Black
        )
    ) {
        Text(text = text)
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Dark Mode",

    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewPrimaryButton() {
    TheToDoListAppTheme {
        PrimaryButton()
    }
}