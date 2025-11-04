# 🔐 Aula Completa: Cifra de César

## 📚 Conteúdo da Aula

Esta aula completa sobre **Cifra de César** contém 3 arquivos Kotlin:

### 1. **A10_CifraDeCesar.kt** - Aula Teórica e Prática
Arquivo principal com:
- ✅ Explicação completa do conceito
- ✅ Exemplos práticos de cifragem e decifragem
- ✅ Demonstração de diferentes chaves
- ✅ Ataque de força bruta
- ✅ ROT13 (caso especial)
- ✅ Explicação matemática detalhada
- ✅ Vantagens e desvantagens
- ✅ Variações da cifra

### 2. **A11_ExerciciosCifraDeCesar.kt** - Exercícios Práticos
5 exercícios para praticar:
1. Cifrar uma mensagem
2. Decifrar uma mensagem
3. Descobrir a chave usada
4. Cifrar números (0-9)
5. Quebrar cifra por força bruta

### 3. **A12_CifraDeCesarInterativa.kt** - Programa Interativo
Menu interativo com opções para:
- 🔒 Cifrar mensagens
- 🔓 Decifrar mensagens
- 💪 Quebrar cifras (força bruta)
- 📚 Ver demonstrações completas

---

## 🎯 O que é a Cifra de César?

A **Cifra de César** é uma das técnicas de criptografia mais antigas e simples. Foi usada por **Júlio César** para proteger mensagens militares no Império Romano.

### Como Funciona?

A cifra desloca cada letra do alfabeto por um número fixo de posições (a **chave**).

**Exemplo com chave 3:**
```
A → D
B → E
C → F
...
X → A
Y → B
Z → C
```

**Mensagem original:** `HELLO`  
**Mensagem cifrada:** `KHOOR`

---

## 🧮 Matemática

### Fórmula de Cifragem:
```
C = (P + K) mod 26
```

### Fórmula de Decifragem:
```
P = (C - K) mod 26
```

Onde:
- **C** = caractere cifrado
- **P** = caractere original (plaintext)
- **K** = chave (deslocamento)
- **mod 26** = resto da divisão por 26 (volta ao início do alfabeto)

---

## 💻 Como Executar

### Executar a Aula Principal:
```bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
cd /vercel/sandbox
kotlinc src/main/kotlin/A10_CifraDeCesar.kt -include-runtime -d CifraDeCesar.jar
java -jar CifraDeCesar.jar
```

### Executar os Exercícios:
```bash
kotlinc src/main/kotlin/A11_ExerciciosCifraDeCesar.kt -include-runtime -d ExerciciosCesar.jar
java -jar ExerciciosCesar.jar
```

### Executar o Programa Interativo:
```bash
kotlinc src/main/kotlin/A12_CifraDeCesarInterativa.kt -include-runtime -d CesarInterativo.jar
java -jar CesarInterativo.jar
```

---

## 📖 Exemplos Práticos

### Exemplo 1: Cifrando
```kotlin
val mensagem = "HELLO WORLD"
val chave = 3
val cifrada = cifrarCesar(mensagem, chave)
// Resultado: "KHOOR ZRUOG"
```

### Exemplo 2: Decifrando
```kotlin
val cifrada = "KHOOR ZRUOG"
val chave = 3
val decifrada = decifrarCesar(cifrada, chave)
// Resultado: "HELLO WORLD"
```

### Exemplo 3: ROT13 (Chave 13)
```kotlin
val mensagem = "SEGREDO"
val rot13_1 = cifrarCesar(mensagem, 13)  // "FRTERQB"
val rot13_2 = cifrarCesar(rot13_1, 13)   // "SEGREDO" (volta ao original!)
```

---

## 🔓 Como Quebrar a Cifra

### 1. Força Bruta
Teste todas as 26 chaves possíveis:
```kotlin
for (chave in 0..25) {
    val tentativa = decifrarCesar(textoCifrado, chave)
    println("Chave $chave: $tentativa")
}
```

### 2. Análise de Frequência
Letras mais comuns em português: **A, E, O, S, R**  
Letras mais comuns em inglês: **E, T, A, O, I**

