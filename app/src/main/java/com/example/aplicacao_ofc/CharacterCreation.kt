package com.example.aplicacao_ofc

import Personagem
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.aplicacao_ofc.distribuctions.FreeDistribuction
import racas.AltoElfo
import racas.Anao
import racas.AnaoDaColina
import racas.AnaoDaMontanha
import racas.Draconato
import racas.Drow
import racas.Elfo
import racas.ElfoDaFloresta
import racas.Gnomo
import racas.GnomoDaFloresta
import racas.GnomoDasRochas
import racas.Halfling
import racas.HalflingPesLeves
import racas.HalflingRobusto
import racas.Humano
import racas.MeioElfo
import racas.MeioOrc
import racas.Tiefling

class CharacterCreation : ComponentActivity() {


    private var selectedButton: Button? = null
    private var isDPClicked = false
    private var isDAClicked = false
    private var isDLClicked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charactercreation)


        // Instanciando o personagem e lista de raças
        val personagem = Personagem()

        val racas = listOf(
            AltoElfo(),
            Anao(),
            AnaoDaColina(),
            AnaoDaMontanha(),
            Draconato(),
            Drow(),
            Elfo(),
            ElfoDaFloresta(),
            Gnomo(),
            GnomoDaFloresta(),
            GnomoDasRochas(),
            Halfling(),
            HalflingPesLeves(),
            HalflingRobusto(),
            Humano(),
            MeioElfo(),
            MeioOrc(),
            Tiefling()
        )



        val nomeRacas = racas.map { it.nomeRaca() }



        // Arrumando o spinner para mostrar as raças

        val race_spinner = findViewById<Spinner>(R.id.race_spinner)



        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, nomeRacas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        race_spinner.adapter = adapter

        // Declarando os elementos do .xml

        val return_button = findViewById<ImageButton>(R.id.return_button)

        val btn_dp = findViewById<Button>(R.id.btn_distribuicao_padrao)
        val btn_da = findViewById<Button>(R.id.btn_distribuicao_aleatoria)
        val btn_dl = findViewById<Button>(R.id.btn_distribuicao_livre)

        val nome_input = findViewById<EditText>(R.id.nome_input)

        var buffs_racas = findViewById<TextView>(R.id.buffs_raca)

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

        race_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                personagem.raca = racas[position]
                buffs_racas.text = personagem.raca!!.exibirBonus()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                personagem.raca = racas[0]
            }
        }

        // Função para definir

        fun validateName(nome: String): Boolean {
            // Regrinha para limitar os caractéres e permitir uso de espaço consciente.
            val regex = Regex("^[a-zA-Z]+( [a-zA-Z]+)*$")
            return nome.length in 3..12 && regex.matches(nome)
        }

        fun verifyInfo() : Boolean {
            val nome_escolhido = nome_input.text.toString()
            if (validateName(nome_escolhido)){
                personagem.nome = nome_escolhido
                return true
            } else {
                Toast.makeText(this, "Nome inválido. Use apenas letras e entre 3 e 12 caracteres.", Toast.LENGTH_SHORT).show()
                return false
            }
        }



        continuar.setOnClickListener {
            when {
                isDAClicked -> {
                    if(verifyInfo()){
                        Toast.makeText(this, "${personagem.raca?.exibirBonus()}", Toast.LENGTH_SHORT).show()
                    }
                }
                isDPClicked -> {
                    if(verifyInfo()){
                        // Navegar para a página de distribuição livre
                        val intent = Intent(this, DefaultDistribuction::class.java)
                        intent.putExtra("personagem", personagem)
                        startActivity(intent)

                    }
                }
                isDLClicked -> {
                    if(verifyInfo()){
                        // Navegar para a página de distribuição livre
                        val intent = Intent(this, FreeDistribuction::class.java)
                        intent.putExtra("personagem", personagem)
                        startActivity(intent)
                    }
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
        selectedButton?.setBackgroundResource(R.drawable.button_default)

        newSelectedButton.setBackgroundResource(R.drawable.button_pressed) // Aplica a cor selecionada

        selectedButton = newSelectedButton
    }
}
