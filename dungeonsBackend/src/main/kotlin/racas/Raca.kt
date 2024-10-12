package racas
import Personagem
import java.io.Serializable

interface Raca : Serializable {

    fun bonusRaca(personagem: Personagem)
    fun nomeRaca(): String
    fun exibirBonus(): String

}