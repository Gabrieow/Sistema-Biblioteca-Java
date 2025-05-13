# Sistema de Biblioteca em Java

Um projeto simples de sistema de gerenciamento de biblioteca desenvolvido em Java com fins didáticos. O sistema permite o cadastro de livros e usuários, realização de empréstimos e devoluções, além da geração de relatórios sobre o acervo e os empréstimos.

---

## Funcionalidades

- **Cadastro de livros** com título, autor, ano de publicação e número de exemplares.
- **Cadastro de usuários** com nome, telefone, endereço e e-mail.
- **Empréstimo e devolução de livros** com controle de disponibilidade.
- **Controle de devoluções atrasadas** com cálculo automático de dias de atraso.
- **Geração de relatórios**:
  - Usuários cadastrados
  - Empréstimos ativos
  - Empréstimos em atraso
  - Livros ordenados por título, autor e ano de publicação

---

##  Tecnologias Utilizadas

- **Java 11+**
- **Paradigma de Programação Orientada a Objetos (POO)**
- Entrada e saída via **terminal (console)** usando `Scanner`

---

## Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/Gabrieow/Sistema-Biblioteca-Java
```

2. Compile os arquivos .java:

```bash
javac src/**/*.java
```

3. Execute o programa no arquivo principal:

```bash
java App
```

---

## Observações

- O sistema não utiliza banco de dados: os dados são armazenados temporariamente em listas (ArrayList) durante a execução.
- Todos os relatórios são exibidos diretamente no terminal.
- Não há persistência de dados entre execuções.