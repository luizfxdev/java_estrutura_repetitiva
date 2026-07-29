# Explicação do Programa: Cálculo de Divisores

## Código atual

```java
import java.util.Scanner;

public class Divisores {
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    System.out.println(i);
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

### `public class Divisores {`
Define a classe `Divisores`. O arquivo deve se chamar `Divisores.java`.

### `public static void main(String[] args) {`
Método principal, ponto de entrada da aplicação.

### `try (Scanner sc = new Scanner(System.in)) {`
Cria um Scanner chamado `sc`, apontando para a entrada padrão (teclado).

Usa `try-with-resources` para garantir fechamento automático do Scanner.

### `int n = sc.nextInt();`
Lê um **número inteiro** do qual encontraremos todos os divisores.

**Exemplo:** `n = 6` para encontrar os divisores de 6.

---

## ?? Conceito: Divisor

### O que é divisor?

Um **divisor** de um número N é qualquer número inteiro que divide N **sem deixar resto** (resto zero).

**Definição matemática:**
```
Um número d é divisor de N se: N % d == 0
```

Onde `%` é o operador módulo (resto da divisão).

### Exemplos

#### N = 6

```
6 ÷ 1 = 6 (resto 0) ? 1 é divisor ?
6 ÷ 2 = 3 (resto 0) ? 2 é divisor ?
6 ÷ 3 = 2 (resto 0) ? 3 é divisor ?
6 ÷ 4 = 1 (resto 2) ? 4 NÃO é divisor ?
6 ÷ 5 = 1 (resto 1) ? 5 NÃO é divisor ?
6 ÷ 6 = 1 (resto 0) ? 6 é divisor ?

Divisores de 6: 1, 2, 3, 6
```

#### N = 12

```
12 ÷ 1 = 12 (resto 0) ? 1 é divisor ?
12 ÷ 2 = 6 (resto 0) ? 2 é divisor ?
12 ÷ 3 = 4 (resto 0) ? 3 é divisor ?
12 ÷ 4 = 3 (resto 0) ? 4 é divisor ?
12 ÷ 5 = 2 (resto 2) ? 5 NÃO é divisor ?
12 ÷ 6 = 2 (resto 0) ? 6 é divisor ?
12 ÷ 7, 8, 9, 10, 11 ? NÃO são divisores ?
12 ÷ 12 = 1 (resto 0) ? 12 é divisor ?

Divisores de 12: 1, 2, 3, 4, 6, 12
```

---

## Loop testando cada número

### `for (int i = 1; i <= n; i++) {`
Repete de **i = 1** até **i = n** (inclusive).

**Fluxo (N = 6):**
```
i = 1: Testa 1
i = 2: Testa 2
i = 3: Testa 3
i = 4: Testa 4
i = 5: Testa 5
i = 6: Testa 6
i = 7: 7 > 6 ? Sai do loop
```

---

## Teste do divisor

### `if (n % i == 0) {`
Testa se `i` é **divisor** de `n`.

**Lógica:**
- `n % i`: calcula o resto da divisão de n por i
- `== 0`: verifica se o resto é zero
- Se verdadeiro ? i é divisor

**Exemplos (N = 6):**
```
6 % 1 == 0 ? true  ? 1 é divisor
6 % 2 == 0 ? true  ? 2 é divisor
6 % 3 == 0 ? true  ? 3 é divisor
6 % 4 == 0 ? false ? 4 NÃO é divisor
6 % 5 == 0 ? false ? 5 NÃO é divisor
6 % 6 == 0 ? true  ? 6 é divisor
```

### `System.out.println(i);`
Se `i` é divisor, imprime o número.

---

## Exemplo passo a passo (N = 6)

```
java Divisores
6

Execução:
n = 6

FOR i = 1:
  6 % 1 == 0 ? true
  Imprime: 1

FOR i = 2:
  6 % 2 == 0 ? true
  Imprime: 2

FOR i = 3:
  6 % 3 == 0 ? true
  Imprime: 3

FOR i = 4:
  6 % 4 == 0 ? false
  Não imprime

FOR i = 5:
  6 % 5 == 0 ? false
  Não imprime

FOR i = 6:
  6 % 6 == 0 ? true
  Imprime: 6

FOR i = 7:
  7 <= 6 ? false ? Sai do loop
```

**Saída final:**
```
1
2
3
6
```

---

## Fluxo de execução completo

```
???????????????????????????????
? java Divisores              ?
???????????????????????????????
             ?
???????????????????????????????
? Lê: n = 6                   ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 1                  ?
? Teste: 6 % 1 == 0 ? true    ?
? Imprime: 1                  ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 2                  ?
? Teste: 6 % 2 == 0 ? true    ?
? Imprime: 2                  ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 3                  ?
? Teste: 6 % 3 == 0 ? true    ?
? Imprime: 3                  ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 4, 5 (false)       ?
? Não imprime                 ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 6                  ?
? Teste: 6 % 6 == 0 ? true    ?
? Imprime: 6                  ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 7                  ?
? 7 <= 6 ? false              ?
? Sai do loop                 ?
???????????????????????????????
             ?
???????????????????????????????
? Scanner fecha automaticamente?
???????????????????????????????
```

---

## Outros exemplos

### Exemplo: N = 12

```
Divisores de 12:
1 (12 % 1 = 0)
2 (12 % 2 = 0)
3 (12 % 3 = 0)
4 (12 % 4 = 0)
6 (12 % 6 = 0)
12 (12 % 12 = 0)

Saída:
1
2
3
4
6
12
```

### Exemplo: N = 1

```
Divisores de 1:
1 (1 % 1 = 0)

Saída:
1
```

### Exemplo: N = 7 (número primo)

```
Divisores de 7:
1 (7 % 1 = 0)
7 (7 % 7 = 0)

Saída:
1
7

(Números primos têm apenas 1 e ele mesmo como divisores)
```

---

## Tabela de análise (N = 6)

| i | i <= 6? | 6 % i | Resto == 0? | Ação |
|---|---------|-------|------------|------|
| 1 | SIM | 0 | **SIM** | Imprime |
| 2 | SIM | 0 | **SIM** | Imprime |
| 3 | SIM | 0 | **SIM** | Imprime |
| 4 | SIM | 2 | NÃO | - |
| 5 | SIM | 1 | NÃO | - |
| 6 | SIM | 0 | **SIM** | Imprime |
| 7 | NÃO | - | - | Sai |

---

## Diferença: Divisor vs Resto

### Resto (módulo)

```java
6 % 1 = 0  // resto zero ? divisor
6 % 2 = 0  // resto zero ? divisor
6 % 4 = 2  // resto 2 ? não é divisor
```

### Quociente (divisão inteira)

```java
6 / 1 = 6  // resultado inteiro
6 / 2 = 3  // resultado inteiro
6 / 4 = 1  // resultado inteiro (perde resto)
```

**Importante:** Usamos `%` (módulo) para testar divisores, não `/` (divisão).

---

## Resumo dos conceitos

- **Divisor**: número que divide outro sem deixar resto
- **Módulo `%`**: calcula o resto da divisão
- **Teste de divisor**: `n % i == 0`
- **Loop de 1 até n**: testa cada número possível
- **Números primos**: têm apenas 1 e ele mesmo como divisores
- **Número 1**: é divisor de todo número

---

## Diferença com exercícios anteriores

| Exercício | Conceito |
|-----------|----------|
| 17 | Loop com acúmulo multiplicativo (fatorial) |
| 18 (este) | **Loop com teste/filtro (divisores)** |

---

## Variações possíveis

### Contar quantos divisores tem

```java
int contador = 0;

for (int i = 1; i <= n; i++) {
    if (n % i == 0) {
        System.out.println(i);
        contador++;
    }
}

System.out.println("Total de divisores: " + contador);
```

Saída (N = 6):
```
1
2
3
6
Total de divisores: 4
```

### Divisores em uma única linha

```java
System.out.print("Divisores de " + n + ": ");

for (int i = 1; i <= n; i++) {
    if (n % i == 0) {
        System.out.print(i + " ");
    }
}

System.out.println();
```

Saída (N = 6):
```
Divisores de 6: 1 2 3 6
```

### Apenas divisores próprios (excluindo n)

```java
for (int i = 1; i < n; i++) {  // Note: i < n (não <=)
    if (n % i == 0) {
        System.out.println(i);
    }
}
```

Saída (N = 6):
```
1
2
3
```

### Com validação de número positivo

```java
if (n <= 0) {
    System.out.println("Digite um numero positivo!");
    return;
}

for (int i = 1; i <= n; i++) {
    if (n % i == 0) {
        System.out.println(i);
    }
}
```


## Propriedades dos divisores

### Todo número tem pelo menos 2 divisores:
- **1** (sempre divide qualquer número)
- **Ele mesmo** (N divide N)

### Números primos têm exatamente 2 divisores:
```
7: 1, 7
11: 1, 11
13: 1, 13
```

### Número 1 tem apenas 1 divisor:
```
1: 1
```

### Número perfeito:
Um número é perfeito se a soma dos seus divisores próprios (excluindo ele) equals o número:
```
6: divisores próprios = 1, 2, 3
   soma = 1 + 2 + 3 = 6 ? (6 é número perfeito)
```