package view;

import java.util.Scanner;

import controller.LivroController;
import controller.UsuarioController;

public class MenuConsole {
    private Scanner scanner;
    LivroController livroController = new LivroController();
    UsuarioController usuarioController = new UsuarioController();

    public MenuConsole() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("=== Menu da Biblioteca ===");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Buscar Livro");
            System.out.println("3. Cadastrar Usuário");
            System.out.println("4. Emprestar Livro");
            System.out.println("5. Devolver Livro");
            System.out.println("6. Relatório de Atrasos");
            System.out.println("7. Gerar Relatório");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    livroController.cadastrarLivro();
                    break;

                case 2:
                    livroController.buscarLivroPorTitulo();
                    break;

                case 3:
                    usuarioController.cadastrarUsuario();
                    break;

                case 4:
                    // Chamar método para emprestar livro
                    break;

                case 5:
                    // Chamar método para devolver livro
                    break;

                case 6:
                    // Chamar método para relatório de atrasos
                    break;

                case 7:
                    // Chamar método para gerar relatório
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
}