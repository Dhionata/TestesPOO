package ex02

import javax.swing.JOptionPane

fun main() {
	val televisores = mutableListOf<Televisor>()
	do {
		val televisor = Televisor()
		do {
			val y = JOptionPane.showInputDialog("deseja ligar ou desligar?")
			when (y) {
				"desligar" -> {
					televisor.desligar()
				}
				"ligar" -> {
					televisor.ligar()
					println("Por favor adicione um canal")
					JOptionPane.showMessageDialog(
						null, "Por favor adicione " +
								"um canal"
					)
					televisor.criarCanal()
					do {
						println("\nDeseja criar e adicionar mais canais?\nSim - Não")
						var simNao = JOptionPane.showInputDialog(
							"Deseja criar e adicionar mais " +
									"canais?\nSim - Não"
						)
						when (simNao) {
							"Sim" -> {
								televisor.criarCanal()
							}
							"Não" -> {
								do {
									println("\nInforme o volume da televisão: ")
									val volume = JOptionPane.showInputDialog(
										"Informe o volume da" +
												"televisão"
									).toByte()
									if (volume in 0..80) {
										televisor.volume = volume
									} else {
										println("\nDigite um valor de 0 à 80")
										televisor.volume = -1
									}
								} while (televisor.volume.toInt() == -1)
								do {
									println("\nDeseja passar ou voltar o canal?\nSim - Não")
									simNao = JOptionPane.showInputDialog(
										"Deseja passar ou voltar" +
												" o canal?\nSim - Não"
									)
									when (simNao) {
										"Sim" -> {
											do {
												do {
													println("\nDeseja aumentar ou diminuir? ")
													var aumentarDiminuir = JOptionPane
														.showInputDialog(
															"Deseja aumentar ou " +
																	"diminuir?"
														)
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
												println(
													"\nDeseja aumentar ou diminuir " +
															"denovo?\nSim - Não"
												)
												val mais = JOptionPane.showInputDialog(
													"Deseja " +
															"aumentar ou diminuir denovo?\nSim - " +
															"Não"
												)
											} while (mais != "Não")
										}
										"Não" -> {
											do {
												println(
													"\nDeseja aumentar ou diminuir o " +
															"volume?\nSim - Não"
												)
												simNao = JOptionPane.showInputDialog(
													"Deseja " +
															"aumentar ou diminuir o volume?\nSim " +
															"- Não"
												)
												when (simNao) {
													"Sim" -> {
														do {
															println(
																"\nDeseja aumentar ou " +
																		"diminuir?"
															)
															val aumentarDiminuir = JOptionPane
																.showInputDialog(
																	"Deseja aumentar" +
																			" ou diminuir?"
																)
															val vezes = JOptionPane
																.showInputDialog(
																	"Número de vezes" +
																			" que deseja aumentar"
																).toInt()
															repeat(vezes) {
																when (aumentarDiminuir) {
																	"aumentar" -> {
																		televisor.volumeAcima()
																	}
																	"diminuir" -> {
																		televisor.volumeAbaixo()
																	}
																	else -> {
																		println(
																			"\nTenho que " +
																					"aprender " +
																					"outros " +
																					"idiomas..."
																		)
																	}
																}
															}
														} while (aumentarDiminuir != "Sim" &&
															aumentarDiminuir != "Não"
														)
													}
													"Não" -> {
														do {
															println(
																"\nDeseja remover algum " +
																		"canal?\nSim - Não"
															)
															simNao = JOptionPane.showInputDialog(
																"Deseja remover algum canal?\nSim" +
																		" - " +
																		"Não"
															)
															when (simNao) {
																"Sim" -> {
																	val canalAux = Canal()
																	println(
																		"\nInforme o nome do " +
																				"canal: "
																	)
																	canalAux.nome = JOptionPane
																		.showInputDialog(
																			"Informe" +
																					" o nome do " +
																					"canal: "
																		)
																	println(
																		"\nInforme o número " +
																				"do canal: "
																	)
																	canalAux.numero =
																		JOptionPane.showInputDialog(
																			"Informe" +
																					" o número do " +
																					"canal: "
																		).toByte()
																	televisor.removerCanal(canalAux)
																}
																"Não" -> {
																	println(
																		"\nVocê configurou " +
																				"tudo meu amigo! " +
																				"valeu..."
																	)
																	televisor.imprimir()
																}
																else -> {
																	println(
																		"\nEscolha " +
																				"corretamente " +
																				"dessa vez em..."
																	)
																}
															}
														} while (simNao != "Sim" && simNao != "Não")
													}
													else -> {
														println(
															"\nNovos idiomas não serão adicionado" +
																	" mano..."
														)
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
		televisores.add(televisor)
		println("deseja criar mais um televisor?\n1 - Sim\n0 - Não")
		val cod = JOptionPane.showInputDialog(
			"Deseja criar mais um televisor?\n1 - Sim\n0 - " +
					"Não"
		).toInt()
	} while (cod != 0)
}
