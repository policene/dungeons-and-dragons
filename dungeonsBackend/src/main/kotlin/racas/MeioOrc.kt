package racas

import Personagem

class MeioOrc : Raca {
    override fun bonusRaca(personagem: Personagem) {
        personagem.atributos.forca += 2
        personagem.atributos.constituicao += 1
    }

    override fun nomeRaca(): String {
        return "Meio-Orc"
    }

    override fun exibirBonus(): String {
        return "+2 FOR, +1 CON"
    }
}