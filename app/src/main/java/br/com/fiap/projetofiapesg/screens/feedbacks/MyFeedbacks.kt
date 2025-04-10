package br.com.fiap.projetofiapesg.screens.feedbacks


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.content.contentReceiver
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import br.com.fiap.projetofiapesg.R
import br.com.fiap.projetofiapesg.components.FooterOptions
import br.com.fiap.projetofiapesg.components.HeaderApp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController


@Composable
fun MyFeedbacks(navController: NavController, modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.backgroundColor))
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (header, titleBlock, listFeedbacks, footer) = createRefs()

            // Header
            HeaderApp("ESG Hub", modifier = Modifier.constrainAs(header) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

            // Card fixo com informações da empresa
            Card(
                modifier = Modifier
                    .width(180.dp)
                    .padding(top = 80.dp)
                    .zIndex(1f)
                    .shadow(20.dp, RectangleShape, true)
                    .constrainAs(titleBlock) {
                        top.linkTo(header.top)
                        start.linkTo(parent.start, margin = 120.dp)
                    },
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.imagewritepage),
                        contentDescription = "",
                        modifier = Modifier.size(35.dp)
                    )
                    Text(
                        "Beleza e Bem Estar \nSetor: Perfumaria",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // LazyColumn (RecyclerView)
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.7f)
                    .padding(16.dp)
                    .constrainAs(listFeedbacks) {
                        top.linkTo(titleBlock.bottom, margin = 20.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(3) { index ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                repeat(4) {
                                    Icon(
                                        painter = painterResource(R.drawable.starimg),
                                        contentDescription = "",
                                        modifier = Modifier.size(15.dp)
                                    )
                                }
                            }

                            Text(
                                "Anonimo: Sim\nEnviado por: Fornecedor\nCategoria: Sustentabilidade",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(top = 8.dp)
                            )

                            Text(
                                "Relato:",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
                            )

                            Text(
                                "Ótima iniciativa de reaproveitamento de embalagens! Esse compromisso com a sustentabilidade reforça a responsabilidade ESG da empresa e mostra que é possível unir inovação e respeito ao meio ambiente. ♻🌱",
                                fontSize = 16.sp
                            )

                            Text(
                                "Anexos: ",
                                modifier = Modifier.padding(top = 16.dp)
                            )
                        }
                    }
                }
            }

            // Footer
            FooterOptions(
                icone = R.drawable.baseline_add_24,
                color = Color.White,
                myProfile = { },
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


//@Preview(showSystemUi = true)
//@Composable
//private fun MyFeedbacksPreview() {
//    MyFeedbacks()
//}