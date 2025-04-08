package br.com.fiap.projetofiapesg.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CaixaDeEntrada(
    modifier: Modifier,
    label: String,
    placeholder: String,
    value: String,
    keyboardType: KeyboardType,
    atualizarValor: (String) -> Unit,
    isError: Boolean,
    icon: Icon?
) {
    OutlinedTextField(
        value = value,
        onValueChange =  atualizarValor ,
        modifier = modifier
            .fillMaxWidth(),
        label = {
            Text(text = label)
        },
        placeholder = {
            Text(text = placeholder)
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        isError = isError
        )
}