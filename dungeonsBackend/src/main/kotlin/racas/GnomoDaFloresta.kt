package racas

import Personagem

class GnomoDaFloresta : Raca {
    override fun bonusRaca(personagem: Personagem) {
        personagem.atributos.destreza += 1
    }

    override fun nomeRaca(): String {
        return "Gnomo da Floresta"
    }

    override fun exibirBonus(): String {
        return "+1 DES"
    }
}