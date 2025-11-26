package com.senai.telas_tcc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.senai.telas_tcc.ui.theme.Telas_TCCTheme
import com.senai.telas_tcc.ui.theme.screens.ConsultarCursosScreen
import com.senai.telas_tcc.ui.theme.screens.ModulesScreen
import com.senai.telas_tcc.ui.theme.screens.SenaiGameScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Telas_TCCTheme {
                // Chama a tela que criamos
                ConsultarCursosScreen()
            }
        }
    }
}