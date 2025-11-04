/**
 * ============================================
 * CIFRA DE CÉSAR - VISUALIZAÇÃO DIDÁTICA
 * ============================================
 * 
 * Este programa mostra visualmente como a Cifra de César funciona
 */

fun main() {
    println("═══════════════════════════════════════════════════════════════")
    println("    CIFRA DE CÉSAR - VISUALIZAÇÃO DIDÁTICA")
    println("═══════════════════════════════════════════════════════════════\n")
    
    // Demonstração 1: Alfabeto deslocado
    demonstrarAlfabetoDeslocado()
    
    // Demonstração 2: Processo passo a passo
    demonstrarProcessoPassoAPasso()
    
    // Demonstração 3: Tabela de todas as chaves
    demonstrarTabelaCompleta()
    
    // Demonstração 4: Análise de frequência
    demonstrarAnaliseFrequencia()
}

fun demonstrarAlfabetoDeslocado() {
    println("📊 DEMONSTRAÇÃO 1: Alfabeto Deslocado")
    println("─────────────────────────────────────────────────────────────\n")
    
    val chave = 3
    println("Chave: $chave (deslocamento de 3 posições)\n")
    
    // Alfabeto original
    print("Original:  ")
    for (c in 'A'..'Z') {
        print("$c ")
    }
    println()
    
    // Alfabeto cifrado
    print("Cifrado:   ")
    for (c in 'A'..'Z') {
        val posicao = c - 'A'
        val novaPosicao = (posicao + chave) % 26
        val novoCar = 'A' + novaPosicao
        print("$novoCar ")
    }
    println("\n")
    
    // Setas mostrando o deslocamento
    println("Exemplos de mapeamento:")
    for (c in listOf('A', 'E', 'H', 'L', 'O', 'X', 'Y', 'Z')) {
        val posicao = c - 'A'
        val novaPosicao = (posicao + chave) % 26
        val novoCar = 'A' + novaPosicao
        println("  $c (posição $posicao) → $novoCar (posição $novaPosicao)")
    }
    println()
}

fun demonstrarProcessoPassoAPasso() {
    println("🔍 DEMONSTRAÇÃO 2: Processo Passo a Passo")
    println("─────────────────────────────────────────────────────────────\n")
    
    val mensagem = "HELLO"
    val chave = 3
    
    println("Cifrando: \"$mensagem\" com chave $chave\n")
    println("┌────────┬─────────┬──────────┬─────────┬──────────┐")
    println("│ Letra  │ Posição │ + Chave  │ Mod 26  │ Resultado│")
    println("├────────┼─────────┼──────────┼─────────┼──────────┤")
    
    val resultado = StringBuilder()
    for (char in mensagem) {
        val posicao = char - 'A'
        val soma = posicao + chave
        val novaPosicao = soma % 26
        val novoChar = 'A' + novaPosicao
        resultado.append(novoChar)
        
        println("│   $char    │   %2d    │   %2d     │   %2d    │    $novoChar     │".format(posicao, soma, novaPosicao))
    }
    
    println("└────────┴─────────┴──────────┴─────────┴──────────┘")
    println("\nResultado final: $resultado")
    println()
}

fun demonstrarTabelaCompleta() {
    println("📋 DEMONSTRAÇÃO 3: Tabela de Todas as Chaves")
    println("─────────────────────────────────────────────────────────────\n")
    
    val mensagem = "KOTLIN"
    println("Mensagem original: $mensagem\n")
    println("┌──────┬────────────┐")
    println("│ Chave│ Resultado  │")
    println("├──────┼────────────┤")
    
    for (chave in 0..25) {
        val cifrada = cifrar(mensagem, chave)
        val marcador = if (chave == 13) " ← ROT13" else ""
        println("│  %2d  │ %-10s │$marcador".format(chave, cifrada))
    }
    
    println("└──────┴────────────┘")
    println("\n💡 Observe que com chave 0, a mensagem não muda!")
    println("💡 Com chave 26, voltamos ao início (igual a chave 0)")
    println()
}

