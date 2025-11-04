/**
 * ============================================
 * AULA: CRIPTOGRAFIA COM CIFRA DE CÉSAR
 * ============================================
 * 
 * A Cifra de César é uma das técnicas de criptografia mais antigas e simples.
 * Foi usada por Júlio César para proteger mensagens militares.
 * 
 * CONCEITO:
 * ---------
 * A cifra funciona deslocando cada letra do alfabeto por um número fixo de posições.
 * 
 * Exemplo com deslocamento de 3:
 * A → D
 * B → E
 * C → F
 * ...
 * X → A
 * Y → B
 * Z → C
 * 
 * Mensagem original: "HELLO"
 * Mensagem cifrada:  "KHOOR"
 * 
 * CARACTERÍSTICAS:
 * ----------------
 * - Simétrica: usa a mesma chave para cifrar e decifrar
 * - Chave: número de posições a deslocar (0-25)
 * - Vulnerável: fácil de quebrar por força bruta (apenas 26 possibilidades)
 */

fun main() {
    println("═══════════════════════════════════════════")
    println("    CIFRA DE CÉSAR - AULA PRÁTICA")
    println("═══════════════════════════════════════════\n")
    
    // ============================================
    // EXEMPLO 1: Cifrando uma mensagem simples
    // ============================================
    println("📝 EXEMPLO 1: Cifrando uma mensagem")
    println("─────────────────────────────────────")
    val mensagem1 = "HELLO WORLD"
    val chave1 = 3
    val cifrada1 = cifrarCesar(mensagem1, chave1)
    
    println("Mensagem original: $mensagem1")
    println("Chave (deslocamento): $chave1")
    println("Mensagem cifrada: $cifrada1")
    println()
    
    // ============================================
    // EXEMPLO 2: Decifrando a mensagem
    // ============================================
    println("🔓 EXEMPLO 2: Decifrando a mensagem")
    println("─────────────────────────────────────")
    val decifrada1 = decifrarCesar(cifrada1, chave1)
    println("Mensagem cifrada: $cifrada1")
    println("Chave: $chave1")
    println("Mensagem decifrada: $decifrada1")
    println()
    
    // ============================================
    // EXEMPLO 3: Diferentes chaves
    // ============================================
    println("🔑 EXEMPLO 3: Testando diferentes chaves")
    println("─────────────────────────────────────")
    val mensagem2 = "KOTLIN"
    println("Mensagem: $mensagem2\n")
    
    for (chave in listOf(1, 5, 10, 13, 25)) {
        val cifrada = cifrarCesar(mensagem2, chave)
        println("Chave $chave: $cifrada")
    }
    println()
    
    // ============================================
    // EXEMPLO 4: Mensagem com letras minúsculas
    // ============================================
    println("🔤 EXEMPLO 4: Maiúsculas e minúsculas")
    println("─────────────────────────────────────")
    val mensagem3 = "Kotlin e Divertido"
    val chave3 = 7
    val cifrada3 = cifrarCesar(mensagem3, chave3)
    val decifrada3 = decifrarCesar(cifrada3, chave3)
    
    println("Original: $mensagem3")
    println("Cifrada: $cifrada3")
    println("Decifrada: $decifrada3")
    println()
    
    // ============================================
    // EXEMPLO 5: Ataque de força bruta
    // ============================================
    println("💪 EXEMPLO 5: Quebrando a cifra (Força Bruta)")
    println("─────────────────────────────────────")
    val mensagemSecreta = "WKLV LV D VHFUHW"
    println("Mensagem interceptada: $mensagemSecreta")
    println("\nTentando todas as chaves possíveis:\n")
    
    quebrarCifra(mensagemSecreta)
    println()
    
    // ============================================
    // EXEMPLO 6: Cifra ROT13 (caso especial)
    // ============================================
    println("🔄 EXEMPLO 6: ROT13 (Cifra de César com chave 13)")
    println("─────────────────────────────────────")
    println("ROT13 é especial: cifrar e decifrar usam a mesma operação!")
    val mensagem4 = "SEGREDO"
    val rot13_1 = cifrarCesar(mensagem4, 13)
    val rot13_2 = cifrarCesar(rot13_1, 13)
    
    println("Original: $mensagem4")
    println("ROT13 (1ª vez): $rot13_1")
    println("ROT13 (2ª vez): $rot13_2")
    println()
    
    // ============================================
    // DESAFIO PRÁTICO
    // ============================================
    println("🎯 DESAFIO: Decifre esta mensagem!")
    println("─────────────────────────────────────")
    val desafio = "SUREUDPDU H GLYHUWLGR"
    println("Mensagem: $desafio")
    println("Dica: A chave está entre 1 e 10")
    println("\nResposta abaixo:")
    println("...")
    Thread.sleep(1000)
    println("Chave 3: ${decifrarCesar(desafio, 3)}")
}

