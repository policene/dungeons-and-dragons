package racas

import Personagem

class Tiefling  : Raca {
    override fun bonusRaca(personagem: Personagem) {
        personagem.atributos.inteligencia += 1
        personagem.atributos.carisma += 2
    }

    override fun nomeRaca(): String {
        return "Tiefling"
    }

    override fun exibirBonus(): String {
        return "+1 INT, +2 CAR"
    }
}