package com.jacks_lan.thetodolistapp.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jacks_lan.thetodolistapp.ui.theme.TheToDoListAppTheme

@Composable
fun MainScaffold(
    onFabClick: () -> Unit = {},
    title: String = "Task Manager",
    showBackArrow: Boolean = true,
    onBackArrowClick: () -> Unit = {},
    content: @Composable (paddingValues: PaddingValues) -> Unit = {},
) {
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            StandardTopAppBar(
                onNavigateUp = onBackArrowClick,
                title = title,
                showBackArrow = showBackArrow
            )
        },
        floatingActionButton = {
        },
        floatingActionButtonPosition = FabPosition.End,
    ) { padding ->
        content(padding)
    }

}

@Preview(name = "Light Mode", showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark Mode", showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewBoth() {
    TheToDoListAppTheme {
        MainScaffold()
    }
}