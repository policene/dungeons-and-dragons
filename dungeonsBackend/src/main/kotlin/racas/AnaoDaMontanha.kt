package racas

import Personagem

class AnaoDaMontanha : Raca{
    override fun bonusRaca(personagem: Personagem) {
        personagem.atributos.forca += 2
    }

    override fun nomeRaca(): String {
        return "Anão da Montanha"
    }

    override fun exibirBonus(): String {
        return "+2 FOR"
    }
}