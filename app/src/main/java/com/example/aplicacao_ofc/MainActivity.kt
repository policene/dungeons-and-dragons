package com.example.aplicacao_ofc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aplicacao_ofc.ui.theme.Aplicacao_ofcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ddLogo = findViewById<TextView>(R.id.dd_logo)
        val playButton = findViewById<Button>(R.id.button_play)

        playButton.setOnClickListener{
            val intent = Intent(this, CharacterCreation::class.java)
            startActivity(intent)
        }

    }
}


