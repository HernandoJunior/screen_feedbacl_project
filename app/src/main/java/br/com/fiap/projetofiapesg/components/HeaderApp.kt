package br.com.fiap.projetofiapesg.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.projetofiapesg.R

@Composable
fun HeaderApp(name: String, modifier: Modifier?) {
    Box(
        modifier = (modifier ?: Modifier)
            .height(100.dp)
            .fillMaxWidth()
            .background(colorResource(R.color.headerColor)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = name,
            fontSize = 24.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
        )

        Box(
            modifier = Modifier
                .height(70.dp)
                .width(70.dp)
                .align(Alignment.CenterEnd)
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "logo app",
                modifier = Modifier
                    .height(60.dp)
                    .width(100.dp),
                alignment = Alignment.BottomCenter
            )
        }
    }
}