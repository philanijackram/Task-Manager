package com.jacks_lan.thetodolistapp.presentation.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.jacks_lan.thetodolistapp.ui.theme.TheToDoListAppTheme

@Composable
fun StandardTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "Enter text"
) {
    val isDark = isSystemInDarkTheme()

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = if (isDark) Color.White else Color.Black,
            unfocusedIndicatorColor = if (isDark) Color.White else Color.Black,
            focusedTextColor = if (isDark) Color.White else Color.Black,
            unfocusedTextColor = if (isDark) Color.White else Color.Black,
            cursorColor = if (isDark) Color.White else Color.Black
        )
    )
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
fun PreviewStandardTextField() {
    TheToDoListAppTheme {
        StandardTextField(
            value = "",
            onValueChange = {}
        )
    }
}
