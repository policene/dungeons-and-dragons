package com.example.aplicacao_ofc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.aplicacao_ofc.distribuctions.FreeDistribuction

class CharacterCreation : ComponentActivity() {


    private var selectedButton: Button? = null
    private var isDPClicked = false
    private var isDAClicked = false
    private var isDLClicked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charactercreation)

        val return_button = findViewById<ImageButton>(R.id.return_button)

        val btn_dp = findViewById<Button>(R.id.btn_distribuicao_padrao)
        val btn_da = findViewById<Button>(R.id.btn_distribuicao_aleatoria)
        val btn_dl = findViewById<Button>(R.id.btn_distribuicao_livre)

        val continuar = findViewById<Button>(R.id.continuar)



        return_button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btn_dp.setOnClickListener {
            updateSelectedButton(btn_dp)
            isDPClicked = true
            isDAClicked = false
            isDLClicked = false
        }

        btn_da.setOnClickListener {
            updateSelectedButton(btn_da)
            isDPClicked = false
            isDAClicked = true
            isDLClicked = false
        }

        btn_dl.setOnClickListener {
            updateSelectedButton(btn_dl)
            isDPClicked = false
            isDAClicked = false
            isDLClicked = true
        }

        continuar.setOnClickListener {
            when {
                isDAClicked -> {
                    Toast.makeText(this, "W.I.P.", Toast.LENGTH_SHORT).show()
                }
                isDPClicked -> {
                    Toast.makeText(this, "W.I.P.", Toast.LENGTH_SHORT).show()
                }
                isDLClicked -> {
                    // Navegar para a página de distribuição livre
                    val intent = Intent(this, FreeDistribuction::class.java)
                    startActivity(intent)
                }
                else -> {
                    // Caso nenhum botão tenha sido selecionado, você pode exibir uma mensagem
                    Toast.makeText(this, "Por favor, selecione uma distribuição antes de continuar", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }


    // Método para alterar cor do botão selecionado.
    private fun updateSelectedButton(newSelectedButton: Button) {
        selectedButton?.let {
            it.setBackgroundResource(R.drawable.button_default) // Volta ao estado normal
        }

        newSelectedButton.setBackgroundResource(R.drawable.button_pressed) // Aplica a cor selecionada

        selectedButton = newSelectedButton
    }
}
