package com.example.aplicacao_ofc

import Personagem
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity


class CharacterSummary : ComponentActivity() {


    private var selectedButton: Button? = null
    private var isDPClicked = false
    private var isDAClicked = false
    private var isDLClicked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charactersummary)
        val personagem = intent.getSerializableExtra("personagem") as Personagem
        val outputNome = findViewById<TextView>(R.id.output_nome)
        val outputRaca = findViewById<TextView>(R.id.output_raca)
        val outputClasse = findViewById<TextView>(R.id.output_raca)

        val for_output = findViewById<TextView>(R.id.for_output)
        val des_output = findViewById<TextView>(R.id.des_output)
        val con_output = findViewById<TextView>(R.id.con_output)
        val int_output = findViewById<TextView>(R.id.int_output)
        val sab_output = findViewById<TextView>(R.id.sab_output)
        val car_output = findViewById<TextView>(R.id.car_output)

        val mod_out_for = findViewById<TextView>(R.id.mod_for_output)
        val mod_out_des = findViewById<TextView>(R.id.mod_des_output)
        val mod_out_con = findViewById<TextView>(R.id.mod_con_output)
        val mod_out_int = findViewById<TextView>(R.id.mod_int_output)
        val mod_out_sab = findViewById<TextView>(R.id.mod_sab_output)
        val mod_out_car = findViewById<TextView>(R.id.mod_car_output)
        val vida_output = findViewById<TextView>(R.id.vida_output)

        val return_button = findViewById<ImageButton>(R.id.return_button)
        val finalizar_button = findViewById<Button>(R.id.btn_finalizar)

        outputNome.text = personagem.nome
        outputRaca.text = personagem.raca?.nomeRaca()

        for_output.text = personagem.atributos.forca.toString()
        des_output.text = personagem.atributos.destreza.toString()
        con_output.text = personagem.atributos.constituicao.toString()
        int_output.text = personagem.atributos.inteligencia.toString()
        sab_output.text = personagem.atributos.sabedoria.toString()
        car_output.text = personagem.atributos.carisma.toString()
        vida_output.text = personagem.atributos.vida.toString()

        mod_out_for.text = personagem.atributos.modificador[personagem.atributos.forca].toString()
        mod_out_des.text = personagem.atributos.modificador[personagem.atributos.destreza].toString()
        mod_out_con.text = personagem.atributos.modificador[personagem.atributos.constituicao].toString()
        mod_out_int.text = personagem.atributos.modificador[personagem.atributos.inteligencia].toString()
        mod_out_sab.text = personagem.atributos.modificador[personagem.atributos.sabedoria].toString()
        mod_out_car.text = personagem.atributos.modificador[personagem.atributos.carisma].toString()


        return_button.setOnClickListener {
            // Retornar para a Activity anterior mantendo os dados registrados.
            val resultIntent = Intent()
            resultIntent.putExtra("key", "value")
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        finalizar_button.setOnClickListener {
            Toast.makeText(this, "W.I.P.", Toast.LENGTH_SHORT).show()
        }

    }
}
