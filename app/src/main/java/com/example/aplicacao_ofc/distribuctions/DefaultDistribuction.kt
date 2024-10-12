package com.example.aplicacao_ofc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity

import Atributos
import Personagem
import android.graphics.Color
import criacao_fichas.DistribuidorPontos
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat

class DefaultDistribuction : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_defaultdistribuction)

    // Declarando o Personagem e a classe Atributos do Backend.
        var personagem = intent.getSerializableExtra("personagem") as Personagem
        var atributos_personagem = Atributos()

        // Definindo elementos do XML.

        val output_pontos_restantes = findViewById<TextView>(R.id.pontos_restantes)

        val output_for = findViewById<TextView>(R.id.output_for)
        val output_des = findViewById<TextView>(R.id.output_des)
        val output_con = findViewById<TextView>(R.id.output_con)
        val output_int = findViewById<TextView>(R.id.output_int)
        val output_sab = findViewById<TextView>(R.id.output_sab)
        val output_car = findViewById<TextView>(R.id.output_car)
        val output_hp = findViewById<TextView>(R.id.output_hp)


        val output_mod_for = findViewById<TextView>(R.id.mod_for)
        val output_mod_des = findViewById<TextView>(R.id.mod_des)
        val output_mod_con = findViewById<TextView>(R.id.mod_con)
        val output_mod_int = findViewById<TextView>(R.id.mod_int)
        val output_mod_sab = findViewById<TextView>(R.id.mod_sab)
        val output_mod_car = findViewById<TextView>(R.id.mod_car)

        // Botões do XML.

        val return_button = findViewById<ImageButton>(R.id.return_button)
        val continuar = findViewById<Button>(R.id.continuar)
        val redefinir = findViewById<Button>(R.id.redefinir)

        val for_submit = findViewById<Button>(R.id.for_submit)
        val des_submit = findViewById<Button>(R.id.des_submit)
        val con_submit = findViewById<Button>(R.id.con_submit)
        val int_submit = findViewById<Button>(R.id.int_submit)
        val sab_submit = findViewById<Button>(R.id.sab_submit)
        val car_submit = findViewById<Button>(R.id.car_submit)

        var for_input = findViewById<EditText>(R.id.for_input)
        var des_input = findViewById<EditText>(R.id.des_input)
        var con_input = findViewById<EditText>(R.id.con_input)
        var int_input = findViewById<EditText>(R.id.int_input)
        var sab_input = findViewById<EditText>(R.id.sab_input)
        var car_input = findViewById<EditText>(R.id.car_input)

        // Setando o output dos pontos restantes
        val distribuidor = DistribuidorPontos()
        output_pontos_restantes.text = distribuidor.pontosRestantes.toString()

        // Funções para atualizar modificador e vida na tela.
        fun atualizarUI() {
            output_for.text = atributos_personagem.forca.toString()
            output_des.text = atributos_personagem.destreza.toString()
            output_con.text = atributos_personagem.constituicao.toString()
            output_int.text = atributos_personagem.inteligencia.toString()
            output_sab.text = atributos_personagem.sabedoria.toString()
            output_car.text = atributos_personagem.carisma.toString()

            output_mod_for.text = atributos_personagem.modificador[atributos_personagem.forca].toString()
            output_mod_des.text = atributos_personagem.modificador[atributos_personagem.destreza].toString()
            output_mod_con.text = atributos_personagem.modificador[atributos_personagem.constituicao].toString()
            output_mod_int.text = atributos_personagem.modificador[atributos_personagem.inteligencia].toString()
            output_mod_sab.text = atributos_personagem.modificador[atributos_personagem.sabedoria].toString()
            output_mod_car.text = atributos_personagem.modificador[atributos_personagem.carisma].toString()

            atributos_personagem.calcularVida()
            output_hp.text = atributos_personagem.vida.toString()

            output_pontos_restantes.text = distribuidor.pontosRestantes.toString()
        }

        // Funções para exibir na tela.

        fun pontosInsuficientes() {
            Toast.makeText(this, "Pontos insuficientes.", Toast.LENGTH_SHORT).show()
        }

        fun valorInválido() {
            Toast.makeText(this, "Valor inválido, consulte a tabela.", Toast.LENGTH_SHORT).show()
        }

        // Função para modificar atributo.

        fun modificadorAtributo(atributo: Int, atualizarAtributo: (Int) -> Unit) : Boolean {
            if (atributo in distribuidor.custoPontos) {
                if (distribuidor.decreasePoints(atributo)) {
                    val valorAtualizado = distribuidor.returnValue(atributo)
                    atualizarAtributo(valorAtualizado!!)
                    atualizarUI()
                    return true
                // Atualiza a interface com os novos valores
                } else {
                    pontosInsuficientes() // Mostra mensagem de pontos insuficientes
                    return false
                }
            } else {
                valorInválido() // Mostra mensagem de valor inválido
                return false
            }
        }


        // Definindo listener dos botões.

        return_button.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("key", "value")
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        for_submit.setOnClickListener{
            val for_str = for_input.text.toString()
            val forca = distribuidor.verifyNull(for_str)
            if (modificadorAtributo(forca){ novoValor ->
                atributos_personagem.forca = novoValor
            }){
                for_submit.isEnabled = false
                for_submit.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }

        des_submit.setOnClickListener{
            val des_str = des_input.text.toString()
            val destreza = distribuidor.verifyNull(des_str)
            if (modificadorAtributo(destreza){ novoValor ->
                    atributos_personagem.destreza = novoValor
                }){
                des_submit.isEnabled = false
                des_submit.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }

        con_submit.setOnClickListener{
            val con_str = con_input.text.toString()
            val constituicao = distribuidor.verifyNull(con_str)
            if (modificadorAtributo(constituicao){ novoValor ->
                    atributos_personagem.constituicao = novoValor
                }){
                con_submit.isEnabled = false
                con_submit.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }

        int_submit.setOnClickListener{
            val int_str = int_input.text.toString()
            val inteligencia = distribuidor.verifyNull(int_str)
            if (modificadorAtributo(inteligencia){ novoValor ->
                    atributos_personagem.inteligencia = novoValor
                }){
                int_submit.isEnabled = false
                int_submit.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }

        sab_submit.setOnClickListener{
            val sab_str = sab_input.text.toString()
            val sabedoria = distribuidor.verifyNull(sab_str)
            if (modificadorAtributo(sabedoria){ novoValor ->
                    atributos_personagem.sabedoria = novoValor
                }){
                sab_submit.isEnabled = false
                sab_submit.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }

        car_submit.setOnClickListener{
            val car_str = car_input.text.toString()
            val carisma = distribuidor.verifyNull(car_str)
            if (modificadorAtributo(carisma){ novoValor ->
                    atributos_personagem.carisma = novoValor
                }){
                car_submit.isEnabled = false
                car_submit.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }

        redefinir.setOnClickListener {

            distribuidor.pontosRestantes = 27
            atributos_personagem.forca = 8
            atributos_personagem.destreza = 8
            atributos_personagem.constituicao = 8
            atributos_personagem.inteligencia = 8
            atributos_personagem.sabedoria = 8
            atributos_personagem.carisma = 8

            atualizarUI()

            for_submit.isEnabled = true
            for_submit.setTextColor(ContextCompat.getColor(this, R.color.red_dd))
            des_submit.isEnabled = true
            des_submit.setTextColor(ContextCompat.getColor(this, R.color.red_dd))
            con_submit.isEnabled = true
            con_submit.setTextColor(ContextCompat.getColor(this, R.color.red_dd))
            int_submit.isEnabled = true
            int_submit.setTextColor(ContextCompat.getColor(this, R.color.red_dd))
            sab_submit.isEnabled = true
            sab_submit.setTextColor(ContextCompat.getColor(this, R.color.red_dd))
            car_submit.isEnabled = true
            car_submit.setTextColor(ContextCompat.getColor(this, R.color.red_dd))
        }


        continuar.setOnClickListener {
            personagem.atributos = atributos_personagem
            personagem.aplicarBonusRaca()
            val intent = Intent(this, CharacterSummary::class.java)
           intent.putExtra("personagem", personagem)
            startActivity(intent)
        }



    }
}
