package controller;

import model.Emprestimo;
import model.Livro;
import model.Relatorio;
import model.Usuario;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmprestimoController {
    protected List<Emprestimo> emprestimos;
    private Relatorio relatorio;

    public EmprestimoController() {
        this.emprestimos = new ArrayList<>();
        this.relatorio = new Relatorio(emprestimos);
    }

    public void emprestarLivro(Livro livro, Usuario usuario) {
        if (livro.getExemplaresDisponiveis() > 0) {
            LocalDate dataEmprestimo = LocalDate.now();
            LocalDate dataDevolucao = calcularDataDevolucao();

            Emprestimo emprestimo = new Emprestimo(livro, usuario, dataEmprestimo, dataDevolucao);
            emprestimos.add(emprestimo);
            livro.setExemplaresDisponiveis(livro.getExemplaresDisponiveis() - 1);

            long diasParaDevolver = ChronoUnit.DAYS.between(dataEmprestimo, dataDevolucao);
            System.out.println("\n--- Empréstimo realizado com sucesso! ---");
            System.out.println("Você tem " + diasParaDevolver + " dias para devolver o livro.");


            this.relatorio = new Relatorio(emprestimos);
        } else {
            System.out.println("\n!!! Não há exemplares disponíveis para empréstimo no momento.");
        }
    }

    public void devolverLivro(Emprestimo emprestimo) {
        if (emprestimos.contains(emprestimo)) {
            emprestimos.remove(emprestimo);
            emprestimo.getLivro().setExemplaresDisponiveis(emprestimo.getLivro().getExemplaresDisponiveis() + 1);
            System.out.println("\n--- Devolução realizada com sucesso! ---");
        } else {
            System.out.println("\n!!! Empréstimo não encontrado. Não foi possível realizar a devolução.");
        }
    }

    public void realizarEmprestimo(Scanner scanner, LivroController livroController, UsuarioController usuarioController) {
        Livro livroObj;
        Usuario usuarioObj;

        System.out.println("\nDigite o nome do livro desejado:");
        while (true) {
            String livro = scanner.nextLine();
            livroObj = livroController.buscarLivro(livro);

            if (livroObj != null) {
                break;
            } else {
                System.out.println("Livro não encontrado. Tente novamente:");
            }
        }

        System.out.println("\nDigite o nome do usuário que está realizando o empréstimo:");
        while (true) {
            String usuario = scanner.nextLine();
            usuarioObj = usuarioController.buscarUsuario(usuario);

            if (usuarioObj != null) {
                break;
            } else {
                System.out.println("Usuário não encontrado. Tente novamente:");
            }
        }

        emprestarLivro(livroObj, usuarioObj);
        relatorio.gerarRelatorioEmprestimos();
    }

    public void realizarDevolucao(Scanner scanner, LivroController livroController, UsuarioController usuarioController) {
        System.out.println("\nDigite o nome do livro para devolução:");
        Livro livroParaDevolver = null;

        while (true) {
            String nomeLivro = scanner.nextLine();
            livroParaDevolver = livroController.buscarLivro(nomeLivro);

            if (livroParaDevolver != null) {
                break;
            } else {
                System.out.println("Livro não encontrado. Tente novamente:");
            }
        }

        System.out.println("\nDigite o nome do usuário que está devolvendo o livro:");
        Usuario usuarioParaDevolver = null;

        while (true) {
            String nomeUsuario = scanner.nextLine();
            usuarioParaDevolver = usuarioController.buscarUsuario(nomeUsuario);

            if (usuarioParaDevolver != null) {
                break;
            } else {
                System.out.println("Usuário não encontrado. Tente novamente:");
            }
        }

        Emprestimo emprestimoEncontrado = null;

        for (Emprestimo e : listarEmprestimos()) {
            if (e.getLivro().equals(livroParaDevolver) && e.getUsuario().equals(usuarioParaDevolver)) {
                emprestimoEncontrado = e;
                break;
            }
        }

        if (emprestimoEncontrado != null) {
            devolverLivro(emprestimoEncontrado);
        } else {
            System.out.println("\n!!! Este livro não está emprestado para o usuário " + usuarioParaDevolver.getNome() + ".");
        }
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimos;
    }

    public int calcularAtraso(Emprestimo emprestimo) {
        LocalDate dataAtual = LocalDate.now();
        if (dataAtual.isAfter(emprestimo.getDataDevolucaoPrevista())) {
            return (int) ChronoUnit.DAYS.between(emprestimo.getDataDevolucaoPrevista(), dataAtual);
        }
        return 0;
    }

    private LocalDate calcularDataDevolucao() {
        return LocalDate.now().plusDays(14);
    }
}
