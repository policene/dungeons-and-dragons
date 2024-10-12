package racas

import Personagem

class Elfo : Raca {

    override fun bonusRaca(personagem: Personagem) {
        personagem.atributos.destreza += 2
    }

    override fun nomeRaca(): String {
        return "Elfo"
    }

    override fun exibirBonus(): String {
        return "+2 DES"
    }
}