import kotlin.math.pow

fun main() {
	val tempoInicial1 = System.currentTimeMillis()
	val vetor = mutableListOf<Int>()
	for (i in 10000 downTo 0) {
		vetor.add(i)
	}
	vetor.forEach {
		println(it)
	}

	val tempoinicial = System.currentTimeMillis()
	radixSort(vetor)
	val tempofinal = System.currentTimeMillis()

	vetor.forEach {
		println(it)
	}
	println("Tempo total de ordenação: ${tempofinal - tempoinicial}ms\nTempo total de execução: ${tempofinal - tempoInicial1}ms")
}

fun radixSort(vector: MutableList<Int>) {
	for (digit in 0..2) {
		val power = 10.0.pow(digit + 1.toDouble()).toInt()
		val z = Array(vector.size) { IntArray(10) }
		val n = IntArray(10)
		for (i in vector.indices) {
			val num = vector[i]
			z[n[num % power / (power / 10)]][num % power / (power / 10)] = num
			n[num % power / (power / 10)]++
		}
		var c = 0
		for (i in 0..9) {
			for (j in vector.indices) {
				if (j < n[i]) {
					vector[c] = z[j][i]
					c++
				} else {
					break
				}
			}
		}
	}
}