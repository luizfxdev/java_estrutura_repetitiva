# Explicação do Programa: Contagem de Valores em Intervalo

## Código atual

```java
import java.util.Scanner;

public class IntervaloContagem {
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            
            int in = 0;
            int out = 0;
            
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                
                if (x >= 10 && x <= 20) {
                    in++;
                }
                else {
                    out++;
                }
            }
            
            System.out.println("In: " + in);
            System.out.println("Out: " + out);
        }
    }
}
```

---

## Análise linha por linha

### `import java.util.Scanner;`
Importa a classe `Scanner` do pacote `java.util`. Necessária para ler dados da entrada (teclado).

### `public class IntervaloContagem {`
Define a classe `IntervaloContagem`. O arquivo deve se chamar `IntervaloContagem.java`.

### `public static void main(String[] args) {`
Método principal, ponto de entrada da aplicação.

### `try (Scanner sc = new Scanner(System.in)) {`
Cria um Scanner chamado `sc`, apontando para a entrada padrão (teclado).

Usa `try-with-resources` para garantir fechamento automático do Scanner.

### `int n = sc.nextInt();`
Lê a **quantidade de valores** que serão lidos em seguida.

**Exemplo:** `n = 5` significa que vamos ler 5 valores X.

### `int in = 0;`
Inicializa o **contador de valores dentro do intervalo** com 0.

### `int out = 0;`
Inicializa o **contador de valores fora do intervalo** com 0.

---

## Loop FOR com leitura múltipla

### `for (int i = 0; i < n; i++) {`
Repete `n` vezes (de 0 até n-1).

**Exemplo:** Se `n = 5`, o loop executa 5 vezes (i = 0, 1, 2, 3, 4).

### `int x = sc.nextInt();`
Lê um **valor inteiro** a cada iteração e armazena em `x`.

**Fluxo:**
```
Iteração 1: Lê 14 ? x = 14
Iteração 2: Lê 123 ? x = 123
Iteração 3: Lê 10 ? x = 10
Iteração 4: Lê -25 ? x = -25
Iteração 5: Lê 32 ? x = 32
```

---

## ?? Conceito: Incremento de contador (++)

### O que é um contador?

Um **contador** é uma variável que **acumula valores** (geralmente incrementa de 1 em 1).

**Sintaxe:**
```java
in++;    // equivalente a: in = in + 1
out++;   // equivalente a: out = out + 1
```

### Teste do intervalo [10,20]

### `if (x >= 10 && x <= 20) {`
Testa se `x` **está dentro** do intervalo [10,20].

**Significado:**
- `x >= 10`: x é maior ou igual a 10
- `&&`: E (operador AND)
- `x <= 20`: x é menor ou igual a 20

**Resultado:** true apenas se **ambas** as condições são verdadeiras.

### `in++;`
Se o valor está **dentro** do intervalo, incrementa o contador `in`.

**Processo:**
```
Antes:  in = 0
Após:   in = 1
```

### `else { out++; }`
Se o valor está **fora** do intervalo, incrementa o contador `out`.

---

## Exemplo passo a passo (N = 5)

```
N = 5 (vamos ler 5 valores)
in = 0, out = 0 (contadores iniciais)

Iteração 1: x = 14
  14 >= 10 && 14 <= 20 ? true
  in++ ? in = 1

Iteração 2: x = 123
  123 >= 10 && 123 <= 20 ? false
  out++ ? out = 1

Iteração 3: x = 10
  10 >= 10 && 10 <= 20 ? true
  in++ ? in = 2

Iteração 4: x = -25
  -25 >= 10 && -25 <= 20 ? false
  out++ ? out = 2

Iteração 5: x = 32
  32 >= 10 && 32 <= 20 ? false
  out++ ? out = 3

Resultado final: in = 2, out = 3
```

---

## Saída do programa

### `System.out.println("In: " + in);`
Imprime a quantidade de valores **dentro** do intervalo.

### `System.out.println("Out: " + out);`
Imprime a quantidade de valores **fora** do intervalo.

**Exemplo com entrada dada:**
```
In: 2
Out: 3
```

---

## Fluxo de execução completo

```
???????????????????????????????
? java IntervaloContagem      ?
???????????????????????????????
             ?
???????????????????????????????
? Lê: n = 5                   ?
? Inicializa: in = 0, out = 0 ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 0 (i < 5)          ?
? Lê: x = 14                  ?
? Teste: 14 em [10,20]? SIM   ?
? in++ ? in = 1               ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 1                  ?
? Lê: x = 123                 ?
? Teste: 123 em [10,20]? NÃO  ?
? out++ ? out = 1             ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 2                  ?
? Lê: x = 10                  ?
? Teste: 10 em [10,20]? SIM   ?
? in++ ? in = 2               ?
???????????????????????????????
             ?
        ... continua ...
             ?
???????????????????????????????
? FOR: i = 4 (último)         ?
? Lê: x = 32                  ?
? Teste: 32 em [10,20]? NÃO   ?
? out++ ? out = 3             ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 5 (5 < 5 ? false)  ?
? Sai do loop                 ?
???????????????????????????????
             ?
???????????????????????????????
? Imprime: In: 2              ?
? Imprime: Out: 3             ?
???????????????????????????????
             ?
???????????????????????????????
? Scanner fecha automaticamente?
???????????????????????????????
```

