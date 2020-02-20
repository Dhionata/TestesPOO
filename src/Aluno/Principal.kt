package Aluno

import java.util.Scanner

fun main() {
    val entrada = Scanner(System.`in`)
    println("Informe o número de alunos: ")
    val x = entrada.nextInt()
    val lista = arrayListOf<Pessoa>()
    repeat(x) {
        println("Informe o nome: ")
        val nome = entrada.next()
        println("Informe a idade: ")
        val idade = entrada.nextInt()
        println("Informe a nota 1: ")
        val nota1 = entrada.nextFloat()
        println("Informe a nota 2: ")
        val nota2 = entrada.nextFloat()
        val p = Pessoa(nome, idade, nota1, nota2)
        lista.add(p)
    }
    lista.forEach {
        println(
            "\n--Nome--\n${it.nome}\n--Idade--\n${it.idade}\n${if (it.passou) {
                "--Aprovado(a)--"
            } else {
                "--Reprovado(a)--"
            }
            }"
        )
    }
}