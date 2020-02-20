package ex02

class Televisor(
    private var estado: Boolean = false,
    var volume: Byte = 0
) {

    private val canais = mutableListOf<Canal>()
    private var canal = Canal()

    private fun canais() {
        println("\n-- Canais instalados --\n[Nome | Número]")
        canais.forEach {
            println("${it.nome} | ${it.numero}")
        }
    }

    fun imprimir() {
        println(
            "\nEstado: ${if (estado) {
                "ligada \nCanal: $canal\nVolume: $volume\n${canais()}"
            } else {
                "desligada"
            }}"
        )
    }

    fun ligar() {
        estado = true
        println("\nLigando...")
    }

    fun desligar() {
        estado = false
        println("\nDesligando...")
    }

    fun adicionarCanal(t: Televisor) {
        var canal1: Canal
        do {
            println("\nInforme o nome do canal: ")
            val nome1 = entrada.next()
            println("\nPor favor informe o número: ")
            val numero1 = entrada.nextByte()
            canal1 = Canal(numero1, nome1)
            t.canais.add(canal1)
            if (canal1.nome.isEmpty()) {
                println("\nPor favor preencha corretamente todos os campos!")
            }
        } while (canal1.nome.isEmpty())

        println("\nCanal adicionado:\nNome: ${canal1.nome}\nNúmero: ${canal1.numero}")
        canais()
    }

    fun removerCanal(canal: Canal) {
        try {
            canais.remove(canal)
            println("\nCanal removido com sucesso!")
        } catch (ex: Throwable) {
            println("\nNão deu pra remover esse canal: $ex")
        }
    }

    fun canalAcima() {
        if (canais.isNotEmpty()) {
            val interada: Iterator<Canal> = canais.iterator()
            canal = if (interada.hasNext()) {
                interada.next()
            } else {
                canais[0]
            }
            println("\n--Canal--\nNome | Número\n${canal.nome} | ${canal.numero}")
        } else {
            println("\nLista de canais vazia!")
        }
    }

    fun canalAbaixo() {
        if (canais.isNotEmpty()) {
            val interada: ListIterator<Canal> = canais.listIterator()
            canal = if (interada.hasPrevious()) {
                interada.previous()
            } else {
                canais[0]
            }
            println("\n--Canal--\nNome | Número\n${canal.nome} | ${canal.numero}")
        } else {
            println("\nLista de canais vazia!")
        }
    }

    fun volumeAcima() {
        if (volume < 80) {
            volume++
        } else {
            println("\nVolume máximo atingido!")
        }
        println("\nVolume: $volume")
    }

    fun volumeAbaixo() {
        if (volume > 0) {
            volume--
        } else {
            println("\nTelevisor já está mudo!")
        }
        println("\nVolume: $volume")
    }
}