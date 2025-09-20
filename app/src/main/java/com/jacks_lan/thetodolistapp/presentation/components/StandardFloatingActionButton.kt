package com.jacks_lan.thetodolistapp.presentation.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jacks_lan.thetodolistapp.ui.theme.TheToDoListAppTheme

@Composable
fun StandardFloatingActionButton(
    onClick: () -> Unit = {},
    icon: ImageVector = Icons.Default.AddCircle,
    contentDescription: String = "Add Task"
) {
    Button(
        onClick = onClick,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 12                    .dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (!isSystemInDarkTheme()) Color.Black else Color.White,
            contentColor = if (!isSystemInDarkTheme()) Color.White else Color.Black
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = contentDescription)
        }

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
fun PreviewStandardFloatingActionButton() {
    TheToDoListAppTheme {
        StandardFloatingActionButton()
    }
}