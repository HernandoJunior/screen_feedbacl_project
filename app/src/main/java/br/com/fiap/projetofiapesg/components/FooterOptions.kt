package br.com.fiap.projetofiapesg.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import br.com.fiap.projetofiapesg.R

@Composable
fun FooterOptions(
    icone: Int,
    color: Color,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Row(
            modifier = Modifier
                .background(colorResource(R.color.colorBottom))
                .fillMaxWidth()
                .height(70.dp)
                .align(Alignment.BottomEnd)
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Row {
                    Icon(
                        modifier = Modifier
                            .padding(start = 30.dp)
                            .size(40.dp)
                            .clickable { navController.navigate("firstpage") },
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
                            .clickable { navController.navigate("empresas") },
                        tint = colorResource(R.color.iconBottomColor),
                        painter = painterResource(R.drawable.listiconbottom),
                        contentDescription = "",

                    )
                    Icon(
                        modifier = Modifier
                            .padding(end = 30.dp)
                            .size(40.dp),
                        tint = colorResource(R.color.iconBottomColor),
                        painter = painterResource(R.drawable.perfiliconbottom),
                        contentDescription = ""
                    )
                }
            }
        }
        Button(
            modifier = Modifier
                .padding(bottom = 30.dp)
                .width(100.dp)
                .height(50.dp)
                .align(Alignment.BottomCenter)
            ,
            colors = ButtonDefaults.outlinedButtonColors(colorResource(R.color.iconBottomColor)),
            onClick = {},

            ) {
            Icon(
                painter = painterResource(icone),
                contentDescription = "",
                tint = color
            )
        }
    }

}

@Preview (showSystemUi = true)
@Composable
private fun FooterOptionsPreview() {}