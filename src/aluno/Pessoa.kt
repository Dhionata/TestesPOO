package aluno

class Pessoa(val nome: String = "", val idade: Int = -1, nota1: Float = 0F, nota2: Float = 0F) {
    private val media: Float = (nota1 + nota2) / 2
    var passou: Boolean = false

    init {
        if (media > 6) {
            passou = true
        }
    }
}