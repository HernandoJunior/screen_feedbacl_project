package br.com.fiap.projetofiapesg.screens.feedbacks

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyFeedbacks(modifier: Modifier = Modifier) {
    ConfirmFeedback()
}

@Preview (showSystemUi = true)
@Composable
private fun MyFeedbacksPreview() {
    MyFeedbacks()
}