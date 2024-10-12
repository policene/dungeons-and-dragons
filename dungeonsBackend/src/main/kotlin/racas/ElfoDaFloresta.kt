package racas

import Personagem

class ElfoDaFloresta : Raca {
    override fun bonusRaca(personagem: Personagem) {
        personagem.atributos.sabedoria += 1
    }

    override fun nomeRaca(): String {
        return "Elfo da Floresta"
    }

    override fun exibirBonus(): String {
        return "+1 SAB"
    }
}