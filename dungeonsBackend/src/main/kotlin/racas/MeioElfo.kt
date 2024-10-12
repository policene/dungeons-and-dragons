package racas

import Personagem

class MeioElfo : Raca {
    override fun bonusRaca(personagem: Personagem) {
        personagem.atributos.carisma += 2
    }

    override fun nomeRaca(): String {
        return "Meio-Elfo"
    }

    override fun exibirBonus(): String {
        return "+2 CAR"
    }
}