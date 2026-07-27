# Explicação do Programa: Cálculo de Fatorial

## Código atual

```java
import java.util.Scanner;

public class Fatorial {
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            
            long fatorial = 1;
            
            for (int i = 2; i <= n; i++) {
                fatorial *= i;
            }
            
            System.out.println(fatorial);
        }
    }
}
```

---

## Análise linha por linha

### `import java.util.Scanner;`
Importa a classe `Scanner` do pacote `java.util`. Necessária para ler dados da entrada (teclado).

### `public class Fatorial {`
Define a classe `Fatorial`. O arquivo deve se chamar `Fatorial.java`.

### `public static void main(String[] args) {`
Método principal, ponto de entrada da aplicação.

### `try (Scanner sc = new Scanner(System.in)) {`
Cria um Scanner chamado `sc`, apontando para a entrada padrão (teclado).

Usa `try-with-resources` para garantir fechamento automático do Scanner.

### `int n = sc.nextInt();`
Lê um **número inteiro** do qual calcularemos o fatorial.

**Exemplo:** `n = 4` para calcular `4!`

---

## ?? Conceito: Fatorial

### O que é fatorial?

**Fatorial** de um número N (escrito como N!) é o **produto de todos os números de 1 até N**.

**Definição:**
```
N! = N × (N-1) × (N-2) × ... × 2 × 1
```

**Caso especial:**
```
0! = 1 (por definição)
```

### Exemplos

| N | Cálculo | Fatorial |
|---|---------|----------|
| 0 | (definição) | **1** |
| 1 | 1 | **1** |
| 2 | 2 × 1 | **2** |
| 3 | 3 × 2 × 1 | **6** |
| 4 | 4 × 3 × 2 × 1 | **24** |
| 5 | 5 × 4 × 3 × 2 × 1 | **120** |

---

## ?? Conceito: Type long

### Por que usar `long`?

Fatorial cresce **muito rápido**! Os números ficam grandes demais para `int`.

| N | Fatorial | Cabe em `int`? |
|---|----------|---|
| 4 | 24 | ? sim |
| 10 | 3,628,800 | ? sim |
| 20 | 2,432,902,008,176,640,000 | ? **não** |

**`int` suporta:** até ~2.1 bilhões  
**`long` suporta:** até ~9.2 quintilhões

**Solução:** Usar `long` para armazenar o fatorial.

```java
long fatorial = 1;  // ? Correto
```

---

## Inicialização do acumulador

### `long fatorial = 1;`

Inicializa o **acumulador** com 1.

**Por que 1?** 
- Multiplicar por 1 não muda o valor
- É o **elemento neutro** da multiplicação
- Facilita o cálculo: `1 × 2 × 3 × ... × n`

---

## Loop FOR com multiplicação

### `for (int i = 2; i <= n; i++) {`

Itera de **i = 2** até **i = n** (inclusive).

**Por que começar em 2?**
- Multiplicar por 1 não muda nada
- Economiza uma iteração

**Exemplo (N = 4):**
```
i = 2: fatorial = 1 × 2 = 2
i = 3: fatorial = 2 × 3 = 6
i = 4: fatorial = 6 × 4 = 24
Loop termina (5 > 4)
```

---

## Acúmulo multiplicativo

### `fatorial *= i;`

Multiplica `fatorial` pelo valor de `i` e armazena o resultado em `fatorial`.

**Equivalente a:**
```java
fatorial = fatorial * i;
```

**Processo passo a passo (N = 4):**

```
Antes do loop: fatorial = 1

Iteração 1 (i=2):
  fatorial = 1 × 2 = 2

Iteração 2 (i=3):
  fatorial = 2 × 3 = 6

Iteração 3 (i=4):
  fatorial = 6 × 4 = 24

Loop termina (5 > 4)
Resultado: fatorial = 24
```

---

## Casos especiais

### Quando N = 0 ou N = 1

```
Loop: for (int i = 2; i <= n; i++)

Se n = 0:
  Condição inicial: 2 <= 0 ? false
  Loop não executa
  Resultado: fatorial = 1 ? (correto)

Se n = 1:
  Condição inicial: 2 <= 1 ? false
  Loop não executa
  Resultado: fatorial = 1 ? (correto)
```

**Vantagem:** Sem if/else! O loop naturalmente retorna 1.

---

## Exemplo passo a passo (N = 4)

```
java Fatorial
4

Execução:
n = 4
fatorial = 1

FOR i = 2:
  fatorial *= 2 ? fatorial = 1 × 2 = 2

FOR i = 3:
  fatorial *= 3 ? fatorial = 2 × 3 = 6

FOR i = 4:
  fatorial *= 4 ? fatorial = 6 × 4 = 24

FOR i = 5:
  5 <= 4 ? false ? Sai do loop

Imprime: 24
```

---

## Fluxo de execução completo

