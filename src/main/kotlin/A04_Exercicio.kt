// A04_Exercicio.kt
fun main() {
    // b. Variável mutável para armazenar o nome completo
    var nomeCompleto: String = "Seu Nome Completo"

    // c. Variável de texto sem valor
    var textoVazio: String = ""

    // d. Variável imutável com o menor tipo de dado capaz de armazenar o número do calçado
    val numeroCalçado: Byte = 42 // Substitua 42 pelo seu número

    // e. Variável para armazenar o PIB do Brasil em 2024
    val pibBrasil: Long = 10_900_000_000_000

    // f. Variável para armazenar a população do Brasil em 2024
    val populacaoBrasil: Int = 212_600_000

    // g. Imprime o PIB per capita
    val pibPerCapita: Double = pibBrasil.toDouble() / populacaoBrasil
    println("O PIB per capita do Brasil em 2024 é: R$ %.2f".format(pibPerCapita))
}
