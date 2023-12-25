package com.example.projectakhir.ui.halaman

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    onConfirmButtonClicked: (String, String, String) -> Unit,
    onCancelButtonClicked: () -> Unit
){
    var namaPihak by remember { mutableStateOf("") }
    var kegiatan by remember { mutableStateOf("") }
    var noTelepon by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ){
        OutlinedTextField(
            value = namaPihak,
            onValueChange = { namaPihak = it },
            label = { Text(text = "Nama Yang Mengajukan") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
        )
        OutlinedTextField(
            value = kegiatan,
            onValueChange = { kegiatan = it },
            label = { Text(text = "Nama Kegiatan Yang akan Berlangsung") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
        )
        OutlinedTextField(
            value = noTelepon,
            onValueChange = { noTelepon = it },
            label = { Text(text = "Nomor Handphone") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Companion.Phone
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            OutlinedButton(onClick = onCancelButtonClicked) {
                Text(text = "Cancel")
            }
            Button(
                onClick = {
                    if (namaPihak.isNotEmpty() &&
                        kegiatan.isNotEmpty() &&
                        noTelepon.isNotEmpty()){
                        onConfirmButtonClicked(namaPihak, kegiatan, noTelepon)
                    }
                })
            {
                Text(text = "Next")
            }
        }
    }
}