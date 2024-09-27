fun main() {
    val nome: String = "Guilherme Silva de Carvalho "
    val texto: String? = null
    val numeroCalculado: Byte = 41
    val pib: Long = 10_900_000_000_000
    val populacao: Int = 212_600_000

    val pibPerCapita = pib / populacao
    println("O PIB per capita é: R$ $pibPerCapita")
}