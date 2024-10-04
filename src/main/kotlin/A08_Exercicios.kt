// 1. Função para converter anos em meses, dias, horas, minutos e segundos
fun converterAnos(anos: Int) {
    val meses = anos * 12
    val dias = anos * 365
    val horas = dias * 24
    val minutos = horas * 60
    val segundos = minutos * 60

    println("$anos anos equivalem a:")
    println("$meses meses")
    println("$dias dias")
    println("$horas horas")
    println("$minutos minutos")
    println("$segundos segundos")
}

// 2. Função para contar caracteres de uma string
fun contarCaracteres(texto: String): Int {
    return texto.length
}

// 3. Função para calcular o cubo de um número inteiro
fun calcularCubo(n: Int): Int {
    return n * n * n
}

// 4. Função para converter milhas em quilômetros
fun converterMilhasParaKm(milhas: Double): Double {
    return milhas * 1.6
}

// 5. Função para trocar letras "a" ou "A" por "x" e converter para maiúsculas
fun trocarAEImprimir(texto: String) {
    val resultado = texto.replace("a", "x", true).uppercase()
    println(resultado)
}

// 6. Transformar as funções 2, 3 e 4 em funções de uma única linha
fun contarCaracteresSingle(texto: String) = texto.length
fun calcularCuboSingle(n: Int) = n * n * n
fun converterMilhasParaKmSingle(milhas: Double) = milhas * 1.6

fun main() {
    // Testando as funções
    converterAnos(2)

    val texto = "Kotlin"
    println("Quantidade de caracteres: ${contarCaracteres(texto)}")

    val numero = 3
    println("Cubo de $numero: ${calcularCubo(numero)}")

    val milhas = 5.0
    println("$milhas milhas equivalem a ${converterMilhasParaKm(milhas)} km")

    val stringTroca = "Programação em Kotlin"
    println("String com troca: ")
    trocarAEImprimir(stringTroca)

    // Testando as funções de uma única linha
    println("Quantidade de caracteres (single line): ${contarCaracteresSingle(texto)}")
    println("Cubo de $numero (single line): ${calcularCuboSingle(numero)}")
    println("$milhas milhas para km (single line): ${converterMilhasParaKmSingle(milhas)} km")
}
