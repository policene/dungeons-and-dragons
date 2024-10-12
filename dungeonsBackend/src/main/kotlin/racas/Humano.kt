    package racas
    import Personagem

    class Humano : Raca {

        override fun bonusRaca(personagem: Personagem) {
            personagem.atributos.forca += 1
            personagem.atributos.destreza += 1
            personagem.atributos.constituicao += 1
            personagem.atributos.inteligencia += 1
            personagem.atributos.sabedoria += 1
            personagem.atributos.carisma += 1
        }

        override fun nomeRaca(): String {
            return "Humano"
        }

        override fun exibirBonus(): String {
            return "+1 FOR, +1 DES, +1 CON, +1 INT, +1 SAB, +1 CAR"
        }

    }