---

## Tabela de análise (entrada dada)

| Iteração | i | x | x >= 10? | x <= 20? | Ambas? | In | Out |
|----------|---|-------|----------|----------|--------|----|----|
| 1 | 0 | 14 | true | true | **true** | 1 | 0 |
| 2 | 1 | 123 | true | false | **false** | 1 | 1 |
| 3 | 2 | 10 | true | true | **true** | 2 | 1 |
| 4 | 3 | -25 | false | true | **false** | 2 | 2 |
| 5 | 4 | 32 | true | false | **false** | 2 | 3 |

**Resultado final:** In = 2, Out = 3 ?

---

## Outros exemplos

### Exemplo: N = 3, valores: 5, 15, 25

```
Iteração 1: x = 5
  5 >= 10 && 5 <= 20 ? false
  out++ ? out = 1

Iteração 2: x = 15
  15 >= 10 && 15 <= 20 ? true
  in++ ? in = 1

Iteração 3: x = 25
  25 >= 10 && 25 <= 20 ? false
  out++ ? out = 2

Resultado: In = 1, Out = 2
```

### Exemplo: N = 4, valores: 10, 15, 20, 25

```
Iteração 1: x = 10 ? in = 1
Iteração 2: x = 15 ? in = 2
Iteração 3: x = 20 ? in = 3
Iteração 4: x = 25 ? out = 1

Resultado: In = 3, Out = 1
```

---

## Operador de incremento: contador++

### Equivalência

```java
in++;      // equivalente a:
in = in + 1;
```

### Outros usos

```java
in += 5;   // incrementa 5: in = in + 5
out += 2;  // incrementa 2: out = out + 2
count--;   // decrementa: count = count - 1
```

---

## Intervalo [10,20]: inclusivo vs exclusivo

### [10,20] (colchetes = inclusivo)

```java
if (x >= 10 && x <= 20) {  // inclui 10 e 20
    // dentro
}
```

| Valor | Resultado |
|-------|-----------|
| 9.99 | fora |
| 10 | **dentro** ? |
| 15 | **dentro** ? |
| 20 | **dentro** ? |
| 20.01 | fora |

### (10,20) (parênteses = exclusivo)

```java
if (x > 10 && x < 20) {  // não inclui 10 nem 20
    // dentro
}
```

| Valor | Resultado |
|-------|-----------|
| 10 | fora |
| 15 | **dentro** ? |
| 20 | fora |

---

## Resumo dos conceitos

- **Loop FOR**: repete leitura N vezes
- **Contador**: variável que acumula valores
- **Incremento `++`**: aumenta 1 (`a++` = `a = a + 1`)
- **Intervalo [10,20]**: inclusivo (inclui ambos os extremos)
- **Operador AND (`&&`)**: ambas condições devem ser verdadeiras
- **Concatenação**: junta strings com valores (`"In: " + in`)

---

## Diferença com exercícios anteriores

| Exercício | Conceito |
|-----------|----------|
| 13 | FOR simples (imprime valores) |
| 14 (este) | **FOR com acúmulo (contador)** |

---

## Variações possíveis

### Contar quanto está fora (alternativa)

```java
if (x < 10 || x > 20) {  // fora do intervalo
    out++;
}
else {
    in++;
}
```

### Com intervalo configurável

```java
int min = 10;
int max = 20;

for (int i = 0; i < n; i++) {
    int x = sc.nextInt();
    
    if (x >= min && x <= max) {
        in++;
    }
    else {
        out++;
    }
}
```

### Com mensagens por valor

```java
for (int i = 0; i < n; i++) {
    int x = sc.nextInt();
    
    if (x >= 10 && x <= 20) {
        System.out.println(x + " - In");
        in++;
    }
    else {
        System.out.println(x + " - Out");
        out++;
    }
}
```

Saída:
```
14 - In
123 - Out
10 - In
-25 - Out
32 - Out
In: 2
Out: 3
```

---


## Visualização gráfica dos valores

Entrada:
```
14  ???????
    10   20  [10,20]

123 ????????????????????????
    10                    20  [10,20]

10  ???????
    10   20  [10,20]

-25 ?
    10   20  [10,20]

32     ????????????????????????
       10                    20  [10,20]
```

Resultado:
- In (dentro): 14, 10 ? 2
- Out (fora): 123, -25, 32 ? 3