package com.example.aplicacao_ofc.distribuctions

import Atributos
import Personagem
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.aplicacao_ofc.CharacterCreation
import com.example.aplicacao_ofc.CharacterSummary
import com.example.aplicacao_ofc.R

class FreeDistribuction : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_freedistribuction)



        val personagem = intent.getSerializableExtra("personagem") as Personagem
        // Declarando a variável Atributos do Backend.

        var atributos_personagem = Atributos()


        // Declarando os elementos do .xml
        val return_button = findViewById<ImageButton>(R.id.return_button)

        val for_up = findViewById<Button>(R.id.for_up)
        val for_down = findViewById<Button>(R.id.for_down)
        val des_up = findViewById<Button>(R.id.des_up)
        val des_down = findViewById<Button>(R.id.des_down)

        val con_up = findViewById<Button>(R.id.con_up)
        val con_down = findViewById<Button>(R.id.con_down)

        val int_up = findViewById<Button>(R.id.int_up)
        val int_down = findViewById<Button>(R.id.int_down)

        val sab_up = findViewById<Button>(R.id.sab_up)
        val sab_down = findViewById<Button>(R.id.sab_down)

        val car_up = findViewById<Button>(R.id.car_up)
        val car_down = findViewById<Button>(R.id.car_down)

        val output_for = findViewById<TextView>(R.id.output_for)
        val output_des = findViewById<TextView>(R.id.output_des)
        val output_con = findViewById<TextView>(R.id.output_con)
        val output_int = findViewById<TextView>(R.id.output_int)
        val output_sab = findViewById<TextView>(R.id.output_sab)
        val output_car = findViewById<TextView>(R.id.output_car)
        val output_hp = findViewById<TextView>(R.id.output_hp)

        val output_pontos_restantes = findViewById<TextView>(R.id.pontos_restantes)

        val output_mod_for = findViewById<TextView>(R.id.mod_for)
        val output_mod_des = findViewById<TextView>(R.id.mod_des)
        val output_mod_con = findViewById<TextView>(R.id.mod_con)
        val output_mod_int = findViewById<TextView>(R.id.mod_int)
        val output_mod_sab = findViewById<TextView>(R.id.mod_sab)
        val output_mod_car = findViewById<TextView>(R.id.mod_car)

        val continuar = findViewById<Button>(R.id.continuar)


        val redefinir = findViewById<Button>(R.id.redefinir)


        // Declarando os pontos para distribuição
        var pontos_restantes : Int = 16
        output_pontos_restantes.text = pontos_restantes.toString()

        // Funções para calcular modificador e vida
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
        }

        // Aumentar e diminuir força
        for_up.setOnClickListener {
            if (pontos_restantes > 0) {
                atributos_personagem.forca += 1
                pontos_restantes -= 1
                output_pontos_restantes.text = pontos_restantes.toString()
                atualizarUI()
            }
        }

        for_down.setOnClickListener {
            if (atributos_personagem.forca > 8) {
                atributos_personagem.forca -= 1
                pontos_restantes += 1
                output_pontos_restantes.text = pontos_restantes.toString()
                atualizarUI()
            }
        }

        // Aumentar e diminuir destreza
        des_up.setOnClickListener {
            if (pontos_restantes > 0) {
                atributos_personagem.destreza += 1
                pontos_restantes -= 1
                output_pontos_restantes.text = pontos_restantes.toString()
                atualizarUI()
            }
        }

        des_down.setOnClickListener {
            if (atributos_personagem.destreza > 8) {
                atributos_personagem.destreza -= 1
                pontos_restantes += 1
                output_pontos_restantes.text = pontos_restantes.toString()
                atualizarUI()
            }
        }

        // Aumentar e diminuir constituição
        con_up.setOnClickListener {
            if (pontos_restantes > 0) {
                atributos_personagem.constituicao += 1
                pontos_restantes -= 1
                output_pontos_restantes.text = pontos_restantes.toString()
                atualizarUI()
            }
        }

        con_down.setOnClickListener {
            if (atributos_personagem.constituicao > 8) {
                atributos_personagem.constituicao -= 1
                pontos_restantes += 1
                output_pontos_restantes.text = pontos_restantes.toString()
                atualizarUI()
            }
        }

        // Aumentar e diminuir inteligência
        int_up.setOnClickListener {
            if (pontos_restantes > 0) {
                atributos_personagem.inteligencia += 1
                pontos_restantes -= 1
                output_pontos_restantes.text = pontos_restantes.toString()
                atualizarUI()
            }
        }

        int_down.setOnClickListener {
            if (atributos_personagem.inteligencia > 8) {
                atributos_personagem.inteligencia -= 1
                pontos_restantes += 1
                output_pontos_restantes.text = pontos_restantes.toString()
                atualizarUI()
            }
        }

        // Aumentar e diminuir sabedoria
        sab_up.setOnClickListener {
            if (pontos_restantes > 0) {
                atributos_personagem.sabedoria += 1
                pontos_restantes -= 1
                output_pontos_restantes.text = pontos_restantes.toString()
                atualizarUI()
            }
        }

        sab_down.setOnClickListener {
            if (atributos_personagem.sabedoria > 8) {
                atributos_personagem.sabedoria -= 1
                pontos_restantes += 1
                output_pontos_restantes.text = pontos_restantes.toString()
                atualizarUI()
            }
        }

        // Aumentar e diminuir carisma
        car_up.setOnClickListener {
            if (pontos_restantes > 0) {
                atributos_personagem.carisma += 1
                pontos_restantes -= 1
                output_pontos_restantes.text = pontos_restantes.toString()
                atualizarUI()
            }
        }

        car_down.setOnClickListener {
            if (atributos_personagem.carisma > 8) {
                atributos_personagem.carisma -= 1
                pontos_restantes += 1
                output_pontos_restantes.text = pontos_restantes.toString()
                atualizarUI()
            }
        }


        // Redefinir atributos
        redefinir.setOnClickListener {
            pontos_restantes = 16
            output_pontos_restantes.text = pontos_restantes.toString()
            atributos_personagem.forca = 8
            atributos_personagem.destreza = 8
            atributos_personagem.constituicao = 8
            atributos_personagem.inteligencia = 8
            atributos_personagem.sabedoria = 8
            atributos_personagem.carisma = 8
            atualizarUI()
        }

        // Método para retornar à página anterior
        return_button.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("key", "value")
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        // Método para prosseguir para a página seguinte e atribuir os atributos ao personagem.
        continuar.setOnClickListener{
            personagem.atributos = atributos_personagem
            personagem.aplicarBonusRaca()
            val intent = Intent(this, CharacterSummary::class.java)
            intent.putExtra("personagem", personagem)
            startActivity(intent)
        }

    }
}