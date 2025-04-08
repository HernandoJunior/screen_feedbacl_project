package br.com.fiap.projetofiapesg.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.projetofiapesg.R

@Composable
fun FooterOptions(
    color: Color,
    icone: Int,
    addFeedback: () -> Unit,
    goHomePage: () -> Unit,
    listFeedbacks: () -> Unit,
    myProfile: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Row(
            modifier = Modifier
                .background(colorResource(R.color.colorBottom))
                .fillMaxWidth()
                .height(70.dp)
                .align(Alignment.BottomCenter),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Icon(
                    modifier = Modifier
                        .padding(start = 30.dp)
                        .size(40.dp)
                        .clickable { goHomePage() },
                    tint = colorResource(R.color.iconBottomColor),
                    painter = painterResource(R.drawable.houseiconbottom),
                    contentDescription = ""
                )
                Icon(
                    modifier = Modifier
                        .padding(start = 30.dp)
                        .size(40.dp),
                    tint = colorResource(R.color.iconBottomColor),
                    painter = painterResource(R.drawable.searchiconbottom),
                    contentDescription = ""
                )
            }

            Row {
                Icon(
                    modifier = Modifier
                        .padding(end = 30.dp)
                        .size(40.dp)
                        .clickable { listFeedbacks() },
                    tint = colorResource(R.color.iconBottomColor),
                    painter = painterResource(R.drawable.listiconbottom),
                    contentDescription = ""
                )
                Icon(
                    modifier = Modifier
                        .padding(end = 30.dp)
                        .size(40.dp)
                        .clickable { myProfile() },
                    tint = colorResource(R.color.iconBottomColor),
                    painter = painterResource(R.drawable.perfiliconbottom),
                    contentDescription = ""
                )
            }
        }

        Button(
            modifier = Modifier
                .width(100.dp)
                .height(50.dp)
                .align(Alignment.Center), // botão centralizado acima da barra
            colors = ButtonDefaults.outlinedButtonColors(colorResource(R.color.iconBottomColor)),
            onClick = { addFeedback() }
        ) {
            Icon(
                painter = painterResource(icone),
                contentDescription = "",
                tint = color
            )
        }
    }
}

//@Preview (showSystemUi = true)
//@Composable
//private fun FooterOptionsPreview() {
//}}