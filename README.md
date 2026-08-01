# Estruturas Repetitivas (Loops) em Java

## 📚 Introdução

**Estruturas repetitivas** (ou loops) são blocos de código que **repetem múltiplas vezes** até que uma condição seja satisfeita. São fundamentais em programação para evitar escrever o mesmo código várias vezes.

---

## 🎯 Por que usar loops?

### ❌ Sem loop (código repetido)

```java
System.out.println("1");
System.out.println("2");
System.out.println("3");
System.out.println("4");
System.out.println("5");
```

**Problema:** Código repetitivo, difícil de manter, impossível para N grandes.

### ✅ Com loop (código limpo)

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

**Vantagem:** Conciso, dinâmico, reutilizável.

---

## 🔄 Tipos de Loops

### 1. Loop FOR

#### Sintaxe

```java
for (inicializacao; condicao; incremento) {
    // código que se repete
}
```

#### Partes

| Parte | Significado | Exemplo |
|-------|-------------|---------|
| **Inicialização** | Valor inicial da variável | `int i = 1` |
| **Condição** | Enquanto verdadeira, repete | `i <= 10` |
| **Incremento** | Aumenta após cada volta | `i++` |

#### Exemplo: Contar de 1 a 5

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

**Saída:**
```
1
2
3
4
5
```

#### Quando usar

- Número de repetições **conhecido**
- Precisa iterar sobre **intervalos de números**
- Operações simples e diretas

---

### 2. Loop WHILE

#### Sintaxe

```java
while (condicao) {
    // código que se repete
    // IMPORTANTE: deve alterar a condição
}
```

#### Exemplo: Contar de 1 a 5

```java
int i = 1;
while (i <= 5) {
    System.out.println(i);
    i++;
}
```

**Saída:**
```
1
2
3
4
5
```

#### Quando usar

- Número de repetições **desconhecido**
- Precisa testar uma **condição complexa**
- Entrada do usuário (loop até comando especial)

#### Exemplo com entrada do usuário

```java
Scanner sc = new Scanner(System.in);
int numero = 0;

while (numero != -1) {
    System.out.println("Digite um número (-1 para sair):");
    numero = sc.nextInt();
    if (numero != -1) {
        System.out.println("Você digitou: " + numero);
    }
}

System.out.println("Programa encerrado!");
```

---

### 3. Loop DO-WHILE

#### Sintaxe

```java
do {
    // código que se repete (executa SEMPRE pelo menos 1 vez)
} while (condicao);
```

#### Diferença

- **WHILE:** Testa condição **antes** (pode não executar)
- **DO-WHILE:** Testa condição **depois** (executa sempre 1 vez)

#### Exemplo

```java
int numero = 0;

do {
    System.out.println("Digite um número (0 para sair):");
    numero = 5;  // Simula entrada
    System.out.println("Número: " + numero);
} while (numero != 0);
```

#### Quando usar

- Precisa executar **pelo menos uma vez**
- Menu de opções (sempre mostra pelo menos 1 vez)

---

## ⚖️ FOR vs WHILE vs DO-WHILE

| Aspecto | FOR | WHILE | DO-WHILE |
|--------|-----|-------|----------|
| Quando usar | Número conhecido | Número desconhecido | Pelo menos 1 vez |
| Testa antes? | ✓ Sim | ✓ Sim | ✗ Não (testa depois) |
| Inicialização | No FOR | Fora do loop | Fora do loop |
| Legibilidade | Melhor | Boa | Boa |
| Exemplo | `for (i=1; i<=10; i++)` | `while (i <= 10)` | `do { ... } while (i <= 10)` |

---

## 🧠 Padrões Comuns de Loop

### 1. Contagem Simples

```java
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}
```

**Uso:** Repetir uma ação N vezes.

---

### 2. Acúmulo (Soma)

```java
int soma = 0;

for (int i = 1; i <= 5; i++) {
    soma += i;  // soma = soma + i
}

System.out.println(soma);  // 15 (1+2+3+4+5)
```

**Uso:** Acumular valores.

---

### 3. Acúmulo Multiplicativo (Produto)

```java
long fatorial = 1;

for (int i = 2; i <= 5; i++) {
    fatorial *= i;  // fatorial = fatorial * i
}

System.out.println(fatorial);  // 120 (5!)
```

**Uso:** Multiplicar valores (fatorial, etc).

---

### 4. Filtro (Teste)

```java
int n = 12;

for (int i = 1; i <= n; i++) {
    if (n % i == 0) {  // Se é divisor
        System.out.println(i);  // Imprime
    }
}
```

**Saída:** `1 2 3 4 6 12`

**Uso:** Selecionar valores que atendem critério.

---

### 5. Cálculo por Iteração

```java
for (int i = 1; i <= 5; i++) {
    int quadrado = i * i;
    int cubo = i * i * i;
    
    System.out.println(i + " " + quadrado + " " + cubo);
}
```

**Saída:**
```
1 1 1
2 4 8
3 9 27
4 16 64
5 25 125
```

**Uso:** Processar cada item e gerar saída.

---

## 🔐 Controle de Loop

### Break (Sair do loop)

```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) {
        break;  // Sai do loop quando i = 5
    }
    System.out.println(i);
}
```

**Saída:** `1 2 3 4`

---

### Continue (Pular iteração)

```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue;  // Pula quando i = 3
    }
    System.out.println(i);
}
```

**Saída:** `1 2 4 5` (3 foi pulado)

---

## ⚠️ Erros Comuns

### 1. Loop Infinito

