import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import br.com.fiap.projetofiapesg.R
import br.com.fiap.projetofiapesg.components.FooterOptions
import br.com.fiap.projetofiapesg.components.HeaderApp
import br.com.fiap.projetofiapesg.components.VoltarButton

@Composable
fun CompanyData(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.backgroundColor))
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 100.dp) // Espaço para o Footer não cobrir conteúdo
        ) {
            item {
                HeaderApp("ESG Hub", modifier = null)
                Card(
                    modifier = Modifier
                        .width(180.dp)
                        .zIndex(1f)
                        .offset(x = 110.dp, y = -20.dp)
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

                VoltarButton(voltarPage = { navController.navigate("empresas") })

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp, vertical = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Ultimas noticias", fontSize = 24.sp)
                    Icon(
                        painter = painterResource(R.drawable.img),
                        contentDescription = ""
                    )
                }

                // Card fixo (Beleza e Bem Estar)
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
                        Text(
                            "Empresa Beleza e Bem Estar anunciou avanços " +
                                    "significativos em suas práticas ESG, por meio de implantação" +
                                    "de embalagens 100% recicláveis, reduzindo em 30% o uso de" +
                                    "plástico e investiu em ingredientes sustentáveis.",
                            fontSize = 18.sp
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Row(
                                    Modifier.width(80.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.imgcomentcompany),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(20.dp)
                                    )
                                    Text("1.092", fontSize = 16.sp)
                                }

                                Row(
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
                            Text("Leia mais...")
                        }
                    }
                }
            }

            item {
                Spacer(Modifier.height(40.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text("Relatório Oficial ESG (Anual)", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Image(
                        painter = painterResource(R.drawable.sendrelatory),
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            item {
                Card(
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 15.dp)
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = CardDefaults.shape,
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    colors = CardDefaults.cardColors(colorResource(R.color.white))
                ) {
                    Row(
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
            }
        }

        FooterOptions(
            icone = R.drawable.baseline_add_24,
            color = Color.White,
            myProfile = { },
            listFeedbacks = { navController.navigate("myfeedbacks") },
            goHomePage = { navController.navigate("empresas") },
            addFeedback = { navController.navigate("feedback") },
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }


}
//
//@Preview (showSystemUi = true)
//@Composable
//private fun CompanyDataPreview() {
//    CompanyData()
//}
