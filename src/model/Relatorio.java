package model;

import java.util.List;
import interfaces.Organizador;

public class Relatorio {
    private List<Emprestimo> emprestimos;

    public Relatorio(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public void gerarRelatorioEmprestimos() {
        System.out.println("\n===== Relatório de Empréstimos =====");
        if (emprestimos.isEmpty()) {
            System.out.println("Não há empréstimos registrados.");
        } else {
            for (Emprestimo emprestimo : emprestimos) {
                System.out.println(emprestimo);
            }
        }
    }

    public void gerarRelatorioAtrasos() {
        System.out.println("\n===== Relatório de Atrasos =====");
        boolean encontrouAtraso = false;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.isAtrasado(java.time.LocalDate.now())) {
                System.out.println(emprestimo);
                encontrouAtraso = true;
            }
        }
        if (!encontrouAtraso) {
            System.out.println("Não há empréstimos em atraso.");
        }
    }

    public void gerarRelatorioUsuarios(List<Usuario> usuarios) {
        if (usuarios.isEmpty()) {
            System.out.println("\nNão há usuários cadastrados.");
            return;
        }

        System.out.println("\n===== Relatório de Usuários Cadastrados =====");
        for (Usuario usuario : usuarios) {
            System.out.println("\nNome: " + usuario.getNome());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Telefone: " + usuario.getTelefone());
            System.out.println("Endereço: " + usuario.getEndereco());
            System.out.println("Livros Emprestados:");

            boolean encontrouLivros = false;
            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo.getUsuario().equals(usuario)) {
                    System.out.println("  - " + emprestimo.getLivro().getTitulo());
                    encontrouLivros = true;
                }
            }
            if (!encontrouLivros) {
                System.out.println("  Nenhum livro emprestado.");
            }
            System.out.println("\n--------------------------------------------");
        }
    }

    public void gerarRelatorioLivrosOrdenadosPorTitulo(List<Livro> livros) {
        Organizador<Livro> organizador = new OrganizadorLivros();
        Livro[] livrosArray = livros.toArray(new Livro[0]);
        organizador.ordenarPorTitulo(livrosArray);

        System.out.println("\n===== Relatório de Livros Ordenados por Título =====");
        if (livrosArray.length == 0) {
            System.out.println("Não há livros cadastrados.");
        } else {
            for (Livro livro : livrosArray) {
                System.out.println(livro);
            }
        }
    }

    public void gerarRelatorioLivrosOrdenadosPorAutor(List<Livro> livros) {
        Organizador<Livro> organizador = new OrganizadorLivros();
        Livro[] livrosArray = livros.toArray(new Livro[0]);
        organizador.ordenarPorAutor(livrosArray);

        System.out.println("\n===== Relatório de Livros Ordenados por Autor =====");
        if (livrosArray.length == 0) {
            System.out.println("Não há livros cadastrados.");
        } else {
            for (Livro livro : livrosArray) {
                System.out.println(livro);
            }
        }
    }

    public void gerarRelatorioLivrosOrdenadosPorAno(List<Livro> livros) {
        Organizador<Livro> organizador = new OrganizadorLivros();
        Livro[] livrosArray = livros.toArray(new Livro[0]);
        organizador.ordenarPorAnoPublicacao(livrosArray);

        System.out.println("\n===== Relatório de Livros Ordenados por Ano de Publicação =====");
        if (livrosArray.length == 0) {
            System.out.println("Não há livros cadastrados.");
        } else {
            for (Livro livro : livrosArray) {
                System.out.println(livro);
            }
        }
    }
}
