package com.example.mecanicaapp.modules.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mecanicaapp.data.model.AutoPartModel
import com.example.mecanicaapp.di.myViewModelFactory
import com.example.mecanicaapp.di.provideLocalRepo

@Composable
fun DetailProductScreen(code: String) {
    val context = LocalContext.current

    val factory by lazy {
        myViewModelFactory { DetailProductViewModel(provideLocalRepo(context)) }
    }
    val viewModel: DetailProductViewModel = viewModel(
        factory = factory
    )
    var autopart by remember { mutableStateOf<AutoPartModel?>(null) }
    LaunchedEffect(Unit) {
        autopart = viewModel.getAutoPart(code)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp)
    ) {
        Text(
            "Detalle de producto",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 20.sp)
        )
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                imageVector = Icons.Default.Close,
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.Center)
            )
        }

        repeat(4) {
            when(it) {
                0 -> ProductText("Código:", autopart?.code ?: "not found")
                1 -> ProductText("Descripción:", autopart?.description ?: "not found")
                2 -> ProductText("Precio compra", autopart?.priceBuy ?: "not found")
                3 -> ProductText("Precio venta", autopart?.priceSell ?: "not found")
            }
        }

    }
}

@Composable
fun ProductText(title: String, subTitle: String) {
    Text(
        title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        style = TextStyle(fontSize = 20.sp)
    )
    Text(
        subTitle,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        style = TextStyle(fontSize = 16.sp, color = Color.Gray)
    )
}

@Preview
@Composable
fun DetailProductP() {
    DetailProductScreen("AXZ")
}