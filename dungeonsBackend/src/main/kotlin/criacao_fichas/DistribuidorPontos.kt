package criacao_fichas
import Atributos
import java.util.Scanner

class DistribuidorPontos (
    var pontosRestantes: Int = 27,
    val custoPontos: Map<Int, Int> = mapOf(
        0 to 8,
        1 to 9,
        2 to 10,
        3 to 11,
        4 to 12,
        5 to 13,
        7 to 14,
        9 to 15
    )
) {

    fun verifyNull (string: String) : Int {
        if (string.isNotEmpty()){
            return string.toInt()
        } else {
            return 0
        }
    }

    fun decreasePoints(pontos : Int) : Boolean{
        if (pontosRestantes >= pontos){
            pontosRestantes -= pontos
            return true
        } else {
            return false
        }
    }

    fun returnValue(pontos: Int) : Int? {
        return custoPontos[pontos]
    }

}