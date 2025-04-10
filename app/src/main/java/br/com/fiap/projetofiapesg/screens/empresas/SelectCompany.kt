package br.com.fiap.projetofiapesg.screens.empresas

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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import br.com.fiap.projetofiapesg.R
import br.com.fiap.projetofiapesg.components.FooterOptions
import br.com.fiap.projetofiapesg.components.HeaderApp

@Composable
fun SelectCompany(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.backgroundColor))
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (header, titleBlock, cardList, logo, footer) = createRefs()

            // Header
            HeaderApp("ESG Hub", modifier = Modifier.constrainAs(header) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

            // Títulos
            Column(
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .constrainAs(titleBlock) {
                        top.linkTo(header.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                    }
            ) {
                Text("Empresas", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Text("Selecione a empresa", fontSize = 18.sp)
            }

            // Lista de cards
            Column(
                modifier = Modifier
                    .padding(horizontal = 32.dp, vertical = 16.dp)
                    .fillMaxHeight(0.7f) // Ajustável conforme espaço
                    .verticalScroll(rememberScrollState())
                    .constrainAs(cardList) {
                        top.linkTo(titleBlock.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                repeat(3) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(R.drawable.exemplecompany),
                                contentDescription = "",
                                modifier = Modifier.size(80.dp)
                            )

                            Column(
                                modifier = Modifier.padding(start = 10.dp)
                            ) {
                                Text("Empresa 1", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                                Text("Setor: AAAA", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)

                                Row {
                                    repeat(4) {
                                        Image(
                                            painter = painterResource(R.drawable.starimg),
                                            contentDescription = ""
                                        )
                                    }
                                }
                            }
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalAlignment = Alignment.End
                                ) {
                                    Button(
                                        onClick = { navController.navigate("dadosempresas")},
                                        modifier = Modifier
                                            .width(60.dp)
                                            .height(50.dp),
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

            // Logo
            Icon(
                painter = painterResource(R.drawable.img),
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .constrainAs(logo) {
                        top.linkTo(cardList.bottom, margin = 20.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            // Footer
            FooterOptions(
                icone = R.drawable.baseline_add_24,
                color = Color.White,
                myProfile = {  },
                listFeedbacks = { navController.navigate("myfeedbacks") },
                goHomePage = { navController.navigate("empresas") },
                addFeedback = { navController.navigate("feedback") },
                modifier = Modifier.constrainAs(footer) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
        }
    }
}


//@Preview
//@Composable
//private fun SelectCompanyPreview() {
//    SelectCompany()
//}