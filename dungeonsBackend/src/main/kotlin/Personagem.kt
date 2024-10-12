import racas.Raca
import java.io.Serializable

class Personagem (

    var nome: String? = null,
    var atributos: Atributos = Atributos(),
    var raca: Raca? = null
    ) : Serializable

    {
    fun aplicarBonusRaca(){
        raca?.bonusRaca(this)
    }
}