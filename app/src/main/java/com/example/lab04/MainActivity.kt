package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PantallaLaboratorio()
            }
        }
    }
}

@Composable
fun PantallaLaboratorio() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        item { Caja("1. Text") { ComponenteText() } }
        item { Caja("2. Button") { ComponenteButton() } }
        item { Caja("3. OutlinedButton") { ComponenteOutlinedButton() } }
    }
}

@Composable
fun Caja(titulo: String, contenido: @Composable () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = titulo, style = MaterialTheme.typography.titleMedium)
            contenido()
        }
    }
}

@Composable
// Modificado por Marco
fun ComponenteText() {
    Text(
        text = "Hola, este es un Text",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF6650A4),
        letterSpacing = 1.5.sp,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFEADDFF),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(12.dp)
    )
}
@Composable
fun ComponenteButton() {
    Button(onClick = {}) {
        Text("Button")
    }
}
@Composable
fun ComponenteOutlinedButton() {
    OutlinedButton(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(2.dp, Color(0xFF6650A4)),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color(0xFF6650A4)
        )
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = null,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "OutlinedButton",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 1.sp
        )
    }
}