package com.example.mecanicaapp.modules.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mecanicaapp.di.myViewModelFactory
import com.example.mecanicaapp.di.provideLocalRepo

@Composable
fun SearchScreen(
    onScan: () -> Unit,
    onSearch: (String) -> Unit
) {
    var code by remember { mutableStateOf("") }
    val isOnSearch: Boolean by remember { derivedStateOf { code.trim().isNotEmpty() } }
    val context = LocalContext.current

    val factory by lazy {
        myViewModelFactory { SearchViewModel(provideLocalRepo(context)) }
    }
    val viewModel: SearchViewModel = viewModel(
        factory = factory
    )
    LaunchedEffect(Unit) {
        viewModel.saveData()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp)
    ) {
        Text(
            "Frenos y Embragues",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center
        )
        Text(
            "Buscar producto",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center
        )
        TextField(
            code, {
                code = it
            },
            modifier = Modifier.fillMaxWidth(),
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
        )

        Spacer(modifier = Modifier.size(16.dp))

        Button(modifier = Modifier.fillMaxWidth(),
            enabled = isOnSearch,
            onClick = {
                onSearch.invoke(code)
            }) {
            Text("Buscar")
        }

        Spacer(modifier = Modifier.size(16.dp))

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            onScan.invoke()
        }) {
            Text("Escanear")
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
fun SearchScreenP() {
    SearchScreen({}, {})
}