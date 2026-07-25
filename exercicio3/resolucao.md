# Explicação do Programa: Cálculo de Média Ponderada

## Código atual

```java
import java.util.Scanner;

public class MediaPonderada {
    
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            
            for (int i = 0; i < n; i++) {
                double a = sc.nextDouble();
                double b = sc.nextDouble();
                double c = sc.nextDouble();
                
                double media = (a * 2.0 + b * 3.0 + c * 5.0) / 10.0;
                
                System.out.printf("%.1f%n", media);
            }
        }
    }
}
```

---

## Análise linha por linha

### `import java.util.Scanner;`
Importa a classe `Scanner` do pacote `java.util`. Necessária para ler dados da entrada (teclado).

### `public class MediaPonderada {`
Define a classe `MediaPonderada`. O arquivo deve se chamar `MediaPonderada.java`.

### `public static void main(String[] args) {`
Método principal, ponto de entrada da aplicação.

### `try (Scanner sc = new Scanner(System.in)) {`
Cria um Scanner chamado `sc`, apontando para a entrada padrão (teclado).

Usa `try-with-resources` para garantir fechamento automático do Scanner.

### `int n = sc.nextInt();`
Lê a **quantidade de casos de teste**.

**Exemplo:** `n = 3` significa que vamos ler 3 conjuntos de 3 valores cada.

---

## ?? Conceito: Média Ponderada

### O que é média ponderada?

**Média ponderada** é uma média onde cada valor tem um **peso (importância)** diferente.

**Fórmula geral:**
```
Média Ponderada = (valor1 × peso1 + valor2 × peso2 + ... + valorN × pesoN) / (peso1 + peso2 + ... + pesoN)
```

### Neste exercício

| Valor | Peso |
|-------|------|
| a (primeiro) | 2 |
| b (segundo) | 3 |
| c (terceiro) | 5 |

**Fórmula específica:**
```
Média = (a × 2 + b × 3 + c × 5) / (2 + 3 + 5)
Média = (a × 2 + b × 3 + c × 5) / 10
```

### Exemplo numérico

**Valores:** a = 6.5, b = 4.3, c = 6.2

```
Média = (6.5 × 2 + 4.3 × 3 + 6.2 × 5) / 10
Média = (13 + 12.9 + 31) / 10
Média = 56.9 / 10
Média = 5.69
```

---

## Loop FOR com múltiplas leituras

### `for (int i = 0; i < n; i++) {`
Repete `n` vezes (para cada caso de teste).

**Exemplo:** Se `n = 3`, o loop executa 3 vezes (i = 0, 1, 2).

---

## Leitura dos 3 valores

### `double a = sc.nextDouble();`
Lê o **primeiro valor real** (com casas decimais).

### `double b = sc.nextDouble();`
Lê o **segundo valor real**.

### `double c = sc.nextDouble();`
Lê o **terceiro valor real**.

**Fluxo (primeira iteração):**
```
Lê: a = 6.5
Lê: b = 4.3
Lê: c = 6.2
```

---

## Cálculo da média ponderada

### `double media = (a * 2.0 + b * 3.0 + c * 5.0) / 10.0;`

Quebra em partes:

| Parte | Cálculo | Exemplo |
|-------|---------|---------|
| `a * 2.0` | Primeiro valor × peso 2 | 6.5 × 2 = 13 |
| `b * 3.0` | Segundo valor × peso 3 | 4.3 × 3 = 12.9 |
| `c * 5.0` | Terceiro valor × peso 5 | 6.2 × 5 = 31 |
| `(... + ... + ...)` | Soma de todos | 13 + 12.9 + 31 = 56.9 |
| `/ 10.0` | Divide pela soma de pesos | 56.9 / 10 = 5.69 |

**?? Importante:** Usar `2.0`, `3.0`, `5.0`, `10.0` (com ponto decimal) garante **divisão com ponto flutuante** e mantém as casas decimais.

---

## Formatação da saída

### `System.out.printf("%.1f%n", media);`

| Elemento | Explicação |
|----------|-----------|
| `System.out` | saída padrão |
| `printf(...)` | print formatted |
| `"%.1f%n"` | formato |
| `%.1f` | **1 casa decimal** |
| `%n` | quebra de linha |
| `, media` | valor a inserir |

**Exemplo:**
- `5.69` ? imprime `5.7` (arredonda para 1 casa)
- `6.33` ? imprime `6.3`
- `9.30` ? imprime `9.3`

---

## Exemplo completo de execução (entrada dada)

```
N = 3 (3 casos de teste)

CASO 1:
a = 6.5, b = 4.3, c = 6.2
media = (6.5×2 + 4.3×3 + 6.2×5) / 10
media = (13 + 12.9 + 31) / 10
media = 56.9 / 10 = 5.69
Imprime: 5.7

CASO 2:
a = 5.1, b = 4.2, c = 8.1
media = (5.1×2 + 4.2×3 + 8.1×5) / 10
media = (10.2 + 12.6 + 40.5) / 10
media = 63.3 / 10 = 6.33
Imprime: 6.3

CASO 3:
a = 8.0, b = 9.0, c = 10.0
media = (8.0×2 + 9.0×3 + 10.0×5) / 10
media = (16 + 27 + 50) / 10
media = 93 / 10 = 9.30
Imprime: 9.3
```

