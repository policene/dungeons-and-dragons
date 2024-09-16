package com.example.aplicacao_ofc.distribuctions

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.aplicacao_ofc.CharacterCreation
import com.example.aplicacao_ofc.R

class FreeDistribuction : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pointdistribuction)

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


        val help_button = findViewById<ImageButton>(R.id.help_button)
        val info_hp = findViewById<TextView>(R.id.info_hp)

        val redefinir = findViewById<Button>(R.id.redefinir)

        // Declarando as variáveis iniciais dos atributos do usuário
        var forca : Int = 8
        var destreza : Int = 8
        var constituicao : Int = 8
        var inteligencia : Int = 8
        var sabedoria : Int = 8
        var carisma : Int = 8

        // Declarando os pontos para distribuição

        var pontos_restantes : Int = 20


        // Setando o output dos pontos restantes

        output_pontos_restantes.text = pontos_restantes.toString()

        // Método para retornar à pagina anterior.

        return_button.setOnClickListener {
            val intent = Intent(this, CharacterCreation::class.java)
            startActivity(intent)
        }

        // Métodos para incrementar

        for_up.setOnClickListener {
            if (pontos_restantes > 0) {
                forca += 1
                output_for.text = forca.toString()
                pontos_restantes -= 1
                output_pontos_restantes.text = pontos_restantes.toString()
                calcularModificador(forca, output_mod_for)
            }
        }



        des_up.setOnClickListener {
            if (pontos_restantes > 0){
                destreza += 1
                output_des.text = destreza.toString()
                pontos_restantes -= 1
                output_pontos_restantes.text = pontos_restantes.toString()
                calcularModificador(destreza, output_mod_des)
            }
        }

        con_up.setOnClickListener {
            if(pontos_restantes > 0){
                constituicao += 1
                output_con.text = constituicao.toString()
                pontos_restantes -= 1
                output_pontos_restantes.text = pontos_restantes.toString()
                calcularModificador(constituicao, output_mod_con)
                calcularVida(constituicao, output_mod_con, output_hp)
            }
        }

        int_up.setOnClickListener {
            if (pontos_restantes > 0){
                inteligencia += 1
                output_int.text = inteligencia.toString()
                pontos_restantes -= 1
                output_pontos_restantes.text = pontos_restantes.toString()
                calcularModificador(inteligencia, output_mod_int)
            }
        }

        sab_up.setOnClickListener {
            if (pontos_restantes > 0){
                sabedoria += 1
                output_sab.text = sabedoria.toString()
                pontos_restantes -= 1
                output_pontos_restantes.text = pontos_restantes.toString()
                calcularModificador(sabedoria, output_mod_sab)
            }
        }

        car_up.setOnClickListener {
            if (pontos_restantes > 0){
                carisma += 1
                output_car.text = carisma.toString()
                pontos_restantes -= 1
                output_pontos_restantes.text = pontos_restantes.toString()
                calcularModificador(carisma, output_mod_car)
            }
        }

        // Métodos para diminuir

        for_down.setOnClickListener {
            if (forca != 8 && pontos_restantes != 20){
                forca -= 1
                output_for.text = forca.toString()
                pontos_restantes += 1
                output_pontos_restantes.text = pontos_restantes.toString()
                calcularModificador(forca, output_mod_for)
            }
        }

        des_down.setOnClickListener {
            if (destreza != 8 && pontos_restantes != 20) {
                destreza -= 1
                output_des.text = destreza.toString()
                pontos_restantes += 1
                output_pontos_restantes.text = pontos_restantes.toString()
                calcularModificador(destreza, output_mod_des)
            }
        }

        con_down.setOnClickListener {
            if (constituicao != 8 && pontos_restantes != 20) {
                constituicao -= 1
                output_con.text = constituicao.toString()
                pontos_restantes += 1
                output_pontos_restantes.text = pontos_restantes.toString()
                calcularModificador(constituicao, output_mod_con)
                calcularVida(constituicao, output_mod_con, output_hp)
            }
        }

        int_down.setOnClickListener {
            if (inteligencia != 8 && pontos_restantes != 20) {
                inteligencia -= 1
                output_int.text = inteligencia.toString()
                pontos_restantes += 1
                output_pontos_restantes.text = pontos_restantes.toString()
                calcularModificador(inteligencia, output_mod_int)
            }
        }

        sab_down.setOnClickListener {
            if (sabedoria != 8 && pontos_restantes != 20) {
                sabedoria -= 1
                output_sab.text = sabedoria.toString()
                pontos_restantes += 1
                output_pontos_restantes.text = pontos_restantes.toString()
                calcularModificador(sabedoria, output_mod_sab)
            }
        }

        car_down.setOnClickListener {
            if (carisma != 8 && pontos_restantes != 20) {
                carisma -= 1
                output_car.text = carisma.toString()
                pontos_restantes += 1
                output_pontos_restantes.text = pontos_restantes.toString()
                calcularModificador(carisma, output_mod_car)
            }
        }

        redefinir.setOnClickListener {
            pontos_restantes = 20
            output_pontos_restantes.text = 20.toString()
            forca = 8
            output_for.text = 8.toString()
            destreza = 8
            output_des.text = 8.toString()
            constituicao = 8
            output_con.text = 8.toString()
            inteligencia = 8
            output_int.text = 8.toString()
            sabedoria = 8
            output_sab.text = 8.toString()
            carisma = 8
            output_car.text = 8.toString()

            output_hp.text = 9.toString()

            output_mod_for.text = (-1).toString()
            output_mod_des.text = (-1).toString()
            output_mod_con.text = (-1).toString()
            output_mod_int.text = (-1).toString()
            output_mod_sab.text = (-1).toString()
            output_mod_car.text = (-1).toString()

        }

        // Função para alterar a visibilidade do texto de ajuda.

        help_button.setOnClickListener {
            if(info_hp.visibility == View.INVISIBLE){
                info_hp.visibility = View.VISIBLE
            } else {
                info_hp.visibility = View.INVISIBLE
            }
        }

    }

    // Função para retornar o modificador do atributo

    fun calcularModificador(atributo: Int, output_mod : TextView){
        val retorno = when(atributo){
            in 6..7 -> "-2"
            in 8..9 -> "-1"
            in 10..11 -> "0"
            in 12..13 -> "+1"
            in 14..15-> "+2"
            in 16..17 -> "+3"
            in 18..19 -> "+4"
            in 20..21 -> "+5"
            in 22..23 -> "+6"
            in 24..25 -> "+7"
            in 26..27 -> "+8"
            in 28..29 -> "+9"
            30 -> "+10"
            else -> {"Inválido."}
        }
        output_mod.text = retorno
    }

    // Função para calcular o HP

    fun calcularVida(constituicao: Int, output_mod_con: TextView, output_hp: TextView){
        val modificador = when(constituicao){
            in 6..7 -> -2
            in 8..9 -> -1
            in 10..11 -> 0
            in 12..13 -> 1
            in 14..15-> 2
            in 16..17 -> 3
            in 18..19 -> 4
            in 20..21 -> 5
            in 22..23 -> 6
            in 24..25 -> 7
            in 26..27 -> 8
            in 28..29 -> 9
            30 -> 10
            else -> null

        }
        val vida = 10 + modificador!!
        output_hp.text = vida.toString()

    }







}