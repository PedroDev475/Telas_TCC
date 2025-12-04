package com.senai.telas_tcc.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senai.telas_tcc.ui.theme.SenaiRed

// Definindo um cinza escuro para o texto do corpo, igual ao da imagem
val DarkTextGray = Color(0xFF4A4A4A)

@Composable
fun WelcomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Fundo branco total
    ) {
        // 1. O CABEÇALHO SUPERIOR
        TopHeaderWelcome()

        // 2. O CONTEÚDO PRINCIPAL (Texto centralizado)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Ocupa o resto da tela
                .padding(horizontal = 32.dp), // Margens laterais largas
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center // Centraliza tudo verticalmente
        ) {
            // Título Vermelho com Sombra
            Text(
                text = "Revise sem pressão!",
                style = TextStyle(
                    color = SenaiRed,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.Center,
                    // AQUI ESTÁ O TRUQUE DA SOMBRA:
                    shadow = Shadow(
                        color = Color.Black.copy(alpha = 0.25f), // Sombra preta suave
                        offset = Offset(4f, 4f), // Deslocamento para baixo e direita
                        blurRadius = 8f // O quão borrada é a sombra
                    )
                )
            )

            Spacer(modifier = Modifier.height(24.dp)) // Espaço entre título e texto

            // Texto do Corpo
            Text(
                text = "Deixe a ansiedade de lado e revise de forma leve e divertida. São exercícios que transformam o estudo em algo simples e motivador.",
                color = DarkTextGray,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                lineHeight = 26.sp // Espaçamento entre linhas para facilitar leitura
            )
        }
    }
}

// --- COMPONENTE DO CABEÇALHO ---
@Composable
fun TopHeaderWelcome() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween, // Separa os itens nas pontas
            verticalAlignment = Alignment.CenterVertically
        ) {
            // --- LOGO SENAI (Substituto Temporário) ---
            // Quando tiver a imagem: Image(painter = painterResource(id = R.drawable.sua_logo_senai), ...)
            Text(
                text = "SENAI",
                color = SenaiRed,
                fontSize = 36.sp,
                fontWeight = FontWeight.Black
            )

            // --- BOTÃO ENTRAR ---
            Button(
                onClick = { /* Ação de entrar */ },
                colors = ButtonDefaults.buttonColors(containerColor = SenaiRed),
                shape = RoundedCornerShape(50), // Borda bem redonda (estilo pílula)
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp), // Sombra 3D no botão
                contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp) // Botão mais gordinho
            ) {
                Text(
                    text = "Entrar",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
        // Linha divisória vermelha fina
        HorizontalDivider(
            color = SenaiRed,
            thickness = 2.dp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}