package racas

import Personagem

class HalflingRobusto : Raca {
    override fun bonusRaca(personagem: Personagem) {
        personagem.atributos.constituicao += 1
    }

    override fun nomeRaca(): String {
        return "Halfling Robusto"
    }

    override fun exibirBonus(): String {
        return "+1 CON"
    }
}