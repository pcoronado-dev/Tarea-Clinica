package com.coronado.clinica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface {
                    ClinicaSaludApp()
                }
            }
        }
    }
}

@Composable
fun ClinicaSaludApp() {

    var medicoSeleccionado by remember { mutableStateOf<Medico?>(null) }

    if (medicoSeleccionado == null) {

        Inicio(
            onMedicoSeleccionado = { medico ->
                medicoSeleccionado = medico
            }
        )

    } else {

        PerfilMedicoScreen(
            medico = medicoSeleccionado!!,
            onAgendarCita = {
            }
        )
    }
}

@Composable
fun Inicio(onMedicoSeleccionado: (Medico) -> Unit) {

    val especialidades = listOf(
        "Cardiología",
        "Pediatría",
        "Dermatología",
        "Medicina general"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Clínica Salud+",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Especialidades",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 4.dp)
        ) {

            items(especialidades.size) { posicion ->

                Card {

                    Text(
                        text = especialidades[posicion],
                        modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 10.dp
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Médicos disponibles",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            items(medicos.size) { posicion ->

                MedicoCard(
                    medico = medicos[posicion],
                    onClick = {
                        onMedicoSeleccionado(medicos[posicion])
                    }
                )
            }
        }
    }
}
@Composable
fun MedicoCard(
    medico: Medico,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = medico.nombre,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = medico.especialidad
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "⭐ ${medico.calificacion}"
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onClick,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text("Ver perfil")
            }
        }
    }
}
@Composable
fun PerfilMedicoScreen(
    medico: Medico,
    onAgendarCita: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Perfil del médico",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = medico.nombre,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Especialidad: ${medico.especialidad}"
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Calificación: ⭐ ${medico.calificacion}"
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onAgendarCita,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Agendar cita")
        }
    }
}