```java
// ❌ ERRADO: Condição nunca falsa
int i = 1;
while (true) {
    System.out.println(i);
    // i nunca incrementa!
}
```

**Solução:** Sempre alterar a variável de controle.

```java
// ✓ CORRETO
int i = 1;
while (i <= 10) {
    System.out.println(i);
    i++;  // Incrementa!
}
```

---

### 2. Off-by-one (Erro de limites)

```java
// ❌ ERRADO: Falta a última iteração
for (int i = 1; i < 5; i++) {  // < em vez de <=
    System.out.println(i);
}
// Saída: 1 2 3 4 (falta 5)

// ✓ CORRETO
for (int i = 1; i <= 5; i++) {  // <=
    System.out.println(i);
}
// Saída: 1 2 3 4 5
```

---

### 3. Modificar variável dentro do loop

```java
// ⚠️ CUIDADO: Modificar i dentro do loop
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
    i += 2;  // Pula valores!
}
// Saída: 1 3 5 (incrementa mais do esperado)
```

---

## 📊 Progressão de Exercícios

| Exercício | Conceito | Loop |
|-----------|----------|------|
| 13 | Números ímpares | FOR simples |
| 14 | Contagem em intervalo | FOR com acúmulo |
| 15 | Média ponderada (N casos) | FOR com cálculo |
| 16 | Divisão validada (N pares) | FOR com validação |
| 17 | Fatorial | FOR com acúmulo multiplicativo |
| 18 | Divisores | FOR com filtro |
| 19 | Quadrado e cubo | FOR com cálculos |

---

## 💡 Boas Práticas

### 1. Escolher o loop certo

```java
// FOR: número conhecido
for (int i = 0; i < 10; i++) { ... }

// WHILE: número desconhecido
while (condicao) { ... }

// DO-WHILE: sempre executa 1 vez
do { ... } while (condicao);
```

### 2. Nomear variáveis de controle claramente

```java
// ❌ Ruim: letra 'x' sem significado
for (int x = 1; x <= 10; x++) { ... }

// ✓ Bom: nome descritivo
for (int contador = 1; contador <= 10; contador++) { ... }
for (int linha = 1; linha <= 10; linha++) { ... }
```

### 3. Evitar modificar variável de controle

```java
// ❌ Evitar
for (int i = 1; i <= 10; i++) {
    i += 2;  // Modifica dentro do loop
}

// ✓ Melhor: use incremento correto
for (int i = 1; i <= 10; i += 2) {
    // ...
}
```

### 4. Use break/continue com moderação

```java
// ❌ Abusado: muitos breaks
for (int i = 0; i < 10; i++) {
    if (condicao1) break;
    if (condicao2) break;
    if (condicao3) break;
}

// ✓ Melhor: teste a condição no while
int i = 0;
while (i < 10 && condicao1 && condicao2 && condicao3) {
    i++;
}
```

---

## 🎓 Exemplos Práticos Completos

### Exemplo 1: Somatório

```java
int soma = 0;

for (int i = 1; i <= 10; i++) {
    soma += i;
}

System.out.println("Soma de 1 a 10: " + soma);  // 55
```

---

### Exemplo 2: Números primos até N

```java
int n = 20;

for (int num = 2; num <= n; num++) {
    boolean ehPrimo = true;
    
    for (int divisor = 2; divisor < num; divisor++) {
        if (num % divisor == 0) {
            ehPrimo = false;
            break;
        }
    }
    
    if (ehPrimo) {
        System.out.println(num);
    }
}
```

**Saída:** `2 3 5 7 11 13 17 19`

---

### Exemplo 3: Tabela de multiplicação

```java
int n = 5;

for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
        System.out.print(i * j + "\t");
    }
    System.out.println();
}
```

**Saída:**
```
1	2	3	4	5	
2	4	6	8	10	
3	6	9	12	15	
4	8	12	16	20	
5	10	15	20	25	
```

---

### Exemplo 4: Entrada do usuário até valor especial

```java
Scanner sc = new Scanner(System.in);
int soma = 0;
int numero;

System.out.println("Digite números (0 para sair):");

do {
    numero = sc.nextInt();
    
    if (numero != 0) {
        soma += numero;
    }
} while (numero != 0);

System.out.println("Soma total: " + soma);
```

---

## 🔗 Loops Aninhados

**Loops dentro de loops** para processar estruturas 2D ou complexas.

```java
// Tabela 3x3
for (int linha = 1; linha <= 3; linha++) {
    for (int coluna = 1; coluna <= 3; coluna++) {
        System.out.print("[" + linha + "," + coluna + "] ");
    }
    System.out.println();
}
```

**Saída:**
```
[1,1] [1,2] [1,3] 
[2,1] [2,2] [2,3] 
[3,1] [3,2] [3,3] 
```

---

## 📈 Performance

### Complexidade de Loops

```java
// O(n) - Linear
for (int i = 0; i < n; i++) { ... }

// O(n²) - Quadrática (loops aninhados)
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) { ... }
}

// O(n³) - Cúbica (3 loops aninhados)
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) { ... }
    }
}
```

**Dica:** Evite loops desnecessários aninhados em grandes quantidades.

---

## 🎯 Resumo

- **Loops** repetem código enquanto condição é verdadeira
- **FOR**: melhor quando número de repetições é conhecido
- **WHILE**: melhor quando número é desconhecido
- **DO-WHILE**: garante execução de pelo menos 1 vez
- **Padrões comuns**: contagem, acúmulo, filtro, cálculo
- **Break/Continue**: controle fino do fluxo
- **Evitar**: loops infinitos, off-by-one errors, modificações internas