Se a letra mais frequente na mensagem cifrada é **K**, e sabemos que **E** é a mais comum, a chave provavelmente é **6** (K - E = 6).

---

## ✅ Vantagens

- ✓ Muito simples de implementar
- ✓ Rápida de executar
- ✓ Excelente para fins educacionais
- ✓ Boa introdução à criptografia

## ❌ Desvantagens

- ✗ Muito fácil de quebrar (apenas 26 possibilidades)
- ✗ Vulnerável a análise de frequência
- ✗ **NÃO é segura para uso real**
- ✗ Mantém padrões do texto original

---

## 🎭 Variações da Cifra de César

### 1. **ROT13**
- Chave fixa: 13
- Propriedade especial: cifrar = decifrar
- Usado em fóruns para ocultar spoilers

### 2. **Cifra de Atbash**
- Inverte o alfabeto: A↔Z, B↔Y, C↔X
- Usada em textos bíblicos

### 3. **Cifra de Vigenère**
- Usa múltiplas chaves (palavra-chave)
- Muito mais segura que César

### 4. **Cifra Afim**
- Fórmula: C = (aP + b) mod 26
- Usa duas chaves (a e b)

---

## 🎯 Desafios Práticos

### Desafio 1: Básico
Decifre: `KHOOR ZRUOG` (chave entre 1-5)

<details>
<summary>Ver resposta</summary>
Chave 3: HELLO WORLD
</details>

### Desafio 2: Intermediário
Decifre: `SUREUDPDU H GLYHUWLGR` (chave entre 1-10)

<details>
<summary>Ver resposta</summary>
Chave 3: PROGRAMAR E DIVERTIDO
</details>

### Desafio 3: Avançado
Decifre: `WKLV LV D VHFUHW` (descubra a chave)

<details>
<summary>Ver resposta</summary>
Chave 3: THIS IS A SECRET
</details>

---

## 📚 História

- **Criada por:** Júlio César (100-44 a.C.)
- **Uso original:** Comunicações militares romanas
- **Chave de César:** 3 (A→D, B→E, C→F)
- **Primeira menção:** Suetônio, "Vida dos Doze Césares"

---

## 🔒 Segurança Moderna

### ⚠️ NÃO USE para:
- ❌ Senhas
- ❌ Dados bancários
- ❌ Informações pessoais
- ❌ Qualquer dado sensível

### ✅ USE para:
- ✓ Aprendizado de criptografia
- ✓ Puzzles e jogos
- ✓ ROT13 para spoilers
- ✓ Demonstrações educacionais

---

## 🌟 Curiosidades

1. O nome "cifra" vem do árabe **"sifr"** (zero)
2. ROT13 é usado no Unix desde os anos 80
3. A máquina **Enigma** (2ª Guerra Mundial) era uma versão muito mais complexa
4. A cifra aparece em filmes como "2001: Uma Odisseia no Espaço" (HAL = IBM - 1)
5. É a base para entender criptografia moderna

---

## 📖 Recursos Adicionais

### Livros Recomendados:
- "The Code Book" - Simon Singh
- "Cryptography and Network Security" - William Stallings

### Sites Úteis:
- [CyberChef](https://gchq.github.io/CyberChef/) - Ferramenta online
- [dCode](https://www.dcode.fr/caesar-cipher) - Decodificador online

### Próximos Passos:
1. Estude a **Cifra de Vigenère**
2. Aprenda sobre **criptografia moderna** (AES, RSA)
3. Explore **análise de frequência**
4. Pratique com **CTF** (Capture The Flag)

---

## 🎓 Conclusão

A Cifra de César é uma excelente introdução ao mundo da criptografia! Embora não seja segura para uso real, ela ensina conceitos fundamentais que são a base da criptografia moderna.

**Lembre-se:** A segurança de uma cifra não deve depender do segredo do algoritmo, mas sim da chave (Princípio de Kerckhoffs).

---

## 👨‍💻 Autor

Aula criada para ensinar os fundamentos de criptografia usando Kotlin.

**Bons estudos! 🚀**
