package ex02

class Canal(var numero: Byte = -1, var nome: String = "") {
    fun imprimirCanal() {
        println("-- Canal --\nNome:$nome | Número:$numero")
    }
}