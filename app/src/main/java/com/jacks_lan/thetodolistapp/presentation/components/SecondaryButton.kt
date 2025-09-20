package com.jacks_lan.thetodolistapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jacks_lan.thetodolistapp.ui.theme.TheToDoListAppTheme

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    text: String = "Secondary Button",
    enabled: Boolean = true
) {
    val isDark = isSystemInDarkTheme()
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isDark) Color.Black else Color.White,
            contentColor = if (isDark) Color.White else Color.Black
        ),
        border = BorderStroke(
            width = 1.dp,
            color = if (isDark) Color.White else Color.Black
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
fun PreviewSecondaryButton() {
    TheToDoListAppTheme {
        SecondaryButton()
    }
}
