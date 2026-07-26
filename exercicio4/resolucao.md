# Explicação do Programa: Divisão com Validação

## Código atual

```java
import java.util.Scanner;

public class Divisao {
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                
                if (b == 0) {
                    System.out.println("divisao impossivel");
                }
                else {
                    double resultado = (double) a / b;
                    System.out.println(resultado);
                }
            }
        }
    }
}
```

---

## Análise linha por linha

### `import java.util.Scanner;`
Importa a classe `Scanner` do pacote `java.util`. Necessária para ler dados da entrada (teclado).

### `public class Divisao {`
Define a classe `Divisao`. O arquivo deve se chamar `Divisao.java`.

### `public static void main(String[] args) {`
Método principal, ponto de entrada da aplicação.

### `try (Scanner sc = new Scanner(System.in)) {`
Cria um Scanner chamado `sc`, apontando para a entrada padrão (teclado).

Usa `try-with-resources` para garantir fechamento automático do Scanner.

### `int n = sc.nextInt();`
Lê a **quantidade de pares** que serão lidos.

**Exemplo:** `n = 3` significa que vamos ler 3 pares de números.

---

## Loop FOR com leitura de pares

### `for (int i = 0; i < n; i++) {`
Repete `n` vezes (para cada par de números).

### `int a = sc.nextInt();`
Lê o **primeiro número do par** (numerador).

### `int b = sc.nextInt();`
Lê o **segundo número do par** (denominador).

**Fluxo (primeira iteração):**
```
Lê: a = 3
Lê: b = -2
```

---

## ?? Conceito: Validação (Guard Clause)

### O que é validação?

**Validação** é verificar se os dados estão **válidos** antes de usá-los.

Neste caso, validamos se `b` (denominador) é **zero**, que causaria divisão inválida.

---

## Teste do denominador

### `if (b == 0) {`
Testa se o **denominador é zero**.

**Significado:**
- Se `b == 0` ? Divisão impossível (não pode dividir por zero)
- Se `b != 0` ? Pode fazer a divisão

### `System.out.println("divisao impossivel");`
Se o denominador for zero, imprime a mensagem de erro.

---

## Divisão com tipo casting

### `else {`
Se o denominador **não** é zero, pode fazer a divisão.

### `double resultado = (double) a / b;`

**Quebra em partes:**

| Parte | Explicação |
|-------|-----------|
| `(double) a` | **Cast**: converte `a` de `int` para `double` |
| `/` | divisão |
| `b` | denominador (ainda é `int`, mas convertido automaticamente) |

**Por que fazer cast?**

```java
int a = 3;
int b = -2;

// ? Sem cast (divisão inteira)
int resultado1 = a / b;     // resultado1 = -1 (perde casas decimais)

// ? Com cast (divisão decimal)
double resultado2 = (double) a / b;  // resultado2 = -1.5 (mantém casas)
```

### `System.out.println(resultado);`
Imprime o resultado da divisão.

---

## Exemplo passo a passo (entrada dada)

```
N = 3 (vamos ler 3 pares)

Par 1: a = 3, b = -2
  b == 0 ? false
  resultado = (double) 3 / -2 = -1.5
  Imprime: -1.5

Par 2: a = -8, b = 0
  b == 0 ? true
  Imprime: divisao impossivel

Par 3: a = 0, b = 8
  b == 0 ? false
  resultado = (double) 0 / 8 = 0.0
  Imprime: 0.0
```

**Saída final:**
```
-1.5
divisao impossivel
0.0
```

---

## Fluxo de execução completo

```
???????????????????????????????
? java Divisao                ?
???????????????????????????????
             ?
???????????????????????????????
? Lê: n = 3                   ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 0 (i < 3)          ?
? Lê: a = 3, b = -2           ?
? Teste: b == 0 ? false       ?
? resultado = 3 / -2 = -1.5   ?
? Imprime: -1.5               ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 1                  ?
? Lê: a = -8, b = 0           ?
? Teste: b == 0 ? true        ?
? Imprime: divisao impossivel  ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 2 (último)         ?
? Lê: a = 0, b = 8            ?
? Teste: b == 0 ? false       ?
? resultado = 0 / 8 = 0.0     ?
? Imprime: 0.0                ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 3 (3 < 3 ? false)  ?
? Sai do loop                 ?
???????????????????????????????
             ?
???????????????????????????????
? Scanner fecha automaticamente?
???????????????????????????????
```

