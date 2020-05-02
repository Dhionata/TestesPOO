package ex02

import javax.swing.JOptionPane

class Televisor(
	private var estado: Boolean = false,
	var volume: Byte = 20
) {

	private val canais = mutableListOf<Canal>()
	private var canal = Canal()

	fun imprimirTudo() {
		imprimir()
		canais()
	}

	private fun canais() {
		println("-- Canais instalados --\n[Nome | Número]")
		JOptionPane.showMessageDialog(null, "-- Canais instalados --\n[Nome | Número]")
		canais.forEach {
			println("${it.nome} | ${it.numero}")
			JOptionPane.showMessageDialog(null, "${it.nome} | ${it.numero}")
		}
	}

	fun imprimir() {
		if (estado) {
			println("\nTV Ligada")
			JOptionPane.showMessageDialog(null, "TV Ligada")
			canal.imprimirCanal()
			canais()
		} else {
			println("\nTV Desligada")
			JOptionPane.showMessageDialog(null, "TV Desligada")
		}
	}

	fun ligar() {
		estado = true
		println("\nLigando...")
		JOptionPane.showMessageDialog(null, "Ligando...")
	}

	fun desligar() {
		estado = false
		println("\nDesligando...")
		JOptionPane.showMessageDialog(null, "Desligando...")
	}

	private fun adicionarCanal(c: Canal) {
		if (canal.numero == (-1).toByte()) {
			canal = c
			println("Canal Definido!")
			JOptionPane.showMessageDialog(null, "Canal Definido!")
			canal.imprimirCanal()
		}
		canais.add(c)
	}

	fun criarCanal() {
		var canal1: Canal
		do {
			println("\nInforme o nome do canal: ")
			val nome1 = JOptionPane.showInputDialog("Informe o nome do canal: ")
			println("\nPor favor informe o número: ")
			val numero1 = JOptionPane.showInputDialog("Por favor, informe o número: ").toByte()
			canal1 = Canal(numero1, nome1)
			adicionarCanal(canal1)
			if (canal1.nome.isEmpty()) {
				println("\nPor favor preencha corretamente todos os campos!")
				JOptionPane.showMessageDialog(null, "Por favor preencha corretamente todos os campos!")
			}
		} while (canal1.nome.isEmpty())
		println("\nCanal adicionado:")
		JOptionPane.showMessageDialog(null, "Canal adicionado")
		canal1.imprimirCanal()
	}

	fun removerCanal(canal: Canal) {
		try {
			if (canal == this.canal) {
				this.canal = canais[0]
			}
			canais.remove(canal)
			println("\nCanal '${canal.nome}' removido com sucesso!")
			JOptionPane.showMessageDialog(null, "Canal '${canal.nome}' removido com sucesso!")
		} catch (ex: Throwable) {
			println("\nNão deu pra remover esse canal: $ex")
			JOptionPane.showMessageDialog(null, "Não deu pra remover esse canal: $ex")
		}
	}

	fun canalAcima() {
		when {
			canais.size > 1 -> {
				canal = if (canal != canais.last()) {
					canais[canais.indexOf(canal) + 1]
				} else {
					canais.first()
				}
				println("\n-- Canal Alterado+ --")
				canal.imprimirCanal()
			}
			canais.size == 1 -> {
				println("\nSó tem um canal instalado...")
			}
			else -> {
				println("\nLista de canais Vazia!")
			}
		}
	}

	fun canalAbaixo() {
		when {
			canais.size > 1 -> {
				canal = if (canal != canais.first()) {
					canais[canais.indexOf(canal) - 1]
				} else {
					canais.last()
				}
				println("\n-- Canal Alterado- --")
				canal.imprimirCanal()
			}
			canais.size == 1 -> {
				println("\nSó tem um canal instalado...")
			}
			else -> {
				println("\nLista de canais Vazia!")
			}
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