package br.com.fiap.projetofiapesg.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.projetofiapesg.R

@Composable
fun VoltarButton(
    voltarPage: () -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp, start = 32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.baseline_arrow_back_24),
            contentDescription = ""
        )
        Text(
            "Voltar",
            fontSize = 16.sp,
            modifier = Modifier
                .clickable { voltarPage() }
        )
    }
}