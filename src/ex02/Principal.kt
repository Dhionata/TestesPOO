package ex02

import java.util.Scanner

val entrada: Scanner = Scanner(System.`in`)
fun main() {

    val televisoes = mutableListOf<Televisor>()
    println("Quer criar quantos televisores? ")
    val x = entrada.nextInt()

    val televisor1 = Televisor(false, 10)
    televisor1.ligar()
    val canal1 = Canal(2, "Globo")
    val canal2 = Canal(13, "Cultura")
    val canal3 = Canal(9, "SBT")
    televisor1.adicionarCanal(canal1)
    televisor1.adicionarCanal(canal2)
    televisor1.adicionarCanal(canal3)

    televisor1.imprimir()
    televisor1.criarCanal()
    televisor1.canalAcima()
    televisor1.imprimir()
    televisor1.removerCanal(canal2)
    televisor1.imprimir()
    televisor1.canalAbaixo()
    televisor1.volumeAcima()
    televisor1.volumeAbaixo()
    televisor1.desligar()

    repeat(x) {
        val televisor = Televisor()
        do {
            println("\nDeseja ligar ou desligar?")
            val y = entrada.next()
            when (y) {
                "desligar" -> {
                    televisor.desligar()
                }
                "ligar" -> {
                    televisor.ligar()
                    println("Por favor adicione um canal")
                    televisor.criarCanal()
                    do {
                        println("\nDeseja criar e adicionar mais canais?\nSim - Não")
                        var simNao = entrada.next()
                        when (simNao) {
                            "Sim" -> {
                                televisor.criarCanal()
                            }
                            "Não" -> {
                                do {
                                    println("\nInforme o volume da televisão: ")
                                    val volume = entrada.nextByte()
                                    if (volume in 0..80) {
                                        televisor.volume = volume
                                    } else {
                                        println("\nDigite um valor de 0 à 80")
                                        televisor.volume = -1
                                    }
                                } while (televisor.volume.toInt() == -1)
                                do {
                                    println("\nDeseja passar ou voltar o canal?\nSim - Não")
                                    simNao = entrada.next()
                                    when (simNao) {
                                        "Sim" -> {
                                            do {
                                                do {
                                                    println("\nDeseja aumentar ou diminuir? ")
                                                    var aumentarDiminuir = entrada.next()
                                                    when (aumentarDiminuir) {
                                                        "aumentar" -> {
                                                            televisor.canalAcima()
                                                        }
                                                        "diminuir" -> {
                                                            televisor.canalAbaixo()
                                                        }
                                                        else -> {
                                                            println("tente novamente...")
                                                            aumentarDiminuir = null
                                                        }
                                                    }
                                                } while (aumentarDiminuir.isEmpty())
                                                println("\nDeseja aumentar ou diminuir denovo?\nSim - Não")
                                                val mais = entrada.next()
                                            } while (mais != "Não")
                                        }
                                        "Não" -> {
                                            do {
                                                println("\nDeseja aumentar ou diminuir o volume?\nSim - Não")
                                                simNao = entrada.next()
                                                when (simNao) {
                                                    "Sim" -> {
                                                        do {
                                                            println("\nDeseja aumentar ou diminuir?")
                                                            val aumentarDiminuir = entrada.next()
                                                            val vezes = entrada.nextInt()
                                                            repeat(vezes) {
                                                                when (aumentarDiminuir) {
                                                                    "aumentar" -> {
                                                                        televisor.volumeAcima()
                                                                    }
                                                                    "diminuir" -> {
                                                                        televisor.volumeAbaixo()
                                                                    }
                                                                    else -> {
                                                                        println("\nTenho que aprender outros idiomas...")
                                                                    }
                                                                }
                                                            }
                                                        } while (aumentarDiminuir != "Sim" && aumentarDiminuir != "Não")
                                                    }
                                                    "Não" -> {
                                                        do {
                                                            println("\nDeseja remover algum canal?\nSim - Não")
                                                            simNao = entrada.next()
                                                            when (simNao) {
                                                                "Sim" -> {
                                                                    val canalAux = Canal()
                                                                    println("\nInforme o nome do canal: ")
                                                                    canalAux.nome = entrada.next()
                                                                    println("\nInforme o número do canal: ")
                                                                    canalAux.numero = entrada.nextByte()
                                                                    televisor.removerCanal(canalAux)
                                                                }
                                                                "Não" -> {
                                                                    println("\nVocê configurou tudo meu amigo! valeu...")
                                                                    televisor.imprimir()
                                                                }
                                                                else -> {
                                                                    println("\nEscolha corretamente dessa vez em...")
                                                                }
                                                            }
                                                        } while (simNao != "Sim" && simNao != "Não")
                                                    }
                                                    else -> {
                                                        println("\nNovos idiomas não serão adicionados mano...")
                                                    }
                                                }
                                            } while (simNao != "Sim" && simNao != "Não")
                                        }
                                        else -> {
                                            println("\nNão entendo outras palavras...")
                                        }
                                    }
                                } while (simNao != "Sim" && simNao != "Não")
                            }
                            else -> {
                                println("\nInforme corretamente sua resposta!")
                            }
                        }
                    } while (simNao != "Não")
                }
                else -> {
                    println("\nVocê digitou errado...")
                }
            }
        } while (y != "ligada" && y != "desligada")
        televisoes.add(televisor)
    }
}
