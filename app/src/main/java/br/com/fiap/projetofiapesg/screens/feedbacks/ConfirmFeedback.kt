package br.com.fiap.projetofiapesg.screens.feedbacks

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.projetofiapesg.R
import br.com.fiap.projetofiapesg.screens.feedbacks.writefeedback.WriteFeedback
import br.com.fiap.projetofiapesg.screens.feedbacks.writefeedback.WriteFeedbackViewModel

@Composable
fun ConfirmFeedback() {

    WriteFeedback(WriteFeedbackViewModel())

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.hsl(211F,0.5F,0.7F, alpha = 0.5F)),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 28.dp, vertical = 32.dp)
                .offset(x = 0.dp, y = 500.dp),
        ) {
            Column (
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 20.dp)
            ) {
                Text(
                    "Enviar Feedback",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "Classifique",
                    fontSize = 18.sp
                )

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.Center
                ){
                    repeat(4){
                        Image(
                            painter = painterResource(R.drawable.starimg),
                            contentDescription = "",
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                }

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(
                            onClick = {},
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        border = BorderStroke(1.dp, color = Color.Red)
                        ) {
                        Text(
                            "Cancelar",
                            color = Color.Red)
                    }

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(colorResource(R.color.iconBottomColor))
                    ) {
                        Text("Confirmar")
                    }
                }
            }
        }
    }
}

@Preview (showSystemUi = true)
@Composable
private fun ComfirmFeedbackPreview() {
    ConfirmFeedback()
}