package br.com.fiap.projetofiapesg.screens.empresas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.projetofiapesg.R
import br.com.fiap.projetofiapesg.components.FooterOptions
import br.com.fiap.projetofiapesg.components.HeaderApp
import br.com.fiap.projetofiapesg.components.VoltarButton

@Composable
fun SelectCompany(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.backgroundColor))
    ) {
        Column {

            HeaderApp("ESG Hub")
            VoltarButton(voltarPage = { navController.navigate("login") })

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, start = 32.dp, end = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Ultimas noticias", fontSize = 24.sp)
                Icon(
                    painter = painterResource(R.drawable.img),
                    contentDescription = ""
                )
            }

            Card(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp),
                colors = CardDefaults.cardColors(colorResource(R.color.backgroundCard)),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),

            ) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 14.dp, horizontal = 20.dp)
                ) {
                    Text(
                        stringResource(R.string.phraseAvance),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                    )
                    Text("Empresa Beleza e Bem Estar anunciou avanços " +
                            "significativos em suas práticas ESG, por meio de implantação" +
                            "de embalagens 100% recicláveis, reduzindo em 30% o uso de" +
                            "plástico e investiu em ingredientes sustentáveis.", fontSize = 18.sp)

                    Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Row (
                                    Modifier.width(80.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ){
                                    Image(
                                        painter = painterResource(R.drawable.imgcomentcompany),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(20.dp)
                                    )
                                    Text("1.092", fontSize = 16.sp)
                                }

                                Row (
                                    Modifier.width(60.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.starimg),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(20.dp)
                                    )
                                    Text("56", fontSize = 16.sp)

                                }
                            }
                            Text(
                                "Leia mais..."
                            )
                        }
                    }
                }


            Spacer(Modifier.padding(top = 40.dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text("Relatório Oficial ESG (Anual) ", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Image(
                    painter = painterResource(R.drawable.sendrelatory),
                    contentDescription = "",
                    modifier = Modifier
                        .size(20.dp)
                )
            }

            Card(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 15.dp)
                    .fillMaxWidth()
                    .height(60.dp),
                shape = CardDefaults.shape,
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(colorResource(R.color.white))
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Ano 2025 - Práticas ESG", fontSize = 20.sp)
                    Icon(
                        painter = painterResource(R.drawable.baseline_arrow_downward_24),
                        contentDescription = ""
                    )
                }
            }
            FooterOptions(R.drawable.baseline_add_24, Color.White, rememberNavController())
        }


        Card(
            modifier = Modifier
                .width(180.dp)
                .align(Alignment.TopCenter)
                .padding(top = 80.dp)
                .zIndex(1f)
                .shadow(
                    20.dp,
                    RectangleShape,
                    true,
                    DefaultShadowColor,
                    DefaultShadowColor
                ),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Row(
                Modifier
                    .width(200.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.imagewritepage),
                    contentDescription = "",
                    Modifier.size(35.dp),
                    alignment = Alignment.CenterEnd
                )
                Text(
                    "Beleza e Bem Estar \n" +
                            "Setor: Perfumaria", fontSize = 12.sp, fontWeight = FontWeight.Bold
                )

            }
        }
    }

}


//@Preview
//@Composable
//private fun SelectCompanyPreview() {
//    SelectCompany()
//}