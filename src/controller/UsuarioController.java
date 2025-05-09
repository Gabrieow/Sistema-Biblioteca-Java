package controller;

import model.Emprestimo;
import model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsuarioController {
    private List<Usuario> usuarios;
    private Scanner scanner;

    public UsuarioController() {
        this.usuarios = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void cadastrarUsuario() {
        System.out.println("=== Cadastrar Usuário ===\n\n");
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o telefone do usuário: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o endereço do usuário: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o email do usuário: ");
        String email = scanner.nextLine();

        Usuario usuario = new Usuario(nome, telefone, endereco, email);
        usuarios.add(usuario);
        System.out.println("\n\nUsuário cadastrado com sucesso!");
    }

    public Usuario buscarUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
        }
        System.out.println("Usuário não encontrado.");
        return null;
    }

    public void relatarDevolucoesAtrasadas(List<Emprestimo> emprestimos) {
        System.out.println("=== Relatório de Devoluções Atrasadas ===\n\n");
        boolean houveAtraso = false;


        for (Usuario usuario : usuarios) {
            List<Emprestimo> atrasosDoUsuario = new ArrayList<>();

            for (Emprestimo e : emprestimos) {
                if (e.getUsuario().getEmail().equals(usuario.getEmail()) && e.isAtrasado(java.time.LocalDate.now())) {
                    atrasosDoUsuario.add(e);
                }
            }

            if (!atrasosDoUsuario.isEmpty()) {
                houveAtraso = true;
                System.out.println("Usuário: " + usuario.getNome() + " (" + usuario.getEmail() + ")");
                for (Emprestimo e : atrasosDoUsuario) {
                    System.out.println("  - Livro: " + e.getLivro().getTitulo());
                    System.out.println("    Devolução prevista: " + e.getDataDevolucaoPrevista());
                    System.out.println("    Dias de atraso: " + java.time.temporal.ChronoUnit.DAYS.between(e.getDataDevolucaoPrevista(), java.time.LocalDate.now()));
                }
            }
        }

        if (!houveAtraso) {
            System.out.println("Nenhuma devolução atrasada encontrada.");
        }
    }
}