---

## Tabela de análise (entrada dada)

| Par | a | b | b == 0? | Ação | Saída |
|-----|---|---|---------|------|-------|
| 1 | 3 | -2 | false | Divide | -1.5 |
| 2 | -8 | 0 | **true** | Mensagem | divisao impossivel |
| 3 | 0 | 8 | false | Divide | 0.0 |

---

## ?? Conceito: Type Casting (Conversão de tipo)

### O que é casting?

**Casting** é converter um valor de um tipo de dados para outro.

**Sintaxe:**
```java
(tipo_destino) valor
```

### Divisão inteira vs decimal

```java
int a = 3;
int b = -2;

// ? Divisão inteira (resultado truncado)
int resultado1 = a / b;         // -1 (perde .5)

// ? Divisão decimal (resultado preciso)
double resultado2 = (double) a / b;  // -1.5
```

### Por que funciona?

Ao converter `a` para `double`, toda a operação vira **divisão em ponto flutuante**:

```
(double) 3 / -2
3.0 / -2
= -1.5
```

---

## Guard Clause (Cláusula de Proteção)

### Padrão comum em programação

Uma **guard clause** testa uma condição **inválida** no início e **retorna/aborta** se for verdadeira.

```java
// Guard clause
if (b == 0) {
    System.out.println("divisao impossivel");
    // Não executa o resto do código nesta iteração
}
// Código normal (só executa se passou na validação)
else {
    double resultado = (double) a / b;
    System.out.println(resultado);
}
```

**Vantagem:** Código mais legível (falha rápido).

---

## Outros exemplos

### Exemplo: N = 4

```
Entrada:
4
10 2
7 0
-6 3
0 0

Processamento:
10 / 2 = 5.0
0 é denominador: divisao impossivel
-6 / 3 = -2.0
0 é denominador: divisao impossivel

Saída:
5.0
divisao impossivel
-2.0
divisao impossivel
```

---

## Tratamento de exceções vs Validação

### ? Deixar dar erro (má prática)

```java
double resultado = a / b;  // Pode gerar exceção se b == 0
System.out.println(resultado);
```

**Problema:** Pode gerar `ArithmeticException` (não recomendado).

### ? Validar primeiro (boa prática)

```java
if (b == 0) {
    System.out.println("divisao impossivel");
}
else {
    double resultado = (double) a / b;
    System.out.println(resultado);
}
```

**Vantagem:** Controle total, mensagem clara.

---

## Resumo dos conceitos

- **Validação**: verificar dados antes de usar
- **Guard clause**: testar condição inválida no início
- **Divisão por zero**: impossível em matemática
- **Type casting**: `(double) a` converte `int` para `double`
- **Divisão inteira vs decimal**: `int / int` vs `double / int`
- **if/else com validação**: combina decisão com proteção

---

## Diferença com exercícios anteriores

| Exercício | Conceito |
|-----------|----------|
| 15 | Loop com cálculos simples |
| 16 (este) | **Loop com validação (if/else)** |

---

## Variações possíveis

### Com formato fixo de casas decimais

```java
System.out.printf("%.1f%n", resultado);  // 1 casa decimal
```

Saída:
```
-1.5
divisao impossivel
0.0
```

### Com mais informações

```java
if (b == 0) {
    System.out.println("divisao impossivel");
}
else {
    double resultado = (double) a / b;
    System.out.printf("%d / %d = %.2f%n", a, b, resultado);
}
```

Saída:
```
3 / -2 = -1.50
divisao impossivel
0 / 8 = 0.00
```

### Com try-catch (alternativa menos recomendada)

```java
try {
    double resultado = (double) a / b;
    System.out.println(resultado);
}
catch (ArithmeticException e) {
    System.out.println("divisao impossivel");
}
```


## Visualização do cast

```
int a = 3           double a_convertido = 3.0
          ? CAST ?
                3.0 / -2 = -1.5

Sem cast:
int a = 3
3 / -2 = -1 (truncado)
```

O cast força o uso de **aritmética de ponto flutuante** em vez de inteira.