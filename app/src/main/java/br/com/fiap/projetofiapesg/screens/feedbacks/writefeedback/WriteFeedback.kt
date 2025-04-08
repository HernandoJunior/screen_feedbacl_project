package br.com.fiap.projetofiapesg.screens.feedbacks.writefeedback

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import br.com.fiap.projetofiapesg.R
import br.com.fiap.projetofiapesg.components.FooterOptions

@Composable
fun WriteFeedback(writeFeedbackViewModel: WriteFeedbackViewModel, navController: NavController) {
    val text by writeFeedbackViewModel.text.observeAsState("")
    val checked by writeFeedbackViewModel.checked.observeAsState(false)
    val expanded by writeFeedbackViewModel.expanded.observeAsState(false)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.backgroundColor))
    ) {
        // Header fixo
        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(colorResource(R.color.headerColor)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Feedbacks",
                fontSize = 24.sp,
                color = Color.White,
                textAlign = TextAlign.Center
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

        // Card fixo abaixo do header
        Card(
            modifier = Modifier
                .width(180.dp)
                .align(Alignment.TopCenter)
                .padding(top = 80.dp)
                .zIndex(1f)
                .shadow(20.dp, RectangleShape, true),
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

        // Conteúdo rolável (formulário)
        Column(
            modifier = Modifier
                .padding(top = 180.dp, bottom = 90.dp)
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
            ) {
                item {
                    Text("Enviado por:", fontSize = 15.sp)
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Nome") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp),
                        shape = RoundedCornerShape(20.dp),
                        trailingIcon = {
                            IconButton(onClick = {
                                writeFeedbackViewModel.onExpandedList(expanded)
                            }) {
                                Icon(
                                    painter = painterResource(R.drawable.baseline_arrow_downward_24),
                                    contentDescription = "Mais opções"
                                )
                            }
                        }
                    )
                }

                item {
                    Text("Categoria:", fontSize = 15.sp)
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Categoria") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp),
                        shape = RoundedCornerShape(20.dp),
                        trailingIcon = {
                            IconButton(onClick = {}) {
                                Icon(
                                    painter = painterResource(R.drawable.baseline_arrow_downward_24),
                                    contentDescription = ""
                                )
                            }
                        }
                    )
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_attach_file_24),
                            contentDescription = ""
                        )
                        Text("Anexar arquivo", fontSize = 15.sp)
                    }
                }

                item {
                    Text("Relato do feedback:")
                    OutlinedTextField(
                        value = text,
                        onValueChange = { writeFeedbackViewModel.onFeedBackChange(it) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .padding(vertical = 12.dp),
                        shape = RoundedCornerShape(8.dp)
                    )
                }

                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = checked,
                            onCheckedChange = { writeFeedbackViewModel.onCheckedBox(it) }
                        )
                        Text(
                            if (checked) "Anônimo habilitado" else "Anônimo desabilitado"
                        )
                    }
                }

                item {
                    Button(
                        onClick = { navController.navigate("confirmfeedback")},
                        colors = ButtonDefaults.buttonColors(colorResource(R.color.iconBottomColor)),
//                        modifier = Modifier.align(Alignment.Center)
                    ) {
                        Text(
                            text = stringResource(R.string.confirm),
                            fontSize = 18.sp
                        )
                    }
                }

            }
        }

        // Footer fixo
        FooterOptions(
            icone = R.drawable.starimg,
            color = Color.White,
            myProfile = { },
            listFeedbacks = { navController.navigate("myfeedbacks") },
            goHomePage = { navController.navigate("empresas") },
            addFeedback = { navController.navigate("feedback") },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}


//@Preview (showSystemUi = true)
//@Composable
//private fun WriteFeedbackPreview() {
//    WriteFeedback(WriteFeedbackViewModel())
//}