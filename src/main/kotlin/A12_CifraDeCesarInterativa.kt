/**
 * ============================================
 * CIFRA DE CÉSAR - VERSÃO INTERATIVA
 * ============================================
 * 
 * Programa interativo para cifrar, decifrar e quebrar
 * mensagens usando a Cifra de César
 */

fun main() {
    println("═══════════════════════════════════════════")
    println("    CIFRA DE CÉSAR - MODO INTERATIVO")
    println("═══════════════════════════════════════════\n")
    
    while (true) {
        exibirMenu()
        print("\nEscolha uma opção: ")
        
        val opcao = readlnOrNull()?.toIntOrNull() ?: 0
        println()
        
        when (opcao) {
            1 -> cifrarMensagem()
            2 -> decifrarMensagem()
            3 -> quebrarCifra()
            4 -> demonstracaoCompleta()
            5 -> {
                println("👋 Até logo!")
                break
            }
            else -> println("❌ Opção inválida! Tente novamente.\n")
        }
    }
}

fun exibirMenu() {
    println("\n┌─────────────────────────────────────────┐")
    println("│              MENU PRINCIPAL             │")
    println("├─────────────────────────────────────────┤")
    println("│ 1. 🔒 Cifrar uma mensagem               │")
    println("│ 2. 🔓 Decifrar uma mensagem             │")
    println("│ 3. 💪 Quebrar cifra (força bruta)       │")
    println("│ 4. 📚 Demonstração completa             │")
    println("│ 5. 🚪 Sair                              │")
    println("└─────────────────────────────────────────┘")
}

fun cifrarMensagem() {
    println("🔒 CIFRAR MENSAGEM")
    println("─────────────────────────────────────")
    
    print("Digite a mensagem: ")
    val mensagem = readlnOrNull() ?: ""
    
    print("Digite a chave (0-25): ")
    val chave = readlnOrNull()?.toIntOrNull() ?: 0
    
    if (chave !in 0..25) {
        println("❌ Chave inválida! Use um número entre 0 e 25.")
        return
    }
    
    val cifrada = cifrar(mensagem, chave)
    
    println("\n✅ RESULTADO:")
    println("Mensagem original: $mensagem")
    println("Chave: $chave")
    println("Mensagem cifrada: $cifrada")
    
    // Mostra o processo passo a passo para as primeiras letras
    println("\n📖 Processo (primeiras letras):")
    var contador = 0
    for (char in mensagem) {
        if (char.isLetter() && contador < 5) {
            val posOriginal = if (char.isUpperCase()) char - 'A' else char - 'a'
            val posNova = (posOriginal + chave) % 26
            val charNovo = if (char.isUpperCase()) 'A' + posNova else 'a' + posNova
            println("  $char (pos $posOriginal) + $chave = $charNovo (pos $posNova)")
            contador++
        }
    }
}

fun decifrarMensagem() {
    println("🔓 DECIFRAR MENSAGEM")
    println("─────────────────────────────────────")
    
    print("Digite a mensagem cifrada: ")
    val mensagem = readlnOrNull() ?: ""
    
    print("Digite a chave usada na cifragem (0-25): ")
    val chave = readlnOrNull()?.toIntOrNull() ?: 0
    
    if (chave !in 0..25) {
        println("❌ Chave inválida! Use um número entre 0 e 25.")
        return
    }
    
    val decifrada = decifrar(mensagem, chave)
    
    println("\n✅ RESULTADO:")
    println("Mensagem cifrada: $mensagem")
    println("Chave: $chave")
    println("Mensagem decifrada: $decifrada")
}

fun quebrarCifra() {
    println("💪 QUEBRAR CIFRA (FORÇA BRUTA)")
    println("─────────────────────────────────────")
    println("Este método testa todas as 26 chaves possíveis.")
    println()
    
    print("Digite a mensagem cifrada: ")
    val mensagem = readlnOrNull() ?: ""
    
    println("\n🔍 Testando todas as chaves:\n")
    println("┌──────┬────────────────────────────────────────┐")
    println("│ Chave│ Resultado                              │")
    println("├──────┼────────────────────────────────────────┤")
    
    for (chave in 0..25) {
        val tentativa = decifrar(mensagem, chave)
        val preview = if (tentativa.length > 38) tentativa.take(35) + "..." else tentativa
        println("│ %2d   │ %-38s │".format(chave, preview))
    }
    
    println("└──────┴────────────────────────────────────────┘")
    println("\n💡 Dica: Procure por palavras que façam sentido!")
}

