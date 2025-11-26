package com.senai.telas_tcc.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senai.telas_tcc.R // Para acessar suas imagens de corvo e logo
import com.senai.telas_tcc.ui.theme.SenaiRed // Seu vermelho SENAI

// --- TELA DE CONSULTA DE CURSOS ---
@OptIn(ExperimentalMaterial3Api::class) // Necessário para Scaffold
@Composable
fun ConsultarCursosScreen() {
    Scaffold(
        topBar = { TopHeaderConsulta() }, // Header personalizado para esta tela
        bottomBar = { BottomNavBarConsulta() } // Bottom Nav Bar personalizado
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White), // Fundo branco da tela
            horizontalAlignment = Alignment.CenterHorizontally // Centraliza o conteúdo horizontalmente
        ) {
            Spacer(modifier = Modifier.height(32.dp)) // Espaço do topo

            // Título "CONSULTAR CURSOS"
            Text(
                text = "CONSULTAR\n CURSOS", // Quebra de linha para "CURSOS"
                color = SenaiRed,
                fontSize = 36.sp,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center, // Centraliza o texto
                lineHeight = 45.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp)) // Espaço entre o título e a tabela

            // --- TABELA DE CURSOS ---
            // Card que envolve a tabela para dar o visual de borda e sombra
            // --- TABELA DE CURSOS ---
            // --- TABELA DE CURSOS ---
            // --- TABELA DE CURSOS ---
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(400.dp), // <--- FIXEI UMA ALTURA: A tabela terá esse tamanho fixo
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .border(1.dp, Color.Black)
                ) {
                    // --- 1. CABEÇALHO (VERMELHO) ---
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .background(SenaiRed),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Coluna ID (Cabeçalho)
                        Box(
                            modifier = Modifier.weight(0.25f).fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("ID", color = Color.White, fontWeight = FontWeight.Bold)
                        }
                        // Divisória
                        Box(modifier = Modifier.width(1.dp).fillMaxHeight().background(Color.Black))

                        // Coluna NOME (Cabeçalho)
                        Box(
                            modifier = Modifier.weight(0.75f).fillMaxHeight()
                                .padding(start = 16.dp), contentAlignment = Alignment.CenterStart
                        ) {
                            Text("NOME DO CURSO", color = Color.White, fontWeight = FontWeight.Bold)
                        }
                    }

                    // Linha preta abaixo do cabeçalho
                    Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.Black))

                    // --- 2. LISTA DE DADOS (Aqui substituímos o Box Cinza) ---
                    // LazyColumn permite rolar se tiver muitos itens
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f) // Ocupa o resto do espaço do cartão
                            .background(Color.White) // Fundo branco para os itens
                    ) {
                        // Vamos simular 10 cursos para você ver como fica
                        items(15) { index ->
                            val idReal = index + 1
                            val nomeCurso = "Curso Técnico ${index + 1}"

                            // O ITEM DA LINHA (Cópia da estrutura do cabeçalho)
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp) // Altura de cada linha
                                    .border(0.5.dp, Color.Black), // Borda fina entre linhas
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Coluna ID (Conteúdo)
                                Box(
                                    modifier = Modifier.weight(0.25f).fillMaxHeight(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = idReal.toString(),
                                        fontSize = 14.sp,
                                        color = Color.Black
                                    )
                                }

                                // Divisória Vertical
                                Box(
                                    modifier = Modifier.width(1.dp).fillMaxHeight()
                                        .background(Color.Black)
                                )

                                // Coluna NOME (Conteúdo)
                                Box(
                                    modifier = Modifier.weight(0.75f).fillMaxHeight()
                                        .padding(start = 16.dp),
                                    contentAlignment = Alignment.CenterStart
                                ) {
                                    Text(text = nomeCurso, fontSize = 14.sp, color = Color.Black)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

            // --- TOP HEADER DA TELA DE CONSULTA (Adaptei para o print) ---
            @Composable
            fun TopHeaderConsulta() {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Logo SENAI (texto)
                    Text(
                        text = "SENAI",
                        color = SenaiRed,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Black
                    )
                    // Linha divisória
                    Divider(
                        color = SenaiRed,
                        thickness = 2.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                }
            }

            // --- BOTTOM NAV BAR DA TELA DE CONSULTA (Simplificado com Home e Corvo) ---
            @Composable
            fun BottomNavBarConsulta() {
                NavigationBar(
                    containerColor = SenaiRed, // Fundo vermelho escuro como no print
                    modifier = Modifier.height(64.dp) // Altura da barra
                ) {
                    Spacer(modifier = Modifier.weight(1f)) // Empurra os ícones para o centro

                    // Ícone Home
                    NavigationBarItem(
                        icon = {
                            Icon(
                                Icons.Default.Home,
                                contentDescription = null,
                                tint = Color(0xFFC0C0C0), // Cinza claro para o ícone selecionado
                                modifier = Modifier.size(32.dp)
                            )
                        },
                        selected = true, // Marcar como selecionado para dar a cor diferente
                        onClick = { },
                        colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent) // Sem indicador embaixo
                    )

                    Spacer(modifier = Modifier.width(32.dp)) // Espaço entre os ícones

                    // Ícone Corvo
                    NavigationBarItem(
                        icon = {
                            Image(
                                painter = painterResource(id = R.drawable.corvo_xml), // <--- SEU ARQUIVO corvo.png
                                contentDescription = "Corvo",
                                modifier = Modifier.size(32.dp)
                            )
                        },
                        selected = false,
                        onClick = { },
                        colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent) // Sem indicador embaixo
                    )
                    Spacer(modifier = Modifier.weight(1f)) // Empurra os ícones para o centro
                }
            }

