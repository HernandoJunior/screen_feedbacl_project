package br.com.fiap.projetofiapesg.screens.singuppages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.projetofiapesg.R
import br.com.fiap.projetofiapesg.components.CaixaDeEntrada
import br.com.fiap.projetofiapesg.components.VoltarButton
import androidx.compose.material3.IconButton as IconButton1

@Composable
fun SignUpPageApp(navController: NavController, signUpPageAppViewModel: SignUpPageAppViewModel) {

    val checkError by signUpPageAppViewModel.checkError.observeAsState(false)
    val password by signUpPageAppViewModel.password.observeAsState("")
    val cargo by signUpPageAppViewModel.cargo.observeAsState("")
    val cnpj by signUpPageAppViewModel.cnpj.observeAsState("")
    val email by signUpPageAppViewModel.email.observeAsState("")
    val razaoSocial by signUpPageAppViewModel.razaoSocial.observeAsState("")
    val confirmPassword by signUpPageAppViewModel.confirmPassword.observeAsState("")

    var checkPassword by remember { mutableStateOf(false) }
    var showPassword by remember { mutableStateOf(false) }
    var toggleConfirmPassword by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = colorResource(R.color.backgroundColor),
        bottomBar = {
            // Você pode colocar o FooterOptions aqui, ou só um texto como no seu código atual
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
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
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            VoltarButton(voltarPage = { navController.navigate("firstpage") })

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp),
            ) {
                item {

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        stringResource(R.string.titlesignup),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Campos de entrada
                    CaixaDeEntrada(
                        value = razaoSocial,
                        label = "Razão Social",
                        atualizarValor = { signUpPageAppViewModel.onRazaoSocial(it) },
                        placeholder = "",
                        keyboardType = KeyboardType.Text,
                        modifier = Modifier,
                        isError = checkError,
                        icon = null
                    )

                    CaixaDeEntrada(
                        value = cargo,
                        label = "Cargo",
                        atualizarValor = { signUpPageAppViewModel.onCargoChange(it) },
                        placeholder = "",
                        keyboardType = KeyboardType.Text,
                        modifier = Modifier,
                        isError = checkError,
                        icon = null
                    )

                    CaixaDeEntrada(
                        value = cnpj,
                        label = "CNPJ",
                        atualizarValor = { signUpPageAppViewModel.onCnpjChange(it) },
                        placeholder = "",
                        keyboardType = KeyboardType.Number,
                        modifier = Modifier,
                        isError = checkError,
                        icon = null
                    )

                    CaixaDeEntrada(
                        value = email,
                        label = stringResource(R.string.email),
                        atualizarValor = { signUpPageAppViewModel.onEmailChange(it) },
                        placeholder = "",
                        keyboardType = KeyboardType.Email,
                        modifier = Modifier,
                        isError = checkError,
                        icon = null
                    )

                    OutlinedTextField(
                        value = password,
                        label = { Text(stringResource(R.string.password)) },
                        onValueChange = { signUpPageAppViewModel.onPasswordChange(it) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        isError = checkPassword,
                        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = { showPassword = !showPassword }) {
                                Icon(
                                    imageVector = if (showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                    contentDescription = "Toggle password visibility"
                                )
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                    )

                    OutlinedTextField(
                        value = confirmPassword,
                        label = { Text(stringResource(R.string.confirm)) },
                        onValueChange = { signUpPageAppViewModel.confirmPassword(it) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        isError = checkPassword,
                        visualTransformation = if (toggleConfirmPassword) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = { toggleConfirmPassword = !toggleConfirmPassword }) {
                                Icon(
                                    imageVector = if (toggleConfirmPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                    contentDescription = "Toggle password visibility"
                                )
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)

                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            if (password != confirmPassword) checkPassword = true
                        },
                        colors = ButtonDefaults.buttonColors(colorResource(R.color.iconBottomColor)),
                        modifier = Modifier.align(Alignment.Center)
                    ) {
                        Text(
                            text = stringResource(R.string.confirm),
                            fontSize = 18.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(80.dp)) // Espaço pro footer
                }
            }
        }
    }
}

//@Preview (showSystemUi = true)
//@Composable
//private fun SignUpPageAppPreview() {
//    SingUpPageApp()
//}