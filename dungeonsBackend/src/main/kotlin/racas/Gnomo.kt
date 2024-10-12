package racas

import Personagem

class Gnomo : Raca {
    override fun bonusRaca(personagem: Personagem) {
        personagem.atributos.inteligencia += 2
    }

    override fun nomeRaca(): String {
        return "Gnomo"
    }

    override fun exibirBonus(): String {
        return "+2 INT"
    }
}