package com.senai.telas_tcc.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senai.telas_tcc.R // Importe o R do seu projeto para acessar drawables
import com.senai.telas_tcc.ui.theme.SenaiRed

data class Module(
    val id: String,
    val title: String,
    val description: String,
    val imageResId: Int, // Referência para o drawable
    val type: ModuleType // Tipo para decidir o layout do card
)
enum class ModuleType { BACK_END, FRONT_END, PROJECT } // Tipos de módulo

@Composable
fun ModulesScreen() {
    // Lista de módulos para exibir
    val modules = listOf(
        Module(
            id = "back_end",
            title = "PROGRAMAÇÃO BACK-END",
            description = "Treine sua lógica e entenda algoritmos",
            imageResId = R.drawable.img_backend_java, // Imagem para o banner
            type = ModuleType.BACK_END
        ),
        Module(
            id = "front_end",
            title = "PROGRAMAÇÃO FRONT-END",
            description = "Entenda como a web ganha forma",
            imageResId = R.drawable.img_front2, // Imagem para o banner
            type = ModuleType.FRONT_END
        ),
        Module(
            id = "projeto_software",
            title = "PROJETO DE SOFTWARE",
            description = "Aprenda a organizar e planejar sistemas",
            imageResId = R.drawable.img_projetos_xml, // Imagem para o banner
            type = ModuleType.PROJECT
        )
    )

    Scaffold(
        topBar = { TopHeader() }, // Seu TopHeader atual
        bottomBar = { BottomNavBar() } // Seu BottomNavBar atual
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
                .padding(horizontal = 16.dp), // Padding lateral para os cards
            verticalArrangement = Arrangement.spacedBy(16.dp), // Espaçamento entre os cards
            contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp) // Padding no topo e base da lista
        ) {
            items(modules) { module ->
                ModuleCard(module = module) {
                    // TODO: AQUI VOCÊ NAVEGA PARA O MAPA DE NÍVEIS
                    // Exemplo: navController.navigate("mapa_de_niveis/${module.id}")
                    println("Clicou no módulo: ${module.title}")
                }
            }
        }
    }
}

// --- Componente para cada Card de Módulo ---
@Composable
fun ModuleCard(module: Module, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = Color.White), // Card branco
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // Sombra
    ) {
        Column {
            // Imagem de Topo (ajuste o recurso conforme o ModuleType)
            Image(
                painter = painterResource(id = module.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp), // Altura da imagem
                contentScale = ContentScale.Crop
            )

            // Conteúdo do Card (Texto + Seta)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(SenaiRed) // Barra vermelha inferior
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(module.title, color = Color.White, fontWeight = FontWeight.Black, fontSize = 20.sp)
                    Text(module.description, color = Color.White, fontSize = 20.sp)
                }
                Icon(
                    painterResource(android.R.drawable.ic_media_play), // Seta de play
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}