```
???????????????????????????????
? java Fatorial               ?
???????????????????????????????
             ?
???????????????????????????????
? Lê: n = 4                   ?
? Inicializa: fatorial = 1    ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 2                  ?
? Condicao: 2 <= 4 ? SIM      ?
? fatorial *= 2 ? 1 × 2 = 2   ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 3                  ?
? Condicao: 3 <= 4 ? SIM      ?
? fatorial *= 3 ? 2 × 3 = 6   ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 4                  ?
? Condicao: 4 <= 4 ? SIM      ?
? fatorial *= 4 ? 6 × 4 = 24  ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 5                  ?
? Condicao: 5 <= 4 ? NÃO      ?
? Sai do loop                 ?
???????????????????????????????
             ?
???????????????????????????????
? Imprime: 24                 ?
???????????????????????????????
             ?
???????????????????????????????
? Scanner fecha automaticamente?
???????????????????????????????
```

---

## Todos os exemplos da entrada

### Entrada 1: N = 4

```
Fatorial de 4 = 4 × 3 × 2 × 1 = 24

Cálculo no código:
Iteração 1: fatorial = 1 × 2 = 2
Iteração 2: fatorial = 2 × 3 = 6
Iteração 3: fatorial = 6 × 4 = 24

Saída: 24
```

---

### Entrada 2: N = 1

```
Fatorial de 1 = 1

Cálculo no código:
Loop: for (i = 2; i <= 1; i++)
  2 <= 1 ? false ? não executa

Resultado: fatorial = 1

Saída: 1
```

---

### Entrada 3: N = 5

```
Fatorial de 5 = 5 × 4 × 3 × 2 × 1 = 120

Cálculo no código:
Iteração 1: fatorial = 1 × 2 = 2
Iteração 2: fatorial = 2 × 3 = 6
Iteração 3: fatorial = 6 × 4 = 24
Iteração 4: fatorial = 24 × 5 = 120

Saída: 120
```

---

### Entrada 4: N = 0

```
Fatorial de 0 = 1 (por definição)

Cálculo no código:
Loop: for (i = 2; i <= 0; i++)
  2 <= 0 ? false ? não executa

Resultado: fatorial = 1

Saída: 1
```

---

## Tabela de análise

| N | Iterações | Cálculo | Resultado |
|---|-----------|---------|-----------|
| 0 | 0 | (nenhuma) | 1 |
| 1 | 0 | (nenhuma) | 1 |
| 4 | 3 | 1 × 2 × 3 × 4 | 24 |
| 5 | 4 | 1 × 2 × 3 × 4 × 5 | 120 |
| 10 | 9 | 1 × 2 × 3 × ... × 10 | 3,628,800 |

---

## Operador de atribuição composta: *=

### O que é `*=`?

Multiplica e atribui em uma única operação.

| Operador | Equivalente | Uso |
|----------|------------|-----|
| `a *= b` | `a = a * b` | multiplicação |
| `a += b` | `a = a + b` | adição |
| `a -= b` | `a = a - b` | subtração |
| `a /= b` | `a = a / b` | divisão |

---

## Resumo dos conceitos

- **Fatorial**: produto de todos os números de 1 até N
- **0! = 1**: por definição matemática
- **long**: tipo para números grandes
- **Acumulador**: variável que acumula resultado (multiplicação aqui)
- **Loop com acúmulo**: combina repetição com cálculo
- **`*=`**: operador de atribuição composta (multiplicação)
- **Começar loop em 2**: economiza iteração (já temos 1)

---

## Diferença: int vs long

```java
// ? int (resultado truncado para fatoriais grandes)
int fatorial = 1;
for (int i = 2; i <= 20; i++) {
    fatorial *= i;  // Overflow!
}

// ? long (suporta números maiores)
long fatorial = 1;
for (int i = 2; i <= 20; i++) {
    fatorial *= i;  // Funciona corretamente
}
```

---

## Visualização do acúmulo multiplicativo

```
Começar: fatorial = 1

Multiplicar por 2: 1 × 2 = 2
                   ?

Multiplicar por 3: 2 × 3 = 6
                   ???

Multiplicar por 4: 6 × 4 = 24
                   ????????????????????????

Resultado final: 24
```

---

## Outras formas de calcular fatorial

### Usando while

```java
long fatorial = 1;
int i = 2;

while (i <= n) {
    fatorial *= i;
    i++;
}
```

### Usando do-while (menos recomendado)

```java
long fatorial = 1;
int i = 2;

do {
    fatorial *= i;
    i++;
} while (i <= n);
```

### Usando recursão (mais avançado)

```java
public static long calcularFatorial(int n) {
    if (n == 0 || n == 1) {
        return 1;
    }
    return n * calcularFatorial(n - 1);
}
```


Este padrão é muito comum:

```
1. Inicializar acumulador com valor neutro
   - Para adição: 0
   - Para multiplicação: 1

2. Repetir: acumulador = operação(acumulador, novo_valor)

3. Retornar resultado do acumulador
```

Exemplos:
- Somatório: acumulador += valor
- Fatorial: acumulador *= valor
- Contagem: acumulador++