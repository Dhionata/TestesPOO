package ex02

import javax.swing.JOptionPane

class Canal(var numero: Byte = -1, var nome: String = "") {
	fun imprimirCanal() {
		println("-- Canal --\nNome:$nome | Número:$numero")
		JOptionPane.showMessageDialog(
			null, "-- Canal --\nNome:$nome |" +
					"Número:$numero"
		)
	}
}