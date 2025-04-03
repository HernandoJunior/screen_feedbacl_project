package br.com.fiap.projetofiapesg.screens.empresas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.projetofiapesg.R
import br.com.fiap.projetofiapesg.components.FooterOptions
import br.com.fiap.projetofiapesg.components.HeaderApp

@Composable
fun CompanyData() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.backgroundColor))
    ) {
        Column {
            HeaderApp("ESG Hub")

            //COLUNA TEXTO EMPRESAS / SELECIONE A EMPRESA
            Column (
                modifier = Modifier
                    .padding(top = 32.dp, start = 32.dp)
            ) {
                Text(
                    "Empresas",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Text(
                    "Selecione a empresa",
                    fontSize = 18.sp
                )
            }
            //Coluna de CARDS
            Column (
                modifier = Modifier
                    .padding(top = 32.dp, start = 32.dp)
                    .verticalScroll(rememberScrollState())
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                repeat(3){
                    Card(
                        modifier = Modifier
                            .width(300.dp)
                            .height(110.dp)
                            .background(Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
                    ) {
                        Row (
                            modifier = Modifier
                                .padding(start = 10.dp, top = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(R.drawable.exemplecompany),
                                contentDescription = "",
                                Modifier.size(80.dp)
                            )
    
                            Column (
                                modifier = Modifier
                                    .padding(top = 16.dp, start = 10.dp)
                            ) {
                                Text("Empresa 1", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                                Text("Setor: AAAA", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                                Row {
                                    repeat(4){
                                        Image(
                                            painter = painterResource(R.drawable.starimg),
                                            contentDescription = ""
                                        )
                                    }
                                }
                                Row(
                                    modifier = Modifier
                                        .width(180.dp),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Button(
                                        onClick = {},
                                        modifier = Modifier
                                            .width(50.dp),
                                        contentPadding = ButtonDefaults.TextButtonContentPadding,
                                        colors = ButtonDefaults.buttonColors(colorResource(R.color.iconBottomColor))
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                                            contentDescription = "",
                                            tint = Color.White
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            { Icon(
                painter = painterResource(R.drawable.img),
                contentDescription = ""
            ) }

            FooterOptions(R.drawable.baseline_add_24, Color.White, rememberNavController())
        }
    }
}

@Preview
@Composable
private fun CompanyDataPreview() {
    CompanyData()
}