fun demonstrarAnaliseFrequencia() {
    println("📈 DEMONSTRAÇÃO 4: Análise de Frequência")
    println("─────────────────────────────────────────────────────────────\n")
    
    val mensagemOriginal = "ESTA E UMA MENSAGEM SECRETA PARA TESTAR A ANALISE DE FREQUENCIA"
    val chave = 7
    val mensagemCifrada = cifrar(mensagemOriginal, chave)
    
    println("Mensagem original:")
    println("\"$mensagemOriginal\"\n")
    
    println("Mensagem cifrada (chave $chave):")
    println("\"$mensagemCifrada\"\n")
    
    // Análise de frequência da mensagem original
    println("Frequência de letras na mensagem ORIGINAL:")
    val freqOriginal = analisarFrequencia(mensagemOriginal)
    exibirFrequencia(freqOriginal, 10)
    
    println("\nFrequência de letras na mensagem CIFRADA:")
    val freqCifrada = analisarFrequencia(mensagemCifrada)
    exibirFrequencia(freqCifrada, 10)
    
    println("\n💡 Observe que o PADRÃO de frequência se mantém!")
    println("💡 A letra mais comum continua sendo a mais comum")
    println("💡 Isso torna a cifra vulnerável a ataques!")
    println()
    
    // Demonstrar como quebrar usando frequência
    println("🔓 Quebrando a cifra usando análise de frequência:")
    println("─────────────────────────────────────────────────────────────")
    
    val letraMaisComumCifrada = freqCifrada.maxByOrNull { it.value }?.key ?: 'A'
    val letraMaisComumPortugues = 'A' // Em português, 'A' e 'E' são as mais comuns
    
    println("Letra mais comum na mensagem cifrada: $letraMaisComumCifrada")
    println("Letra mais comum em português: $letraMaisComumPortugues")
    
    val chaveEstimada = (letraMaisComumCifrada - letraMaisComumPortugues + 26) % 26
    println("Chave estimada: $chaveEstimada")
    
    val tentativaDecifragem = decifrar(mensagemCifrada, chaveEstimada)
    println("\nTentativa de decifragem:")
    println("\"$tentativaDecifragem\"")
    
    if (chaveEstimada == chave) {
        println("\n✅ Sucesso! A chave foi descoberta!")
    } else {
        println("\n⚠️ A estimativa não foi perfeita, mas está próxima!")
        println("Chave real: $chave")
    }
    println()
}

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

fun analisarFrequencia(texto: String): Map<Char, Int> {
    val frequencia = mutableMapOf<Char, Int>()
    
    for (char in texto) {
        if (char.isLetter()) {
            val charUpper = char.uppercaseChar()
            frequencia[charUpper] = frequencia.getOrDefault(charUpper, 0) + 1
        }
    }
    
    return frequencia.toList().sortedByDescending { it.second }.toMap()
}

fun exibirFrequencia(frequencia: Map<Char, Int>, limite: Int = 10) {
    var contador = 0
    for ((letra, freq) in frequencia) {
        if (contador >= limite) break
        val barra = "█".repeat(freq)
        println("  $letra: $barra ($freq)")
        contador++
    }
}

/**
 * ============================================
 * CONCEITOS IMPORTANTES
 * ============================================
 * 
 * 1. DESLOCAMENTO CIRCULAR:
 *    O alfabeto é tratado como um círculo.
 *    Quando chegamos em Z, voltamos para A.
 *    Isso é feito com a operação "mod 26".
 * 
 * 2. ANÁLISE DE FREQUÊNCIA:
 *    Em qualquer idioma, certas letras aparecem
 *    mais frequentemente que outras.
 *    
 *    Português: A, E, O, S, R, I, N, D, M, U
 *    Inglês: E, T, A, O, I, N, S, H, R, D
 *    
 *    A Cifra de César mantém essas frequências,
 *    apenas "desloca" as letras. Por isso é
 *    vulnerável a este tipo de ataque.
 * 
 * 3. PROPRIEDADES MATEMÁTICAS:
 *    - Chave 0: Não altera a mensagem
 *    - Chave 26: Igual a chave 0 (volta ao início)
 *    - Chave 13 (ROT13): Cifrar = Decifrar
 *    - Chave -K: Equivale a decifrar com chave K
 * 
 * 4. SEGURANÇA:
 *    A Cifra de César é considerada "quebrada"
 *    porque:
 *    - Apenas 26 chaves possíveis (força bruta)
 *    - Vulnerável a análise de frequência
 *    - Não esconde padrões do texto
 *    - Não usa chave secreta forte
 * 
 * 5. APLICAÇÕES MODERNAS:
 *    Embora não seja segura, a Cifra de César
 *    ainda é usada para:
 *    - Ensino de criptografia
 *    - ROT13 para ocultar spoilers
 *    - Puzzles e jogos
 *    - Ofuscação simples (não segurança!)
 */
