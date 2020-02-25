package ex02


class Televisor(
    private var estado: Boolean = false,
    var volume: Byte = 0
) {

    private val canais = mutableListOf<Canal>()
    private var canal = Canal()

    private fun canais() {
        println("-- Canais instalados --\n[Nome | Número]")
        canais.forEach {
            println("${it.nome} | ${it.numero}")
        }
    }

    fun imprimir() {
        if (estado) {
            println("\nTV Ligada")
            canal.imprimirCanal()
            canais()
        } else {
            println("\nTV Desligada")
        }
    }

    fun ligar() {
        estado = true
        println("\nLigando...")
    }

    fun desligar() {
        estado = false
        println("\nDesligando...")
    }

    fun adicionarCanal(c: Canal) {
        if (canal.numero == (-1).toByte()) {
            canal = c
            println("Canal Definido!")
            canal.imprimirCanal()
        }
        canais.add(c)
    }

    fun criarCanal() {
        var canal1: Canal
        do {
            println("\nInforme o nome do canal: ")
            val nome1 = entrada.next()
            println("\nPor favor informe o número: ")
            val numero1 = entrada.nextByte()
            canal1 = Canal(numero1, nome1)
            adicionarCanal(canal1)
            if (canal1.nome.isEmpty()) {
                println("\nPor favor preencha corretamente todos os campos!")
            }
        } while (canal1.nome.isEmpty())
        println("\nCanal adicionado:")
        canal1.imprimirCanal()
        canais()
    }

    fun removerCanal(canal: Canal) {
        try {
            if (canal == this.canal) {
                this.canal = canais[0]
            }
            canais.remove(canal)
            println("\nCanal '${canal.nome}' removido com sucesso!")
        } catch (ex: Throwable) {
            println("\nNão deu pra remover esse canal: $ex")
        }
    }

    fun canalAcima() {
        if (canais.isNotEmpty()) {
            val it = canais.listIterator()
            while (it.hasNext()) {
                if (canal == it.next()) {
                    canal = it.next()
                    println("Canal Definido")
                    canal.imprimirCanal()
                    break
                }
            }
        } else {
            println("\nLista de canais vazia!")
        }
    }

    fun canalAbaixo() {
        if (canais.isNotEmpty()) {
            val it = canais.listIterator()
            while (it.hasPrevious()) {
                if (canal == it.previous()) {
                    canal = it.previous()
                    println("Canal Definido")
                    canal.imprimirCanal()
                    break
                }
            }
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