package com.senai.telas_tcc.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senai.telas_tcc.R
import com.senai.telas_tcc.ui.theme.SenaiRed

// Definição de uma cor mais escura para a barra de baixo (baseado na foto)
val SenaiDarkerRed = Color(0xFF660000) // Tom vinho/marrom avermelhado

@Composable
fun CadastrarCursoScreen() {
    // Variável para guardar o texto que o usuário digita
    var nomeCurso by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopHeaderCadastro() },
        bottomBar = { BottomNavBarCadastro() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp)) // Espaço inicial

            // --- TÍTULO ---
            Text(
                text = "CADASTRAR\nCURSO",
                color = SenaiRed,
                fontSize = 32.sp,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center,
                lineHeight = 40.sp
            )

            Spacer(modifier = Modifier.height(60.dp)) // Espaço grande até o formulário

            // --- CAMPO DE TEXTO ---
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp), // Margem lateral para não colar na borda
                horizontalAlignment = Alignment.Start // Alinha o texto "Nome" à esquerda
            ) {
                // Rótulo "Nome" (Fora da caixa)
                Text(
                    text = "Nome",
                    color = SenaiRed,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Caixa de Digitação
                OutlinedTextField(
                    value = nomeCurso,
                    onValueChange = { nomeCurso = it },
                    placeholder = {
                        Text(
                            "ex: Desenvolvimento de Sistemas",
                            color = Color.Gray,
                            fontSize = 20.sp
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp), // Bordas arredondadas
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = SenaiRed, // Borda vermelha quando clica
                        unfocusedBorderColor = SenaiRed, // Borda vermelha normal
                        cursorColor = SenaiRed
                    ),
                    singleLine = true
                )
            }

            Spacer(modifier = Modifier.height(80.dp)) // Espaço até o botão

            // --- BOTÃO CADASTRAR ---
            Button(
                onClick = {
                    // Ação do botão (Ex: Salvar no banco)
                },
                modifier = Modifier
                    .width(200.dp) // Largura do botão
                    .height(60.dp), // Altura do botão
                colors = ButtonDefaults.buttonColors(containerColor = SenaiRed),
                shape = RoundedCornerShape(12.dp),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp)
            ) {
                Text(
                    text = "Cadastrar",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

// --- TOP HEADER IGUAL AO ANTERIOR ---
@Composable
fun TopHeaderCadastro() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "SENAI",
            color = SenaiRed,
            fontSize = 36.sp,
            fontWeight = FontWeight.Black
        )
        HorizontalDivider(
            color = SenaiRed,
            thickness = 2.dp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

// --- BOTTOM BAR COM FUNDO ESCURO (VINHO) ---
@Composable
fun BottomNavBarCadastro() {
    NavigationBar(
        containerColor = SenaiDarkerRed, // <--- Aqui usamos a cor escura da foto
        modifier = Modifier.height(64.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))

        // Ícone Home
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Home,
                    contentDescription = null,
                    tint = Color.Gray, // Ícone cinza/escuro
                    modifier = Modifier.size(32.dp)
                )
            },
            selected = false,
            onClick = { },
            colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent)
        )

        Spacer(modifier = Modifier.width(32.dp))

        // Ícone Corvo
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.corvo_xml), // Certifique-se de ter corvo.png
                    contentDescription = "Corvo",
                    modifier = Modifier.size(32.dp)
                )
            },
            selected = false,
            onClick = { },
            colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent)
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}