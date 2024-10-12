package racas

import Personagem

class Halfling : Raca {
    override fun bonusRaca(personagem: Personagem) {
        personagem.atributos.destreza += 2
    }

    override fun nomeRaca(): String {
        return "Halfling"
    }

    override fun exibirBonus(): String {
        return "+2 DES"
    }
}