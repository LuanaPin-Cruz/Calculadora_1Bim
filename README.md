# 🧮 Calculadora Android (Kotlin)

Projeto de uma calculadora simples desenvolvida em **Kotlin** no Android Studio, com foco em lógica de programação e manipulação de expressões matemáticas respeitando a **ordem de precedência**.

---

## 📱 Funcionalidades

✔ Inserção de números (0–9)
✔ Operações básicas:

* Soma (+)
* Subtração (-)
* Multiplicação (*)
* Divisão (/)

✔ Respeita a ordem matemática:

* Primeiro `*` e `/`
* Depois `+` e `-`

✔ Interface semelhante a uma calculadora real:

* Números aparecem à direita
* Crescem para a esquerda
* Tela limpa ao inserir operador

---

## 🧠 Exemplo de funcionamento

Entrada do usuário:

```
4 + 2 * 3
```

Processamento:

```
2 * 3 = 6
4 + 6 = 10
```

Saída exibida:

```
10
```

---

## 🛠 Tecnologias utilizadas

* Kotlin
* Android Studio
* XML (layouts)

---

## 📂 Estrutura do projeto

```
app/
 ├── java/com/seu_pacote/
 │    └── MainActivity.kt
 └── res/layout/
      └── activity_main.xml
```

---

## ⚙️ Como funciona a lógica

A expressão digitada é armazenada como uma `String` e processada em duas etapas:

1. Percorre a string resolvendo `*` e `/`
2. Depois resolve `+` e `-`

Utiliza:

* `substring()` para separar números
* `while` para percorrer a expressão
* substituição de partes da string pelo resultado parcial

---

## 🚀 Melhorias futuras

* Botão "C" (clear) e "CE"
* Mostrar histórico da operação
* Melhorar interface (UI/UX)

---

## 🎯 Objetivo

Projeto criado com o objetivo de praticar:

* Lógica de programação
* Manipulação de Strings
* Desenvolvimento Android
* Organização de código

---

## 👩‍💻 Autora

Ernany Victor Fernandes, Luana Pinheiro Cruz e Nicollas de Souza Vicente

---

## 📌 Observação

Este projeto não utiliza bibliotecas externas para cálculo, toda a lógica foi implementada manualmente para fins de aprendizado.

---
