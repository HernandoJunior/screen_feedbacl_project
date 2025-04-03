package br.com.fiap.projetofiapesg.screens.loginpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.projetofiapesg.R
import br.com.fiap.projetofiapesg.components.CaixaDeEntrada
import br.com.fiap.projetofiapesg.components.VoltarButton
import kotlin.math.log

@Composable
fun LoginPageApp(navController: NavController, loginPageViewModel: LoginPageViewModel) {

    val email by loginPageViewModel.email.observeAsState("")
    val password by loginPageViewModel.password.observeAsState("")

    var checkContent by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.backgroundColor))
    ) {
        VoltarButton (voltarPage = { navController.navigate("firstpage") })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 32.dp, start = 32.dp)
                .verticalScroll(rememberScrollState(), true),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(300.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(200.dp)
                        .padding(bottom = 16.dp),
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "Logo inicial"
                )

                Text(
                    "ESG Hub",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )

            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    stringResource(R.string.login),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                CaixaDeEntrada(
                    value = email,
                    label = stringResource(R.string.email),
                    atualizarValor = { loginPageViewModel.onEmailChange(it) },
                    placeholder = "",
                    keyboardType = KeyboardType.Email,
                    modifier = Modifier,
                    isError = checkContent,
                    icon = null
                )

                CaixaDeEntrada(
                    value = password,
                    label = stringResource(R.string.password),
                    atualizarValor = { loginPageViewModel.onPasswordChange(it) },
                    placeholder = "",
                    keyboardType = KeyboardType.NumberPassword,
                    modifier = Modifier,
                    isError = checkContent,
                    icon = null
                )
                Spacer(Modifier.padding(top = 14.dp ))

                Button(
                    onClick = {
                        if (email.isEmpty() || password.isEmpty()) checkContent = true
                        navController.navigate("dadosempresas")
                    },
                ) {
                    Text(
                        stringResource(R.string.enter)
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .align(Alignment.BottomEnd)
                .background(colorResource(R.color.iconBottomColor)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                stringResource(R.string.slogan),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                color = colorResource(R.color.backgroundColor)
            )
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//private fun LoginPageAppPreview() {
//    LoginPageApp()
//}