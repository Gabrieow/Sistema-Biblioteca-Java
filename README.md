# Biblioteca MVC

Este projeto é uma aplicação de gerenciamento de biblioteca que segue o padrão MVC (Modelo-Visão-Controlador). Ele permite o registro de livros e usuários, o empréstimo e a devolução de livros, além de gerar relatórios sobre as operações realizadas.

## Estrutura do Projeto

A estrutura do projeto é a seguinte:

```
biblioteca-mvc
├── src
│   ├── controller
│   │   ├── LivroController.java
│   │   ├── UsuarioController.java
│   │   └── EmprestimoController.java
│   ├── model
│   │   ├── Livro.java
│   │   ├── Usuario.java
│   │   ├── Emprestimo.java
│   │   ├── Relatorio.java
│   │   └── PreCarregamentoDados.java
│   ├── view
│   │   └── MenuConsole.java
│   ├── interfaces
│   │   └── Organizador.java
│   └── Main.java
├── .vscode
│   ├── launch.json
│   └── settings.json
├── README.md
└── pom.xml
```

## Funcionalidades

- **Registro de Livros**: Permite adicionar novos livros ao sistema.
- **Busca de Livros**: Possibilita a pesquisa de livros cadastrados.
- **Registro de Usuários**: Permite adicionar novos usuários ao sistema.
- **Empréstimo de Livros**: Gerencia o empréstimo de livros para usuários.
- **Devolução de Livros**: Facilita a devolução de livros emprestados.
- **Controle de Atrasos**: Monitora devoluções em atraso e gera relatórios.
- **Geração de Relatórios**: Cria relatórios sobre livros emprestados, devoluções em atraso e livros mais populares.
- **Pré-Carregamento de Dados**: Carrega dados de teste para facilitar a utilização do sistema.

## Como Executar

1. Certifique-se de ter o Java e o Maven instalados em sua máquina.
2. Clone o repositório ou baixe os arquivos do projeto.
3. Navegue até o diretório do projeto no terminal.
4. Execute o comando `mvn clean install` para compilar o projeto.
5. Utilize o comando `mvn exec:java -Dexec.mainClass="Main"` para iniciar a aplicação.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests para melhorias e correções.

## Licença

Este projeto está licenciado sob a MIT License - veja o arquivo [LICENSE](LICENSE) para mais detalhes.