package com.coronado.clinica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.coronado.clinica.ui.theme.ClinicaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface {
                    Inicio()
                }
            }
        }
    }
}

@Composable
fun Inicio() {

    val medicos = listOf(

        Medico(
            id = 1,
            nombre = "Dr. Carlos Ramírez",
            especialidad = "Cardiología",
            calificacion = 4.8
        ),

        Medico(
            id = 2,
            nombre = "Dra. María López",
            especialidad = "Pediatría",
            calificacion = 4.9
        ),

        Medico(
            id = 3,
            nombre = "Dr. José Torres",
            especialidad = "Dermatología",
            calificacion = 4.7
        )
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Clínica Salud+",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Reserva tu cita médica"
        )
    }
}