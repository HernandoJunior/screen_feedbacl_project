package br.com.fiap.projetofiapesg.screens

import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import br.com.fiap.projetofiapesg.R
import androidx.compose.runtime.Composable as Composable

@Composable
fun MinhaTelaResponsiva() {
    ConstraintLayout {
        val (titulo, imagem, botao) = createRefs()

        Text("Título", modifier = Modifier.constrainAs(titulo) {
            top.linkTo(parent.top, margin = 16.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

        Image(painter = painterResource(id = R.drawable.img), contentDescription = null,
            modifier = Modifier.constrainAs(imagem) {
                top.linkTo(titulo.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

        Button(onClick = { /* ação */ }, modifier = Modifier.constrainAs(botao) {
            top.linkTo(imagem.bottom, margin = 24.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            Text("Clique aqui")
        }
    }
}

@Preview (showSystemUi = true)
@Composable
private fun MinhaTelaResponsivaPreview() {
    MinhaTelaResponsiva()

}