fun demonstracaoCompleta() {
    println("📚 DEMONSTRAÇÃO COMPLETA")
    println("─────────────────────────────────────")
    println()
    
    // Exemplo 1: Mensagem simples
    println("1️⃣ Exemplo básico:")
    val msg1 = "HELLO"
    val chave1 = 3
    val cifrada1 = cifrar(msg1, chave1)
    println("   Original: $msg1")
    println("   Chave: $chave1")
    println("   Cifrada: $cifrada1")
    println("   Decifrada: ${decifrar(cifrada1, chave1)}")
    println()
    
    // Exemplo 2: ROT13
    println("2️⃣ ROT13 (chave 13 - propriedade especial):")
    val msg2 = "KOTLIN"
    val rot13_1 = cifrar(msg2, 13)
    val rot13_2 = cifrar(rot13_1, 13)
    println("   Original: $msg2")
    println("   ROT13 (1x): $rot13_1")
    println("   ROT13 (2x): $rot13_2 ← Volta ao original!")
    println()
    
    // Exemplo 3: Diferentes chaves
    println("3️⃣ Mesma mensagem, diferentes chaves:")
    val msg3 = "CESAR"
    println("   Original: $msg3")
    for (k in listOf(1, 5, 10, 15, 20, 25)) {
        println("   Chave %2d: %s".format(k, cifrar(msg3, k)))
    }
    println()
    
    // Exemplo 4: Segurança
    println("4️⃣ Por que a Cifra de César NÃO é segura:")
    println("   ✗ Apenas 26 chaves possíveis")
    println("   ✗ Fácil de quebrar por força bruta")
    println("   ✗ Vulnerável a análise de frequência")
    println("   ✗ Mantém padrões do texto original")
    println()
    
    // Exemplo 5: Uso moderno
    println("5️⃣ Uso moderno:")
    println("   ✓ Fins educacionais")
    println("   ✓ ROT13 para ocultar spoilers")
    println("   ✓ Puzzles e jogos")
    println("   ✗ NÃO use para dados sensíveis!")
}

// ============================================
// FUNÇÕES AUXILIARES
// ============================================

fun cifrar(texto: String, chave: Int): String {
    val resultado = StringBuilder()
    val chaveNormalizada = chave % 26
    
    for (char in texto) {
        when {
            char.isUpperCase() -> {
                val posicao = char - 'A'
                val novaPosicao = (posicao + chaveNormalizada) % 26
                resultado.append('A' + novaPosicao)
            }
            char.isLowerCase() -> {
                val posicao = char - 'a'
                val novaPosicao = (posicao + chaveNormalizada) % 26
                resultado.append('a' + novaPosicao)
            }
            else -> resultado.append(char)
        }
    }
    
    return resultado.toString()
}

fun decifrar(texto: String, chave: Int): String {
    return cifrar(texto, -chave)
}

/**
 * ============================================
 * INFORMAÇÕES ADICIONAIS
 * ============================================
 * 
 * HISTÓRIA:
 * ---------
 * - Criada por Júlio César (100-44 a.C.)
 * - Usada para comunicações militares
 * - César usava chave 3 (A→D, B→E, etc.)
 * - Uma das cifras mais antigas conhecidas
 * 
 * MATEMÁTICA:
 * -----------
 * Cifragem: C = (P + K) mod 26
 * Decifragem: P = (C - K) mod 26
 * 
 * Onde:
 * C = caractere cifrado
 * P = caractere original (plaintext)
 * K = chave (key)
 * 
 * VARIAÇÕES:
 * ----------
 * 1. ROT13: Chave fixa 13
 *    - Cifrar = Decifrar
 *    - Usado em fóruns para ocultar spoilers
 * 
 * 2. Atbash: Inverte o alfabeto
 *    - A↔Z, B↔Y, C↔X, etc.
 *    - Usada na Bíblia
 * 
 * 3. Cifra Afim: C = (aP + b) mod 26
 *    - Mais complexa que César
 *    - Usa duas chaves (a e b)
 * 
 * 4. Vigenère: Múltiplas chaves
 *    - Muito mais segura
 *    - Usa uma palavra-chave
 * 
 * COMO QUEBRAR:
 * -------------
 * 1. Força Bruta: Testar todas as 26 chaves
 * 2. Análise de Frequência: Letras mais comuns
 *    - Português: A, E, O, S, R
 *    - Inglês: E, T, A, O, I
 * 3. Palavras conhecidas: Procurar padrões
 * 
 * CURIOSIDADES:
 * -------------
 * • O nome "cifra" vem do árabe "sifr" (zero)
 * • ROT13 é usado no Unix desde os anos 80
 * • A cifra de César aparece em muitos filmes
 * • É a base para entender criptografia moderna
 * • Enigma (WWII) era uma versão muito mais complexa
 */
