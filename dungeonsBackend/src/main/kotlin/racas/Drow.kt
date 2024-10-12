package racas

import Personagem

class Drow : Raca {
    override fun bonusRaca(personagem: Personagem) {
        personagem.atributos.carisma += 1
    }

    override fun nomeRaca(): String {
        return "Drow"
    }

    override fun exibirBonus(): String {
        return "+1 CAR"
    }
}