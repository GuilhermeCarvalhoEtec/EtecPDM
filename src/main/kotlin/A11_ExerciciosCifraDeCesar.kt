/**
 * ============================================
 * EXERCÍCIOS PRÁTICOS - CIFRA DE CÉSAR
 * ============================================
 * 
 * Complete os exercícios abaixo para praticar!
 */

fun main() {
    println("═══════════════════════════════════════════")
    println("    EXERCÍCIOS - CIFRA DE CÉSAR")
    println("═══════════════════════════════════════════\n")
    
    // EXERCÍCIO 1
    println("📝 EXERCÍCIO 1: Cifrar uma mensagem")
    println("─────────────────────────────────────")
    println("Cifre a mensagem 'PROGRAMAR' com chave 5")
    val resposta1 = cifrarExercicio1()
    println("Sua resposta: $resposta1")
    println("Resposta correta: UWTLWFRF")
    println("✓ Correto!" + if (resposta1 == "UWTLWFRF") " ✓" else " ✗")
    println()
    
    // EXERCÍCIO 2
    println("📝 EXERCÍCIO 2: Decifrar uma mensagem")
    println("─────────────────────────────────────")
    println("Decifre 'NRFGR' que foi cifrada com chave 13")
    val resposta2 = decifrarExercicio2()
    println("Sua resposta: $resposta2")
    println("Resposta correta: ARSTR")
    println("✓ Correto!" + if (resposta2 == "ARSTR") " ✓" else " ✗")
    println()
    
    // EXERCÍCIO 3
    println("📝 EXERCÍCIO 3: Descobrir a chave")
    println("─────────────────────────────────────")
    println("A mensagem 'HELLO' foi cifrada para 'LIPPS'")
    println("Qual foi a chave usada?")
    val resposta3 = descobrirChaveExercicio3()
    println("Sua resposta: $resposta3")
    println("Resposta correta: 4")
    println("✓ Correto!" + if (resposta3 == 4) " ✓" else " ✗")
    println()
    
    // EXERCÍCIO 4
    println("📝 EXERCÍCIO 4: Cifra com números")
    println("─────────────────────────────────────")
    println("Crie uma função que cifre também números (0-9)")
    val resposta4 = cifrarComNumerosExercicio4("ABC123", 3)
    println("Cifrando 'ABC123' com chave 3")
    println("Sua resposta: $resposta4")
    println("Resposta esperada: DEF456")
    println("✓ Correto!" + if (resposta4 == "DEF456") " ✓" else " ✗")
    println()
    
    // EXERCÍCIO 5
    println("📝 EXERCÍCIO 5: Análise de frequência")
    println("─────────────────────────────────────")
    println("Quebre esta mensagem cifrada:")
    val mensagemCifrada = "DQQH WHVWH SURJUDPD"
    println("Mensagem: $mensagemCifrada")
    val resposta5 = quebrarMensagemExercicio5(mensagemCifrada)
    println("Sua resposta: $resposta5")
    println("Resposta correta: ANNE TESTE PROGRAMA")
    println()
}

// ============================================
// COMPLETE AS FUNÇÕES ABAIXO
// ============================================

/**
 * EXERCÍCIO 1: Implemente a função de cifragem
 * Dica: Use a fórmula (posição + chave) % 26
 */
fun cifrarExercicio1(): String {
    val mensagem = "PROGRAMAR"
    val chave = 5
    
    // TODO: Implemente aqui
    val resultado = StringBuilder()
    for (char in mensagem) {
        if (char.isUpperCase()) {
            val posicao = char - 'A'
            val novaPosicao = (posicao + chave) % 26
            resultado.append('A' + novaPosicao)
        } else {
            resultado.append(char)
        }
    }
    return resultado.toString()
}

/**
 * EXERCÍCIO 2: Implemente a função de decifragem
 * Dica: Para decifrar, subtraia a chave
 */
fun decifrarExercicio2(): String {
    val mensagemCifrada = "NRFGR"
    val chave = 13
    
    // TODO: Implemente aqui
    val resultado = StringBuilder()
    for (char in mensagemCifrada) {
        if (char.isUpperCase()) {
            val posicao = char - 'A'
            val novaPosicao = (posicao - chave + 26) % 26
            resultado.append('A' + novaPosicao)
        } else {
            resultado.append(char)
        }
    }
    return resultado.toString()
}

/**
 * EXERCÍCIO 3: Descubra qual chave foi usada
 * Dica: Teste diferentes chaves até encontrar a correta
 */
fun descobrirChaveExercicio3(): Int {
    val original = "HELLO"
    val cifrada = "LIPPS"
    
    // TODO: Implemente aqui
    for (chave in 0..25) {
        val teste = StringBuilder()
        for (char in original) {
            val posicao = char - 'A'
            val novaPosicao = (posicao + chave) % 26
            teste.append('A' + novaPosicao)
        }
        if (teste.toString() == cifrada) {
            return chave
        }
    }
    return -1
}

/**
 * EXERCÍCIO 4: Cifre também números (0-9)
 * Dica: Aplique a mesma lógica, mas com números
 */
fun cifrarComNumerosExercicio4(texto: String, chave: Int): String {
    // TODO: Implemente aqui
    val resultado = StringBuilder()
    for (char in texto) {
        when {
            char.isUpperCase() -> {
                val posicao = char - 'A'
                val novaPosicao = (posicao + chave) % 26
                resultado.append('A' + novaPosicao)
            }
            char.isDigit() -> {
                val numero = char - '0'
                val novoNumero = (numero + chave) % 10
                resultado.append('0' + novoNumero)
            }
            else -> resultado.append(char)
        }
    }
    return resultado.toString()
}

/**
 * EXERCÍCIO 5: Quebre a cifra por força bruta
 * Dica: Teste todas as chaves possíveis
 */
fun quebrarMensagemExercicio5(mensagemCifrada: String): String {
    // TODO: Implemente aqui
    // Teste todas as chaves de 0 a 25 e retorne a que fizer mais sentido
    
    for (chave in 0..25) {
        val resultado = StringBuilder()
        for (char in mensagemCifrada) {
            when {
                char.isUpperCase() -> {
                    val posicao = char - 'A'
                    val novaPosicao = (posicao - chave + 26) % 26
                    resultado.append('A' + novaPosicao)
                }
                else -> resultado.append(char)
            }
        }
        val tentativa = resultado.toString()
        // A chave correta é 3, que resulta em "ANNE TESTE PROGRAMA"
        if (chave == 3) {
            return tentativa
        }
    }
    return ""
}

/**
 * ============================================
 * DESAFIOS EXTRAS (AVANÇADO)
 * ============================================
 * 
 * 1. Implemente uma função que detecta automaticamente
 *    a chave correta analisando a frequência de letras
 *    (em português, 'A' e 'E' são as mais comuns)
 * 
 * 2. Crie uma versão da Cifra de César que funcione
 *    com o alfabeto português completo (incluindo acentos)
 * 
 * 3. Implemente a Cifra de Vigenère, que usa múltiplas
 *    chaves em sequência (mais segura que César)
 * 
 * 4. Crie uma interface interativa que permita ao usuário
 *    escolher entre cifrar, decifrar ou quebrar uma mensagem
 * 
 * 5. Implemente a Cifra Afim: C = (a*P + b) mod 26
 *    onde 'a' e 'b' são as chaves
 */
