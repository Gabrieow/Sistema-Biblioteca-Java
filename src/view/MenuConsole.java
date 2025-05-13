package view;

import java.util.Scanner;

import controller.LivroController;
import controller.UsuarioController;
import controller.EmprestimoController;
import model.Relatorio;

public class MenuConsole {
    private Scanner scanner;
    LivroController livroController = new LivroController();
    UsuarioController usuarioController = new UsuarioController();
    EmprestimoController emprestimoController = new EmprestimoController();
    Relatorio relatorio = new Relatorio(emprestimoController.listarEmprestimos());

    public MenuConsole() {
        this.scanner = new Scanner(System.in);
    }

    public MenuConsole(LivroController livroController, UsuarioController usuarioController, EmprestimoController emprestimoController) {
        this.scanner = new Scanner(System.in);
        this.livroController = livroController;
        this.usuarioController = usuarioController;
        this.emprestimoController = emprestimoController;
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Menu da Biblioteca ===");
            System.out.println("1. Cadastrar Novo Livro");
            System.out.println("2. Buscar Livro por Título");
            System.out.println("3. Cadastrar Novo Usuário");
            System.out.println("4. Realizar Empréstimo de Livro");
            System.out.println("5. Devolver Livro");
            System.out.println("6. Relatório de Devoluções Atrasadas");
            System.out.println("7. Gerar Relatório Completo");
            System.out.println("0. Sair");
            System.out.print("\nEscolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastrando novo livro... ---");
                    livroController.cadastrarLivro();
                    break;

                case 2:
                    System.out.println("\n--- Buscando livro por título... ---");
                    livroController.buscarLivroPorTitulo();
                    break;

                case 3:
                    System.out.println("\n--- Cadastrando novo usuário... ---");
                    usuarioController.cadastrarUsuario();
                    break;

                case 4:
                    System.out.println("\n--- Realizando empréstimo de livro... ---");
                    emprestimoController.realizarEmprestimo(scanner, livroController, usuarioController);
                    relatorio = new Relatorio(emprestimoController.listarEmprestimos());
                    break;

                case 5:
                    System.out.println("\n--- Processando devolução de livro... ---");
                    emprestimoController.realizarDevolucao(scanner, livroController, usuarioController);
                    break;

                case 6:
                    System.out.println("\n--- Gerando relatório de devoluções atrasadas... ---");
                    usuarioController.relatarDevolucoesAtrasadas(emprestimoController.listarEmprestimos());
                    break;

                case 7:
                    System.out.println("\n--- Gerando relatório completo... ---");
                    relatorio.gerarRelatorioUsuarios(usuarioController.getUsuarios());
                    relatorio.gerarRelatorioEmprestimos();
                    relatorio.gerarRelatorioAtrasos();
                    relatorio.gerarRelatorioLivrosOrdenadosPorTitulo(livroController.getLivros());
                    relatorio.gerarRelatorioLivrosOrdenadosPorAutor(livroController.getLivros());
                    relatorio.gerarRelatorioLivrosOrdenadosPorAno(livroController.getLivros());
                    break;

                case 0:
                    System.out.println("\n--- Saindo do sistema... ---");
                    break;

                default:
                    System.out.println("\n!!! Opção inválida, Tente novamente. !!!");
            }
        } while (opcao != 0);
    }
}