/**
 * Cifra uma mensagem usando a Cifra de César
 * 
 * @param texto Texto a ser cifrado
 * @param chave Número de posições a deslocar (0-25)
 * @return Texto cifrado
 */
fun cifrarCesar(texto: String, chave: Int): String {
    val resultado = StringBuilder()
    
    // Normaliza a chave para estar entre 0 e 25
    val chaveNormalizada = chave % 26
    
    for (char in texto) {
        when {
            // Letras maiúsculas (A-Z)
            char.isUpperCase() -> {
                val posicao = char - 'A'  // Posição no alfabeto (0-25)
                val novaPosicao = (posicao + chaveNormalizada) % 26
                val novoChar = 'A' + novaPosicao
                resultado.append(novoChar)
            }
            // Letras minúsculas (a-z)
            char.isLowerCase() -> {
                val posicao = char - 'a'
                val novaPosicao = (posicao + chaveNormalizada) % 26
                val novoChar = 'a' + novaPosicao
                resultado.append(novoChar)
            }
            // Outros caracteres (espaços, números, pontuação) não são alterados
            else -> resultado.append(char)
        }
    }
    
    return resultado.toString()
}

/**
 * Decifra uma mensagem cifrada com Cifra de César
 * 
 * @param texto Texto cifrado
 * @param chave Chave usada na cifragem
 * @return Texto original
 */
fun decifrarCesar(texto: String, chave: Int): String {
    // Para decifrar, basta usar a chave negativa
    return cifrarCesar(texto, -chave)
}

/**
 * Tenta quebrar a cifra testando todas as 26 chaves possíveis
 * 
 * @param textoCifrado Texto a ser decifrado
 */
fun quebrarCifra(textoCifrado: String) {
    for (chave in 0..25) {
        val tentativa = decifrarCesar(textoCifrado, chave)
        println("Chave $chave: $tentativa")
    }
}

/**
 * ============================================
 * EXPLICAÇÃO MATEMÁTICA
 * ============================================
 * 
 * CIFRAGEM:
 * C = (P + K) mod 26
 * 
 * Onde:
 * C = caractere cifrado
 * P = caractere original (posição no alfabeto)
 * K = chave (deslocamento)
 * mod 26 = resto da divisão por 26 (para voltar ao início do alfabeto)
 * 
 * DECIFRAGEM:
 * P = (C - K) mod 26
 * 
 * EXEMPLO PASSO A PASSO:
 * ----------------------
 * Cifrar "HELLO" com chave 3:
 * 
 * H → posição 7 → (7 + 3) mod 26 = 10 → K
 * E → posição 4 → (4 + 3) mod 26 = 7  → H
 * L → posição 11 → (11 + 3) mod 26 = 14 → O
 * L → posição 11 → (11 + 3) mod 26 = 14 → O
 * O → posição 14 → (14 + 3) mod 26 = 17 → R
 * 
 * Resultado: "KHOOR"
 * 
 * ============================================
 * VANTAGENS E DESVANTAGENS
 * ============================================
 * 
 * VANTAGENS:
 * ✓ Muito simples de implementar
 * ✓ Rápida de executar
 * ✓ Boa para fins educacionais
 * 
 * DESVANTAGENS:
 * ✗ Muito fácil de quebrar (apenas 26 possibilidades)
 * ✗ Vulnerável a análise de frequência
 * ✗ Não é segura para uso real
 * ✗ Mantém padrões do texto original
 * 
 * ============================================
 * VARIAÇÕES DA CIFRA DE CÉSAR
 * ============================================
 * 
 * 1. ROT13: Cifra de César com chave fixa 13
 *    - Propriedade especial: cifrar = decifrar
 * 
 * 2. Cifra de Atbash: Inverte o alfabeto
 *    - A↔Z, B↔Y, C↔X, etc.
 * 
 * 3. Cifra de Vigenère: Usa múltiplas chaves
 *    - Mais segura que César
 * 
 * 4. Cifra Afim: Usa multiplicação e adição
 *    - C = (aP + b) mod 26
 */
