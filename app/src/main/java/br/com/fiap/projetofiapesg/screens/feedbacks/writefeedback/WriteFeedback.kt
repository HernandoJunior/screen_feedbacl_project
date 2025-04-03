package br.com.fiap.projetofiapesg.screens.feedbacks.writefeedback

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import br.com.fiap.projetofiapesg.R

@Composable
fun WriteFeedback(writeFeedbackViewModel: WriteFeedbackViewModel) {
    //estado do text area
    val text by writeFeedbackViewModel.text.observeAsState("")
//  estado do checkbox
    val checked by writeFeedbackViewModel.checked.observeAsState(false)
//    Armazenando estado do scrollG
    val state = rememberScrollState()
    //estado de seleção de menu
    val expanded by writeFeedbackViewModel.expanded.observeAsState(false)
    val contractList by writeFeedbackViewModel.contractList.observeAsState(false)

    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(state)
        .background(colorResource(id = R.color.backgroundColor))) {

        Card(
            modifier = Modifier
                .width(180.dp)
                .align(Alignment.TopCenter)
                .padding(top = 80.dp)
                .zIndex(1f)
                .shadow(20.dp,
                    RectangleShape,
                    true,
                    DefaultShadowColor,
                    DefaultShadowColor ),
            colors = CardDefaults.cardColors(Color.White)
        ){
            Row (
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
                Text("Beleza e Bem Estar \n" +
                        "Setor: Perfumaria", fontSize = 12.sp, fontWeight = FontWeight.Bold)

            }
        }

            Box (
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
                        Modifier.height(60.dp)
                            .width(100.dp),
                        alignment = Alignment.BottomCenter
                    )
                }
            }

        Column(
            modifier = Modifier
                .fillMaxSize()
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 150.dp, start = 20.dp)
            ) {

                Text(
                    "Enviado por: ",
                    fontSize = 15.sp,
                    color = Color.Black
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(stringResource(R.string.send_by))
                    },
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                        .background(colorResource(R.color.backgroundColor))
                        .shadow(20.dp, RectangleShape, false, DefaultShadowColor, DefaultShadowColor ),
                    shape = RoundedCornerShape(20.dp),
                    trailingIcon = {
                        IconButton(onClick = {
                            writeFeedbackViewModel.onExpandedList(expanded) }) {
                            Icon(painterResource((R.drawable.baseline_arrow_downward_24)), contentDescription = "More options")
                        }
                    }
                )
                Text(
                    "Categoria: ",
                    fontSize = 15.sp,
                    color = Color.Black
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(stringResource(R.string.category))
                    },
                    modifier = Modifier
                        .background(colorResource(R.color.backgroundColor))
    //                    .border(shape = RectangleShape, border = BorderStroke(1.dp, color = Color.Black))
                        .shadow(20.dp, RectangleShape, false, DefaultShadowColor, DefaultShadowColor ),
                    shape = RoundedCornerShape(20.dp),
                    trailingIcon = {
                        IconButton(onClick = {}) {
                            Icon(painterResource((R.drawable.baseline_arrow_downward_24)), contentDescription = "More options")
                        }
                    }
                )
            }

            Row (
                modifier = Modifier
                    .width(300.dp)
                    .height(70.dp)
                    .padding(start = 20.dp, top = 12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .width(200.dp)
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Anexar arquivo: ",
                        Modifier
                            .padding(bottom = 12.dp),
                        fontSize = 15.sp
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(top = 12.dp, start = 12.dp)
                        .fillMaxWidth()
                        .height(70.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_attach_file_24),
                        contentDescription = ""
                    )

                    Text(
                        "File",
                        textAlign = TextAlign.Start,
                        fontSize = 12.sp
                    )
                }
                
            }
            //Feedback and fieldset
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 12.dp)
            ){
                Text(
                    "Relato do feedback:"
                )
                OutlinedTextField(
                    value = text,
                    onValueChange = {
                        writeFeedbackViewModel.onFeedBackChange(it)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(top = 20.dp, end = 12.dp)
                        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)),
                    trailingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_downward_24),
                            contentDescription = ""
                        )
                    }
                )
            }

            //Checkbox autonomo
            Row(
                modifier = Modifier
                    .padding(start = 20.dp ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = {
                        writeFeedbackViewModel.onCheckedBox(it)
                    }
                )
                Text(
                    if (checked) "Anonimo Habilitado" else "Anonimo Desabilitado"
                )
            }

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
                                    .size(40.dp),
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
                                    .size(40.dp),
                                tint = colorResource(R.color.iconBottomColor),
                                painter = painterResource(R.drawable.listiconbottom),
                                contentDescription = ""
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
                    Text("Enviar",
                        fontSize = 16.sp,
                        color = Color.White)
                }
            }
        } //end column main



    }
}

@Preview (showSystemUi = true)
@Composable
private fun WriteFeedbackPreview() {
    WriteFeedback(WriteFeedbackViewModel())
}