**Saída final:**
```
5.7
6.3
9.3
```

---

## Fluxo de execução completo

```
???????????????????????????????
? java MediaPonderada         ?
???????????????????????????????
             ?
???????????????????????????????
? Lê: n = 3                   ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 0 (i < 3)          ?
? Lê: a = 6.5, b = 4.3, c = 6.2 ?
? Calcula media = 5.69        ?
? Imprime: 5.7                ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 1                  ?
? Lê: a = 5.1, b = 4.2, c = 8.1 ?
? Calcula media = 6.33        ?
? Imprime: 6.3                ?
???????????????????????????????
             ?
???????????????????????????????
? FOR: i = 2 (último)         ?
? Lê: a = 8.0, b = 9.0, c = 10.0 ?
? Calcula media = 9.30        ?
? Imprime: 9.3                ?
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

| Caso | a | b | c | a×2 | b×3 | c×5 | Soma | Média | Impresso |
|------|-------|-------|--------|--------|--------|--------|--------|--------|----------|
| 1 | 6.5 | 4.3 | 6.2 | 13 | 12.9 | 31 | 56.9 | 5.69 | 5.7 |
| 2 | 5.1 | 4.2 | 8.1 | 10.2 | 12.6 | 40.5 | 63.3 | 6.33 | 6.3 |
| 3 | 8.0 | 9.0 | 10.0 | 16 | 27 | 50 | 93 | 9.30 | 9.3 |

---

## Diferença: Média Aritmética vs Ponderada

### Média Aritmética

```java
double media = (a + b + c) / 3.0;
```

Todos os valores têm peso igual (1).

**Exemplo:** (6.5 + 4.3 + 6.2) / 3 = 17 / 3 = 5.67

### Média Ponderada

```java
double media = (a * 2.0 + b * 3.0 + c * 5.0) / 10.0;
```

Valores têm pesos diferentes (2, 3, 5).

**Exemplo:** (6.5×2 + 4.3×3 + 6.2×5) / 10 = 56.9 / 10 = 5.69

**Diferença:** 5.67 vs 5.69 (valor com peso maior tem mais influência)

---

## Por que usar double com ponto decimal?

### ? Sem ponto decimal (errado)

```java
double media = (a * 2 + b * 3 + c * 5) / 10;
```

Não garante divisão decimal em todos os casos.

### ? Com ponto decimal (correto)

```java
double media = (a * 2.0 + b * 3.0 + c * 5.0) / 10.0;
```

Força **divisão em ponto flutuante**, mantendo precisão.

---

## Resumo dos conceitos

- **Média ponderada**: média onde cada valor tem peso diferente
- **Fórmula**: (valor1×peso1 + valor2×peso2 + ...) / (soma dos pesos)
- **Pesos neste exercício**: 2, 3, 5 (soma = 10)
- **double**: tipo para números decimais
- **Usar `.0` em divisões**: garante resultado com casas decimais
- **`%.1f`**: formata com 1 casa decimal
- **Loop FOR com leitura múltipla**: repete para cada caso de teste

---

## Outros exemplos

### Exemplo: N = 2, valores: 10.0, 10.0, 10.0 e 5.0, 10.0, 15.0

```
CASO 1:
a = 10.0, b = 10.0, c = 10.0
media = (10×2 + 10×3 + 10×5) / 10 = (20 + 30 + 50) / 10 = 100 / 10 = 10.0
Imprime: 10.0

CASO 2:
a = 5.0, b = 10.0, c = 15.0
media = (5×2 + 10×3 + 15×5) / 10 = (10 + 30 + 75) / 10 = 115 / 10 = 11.5
Imprime: 11.5
```

---

## Variações possíveis

### Com pesos configuráveis

```java
double peso1 = 2.0;
double peso2 = 3.0;
double peso3 = 5.0;
double somaPesos = peso1 + peso2 + peso3;

for (int i = 0; i < n; i++) {
    double a = sc.nextDouble();
    double b = sc.nextDouble();
    double c = sc.nextDouble();
    
    double media = (a * peso1 + b * peso2 + c * peso3) / somaPesos;
    System.out.printf("%.1f%n", media);
}
```

### Com 2 casas decimais

```java
System.out.printf("%.2f%n", media);  // 5.69
```

### Com nome da média

```java
System.out.printf("Media ponderada: %.1f%n", media);
```

---


## Visualização da ponderação

```
Valor A = 6.5, Peso 2
??

Valor B = 4.3, Peso 3
???

Valor C = 6.2, Peso 5
?????

Total de pesos = 10 unidades
Media = soma ponderada / total de pesos
```

Quanto maior o peso, maior a influência do valor na média!