package controller;

import model.Livro;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LivroController {
    private List<Livro> livros;
    private Scanner scanner = new Scanner(System.in);

    public LivroController() {
        this.livros = new ArrayList<>();
    }

    public void cadastrarLivro() {
        System.out.println("\n=== Cadastro de Novo Livro ===\n");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano de publicação: ");
        int ano = Integer.parseInt(scanner.nextLine());
        System.out.print("Quantidade de exemplares: ");
        int qtd = Integer.parseInt(scanner.nextLine());

        Livro livro = new Livro(titulo, autor, ano, qtd);
        livros.add(livro);

        System.out.println("\n--- Livro cadastrado com sucesso! ---");
    }

    public Livro buscarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public void buscarLivroPorTitulo() {
        System.out.println("\n=== Buscar Livro por Título ===\n");
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
    
        Livro livro = buscarLivro(titulo);
        if (livro != null) {
            System.out.println("\n--- Livro encontrado: ---");
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Ano de publicação: " + livro.getAnoPublicacao());
            System.out.println("Exemplares disponíveis: " + livro.getExemplaresDisponiveis());
            System.out.println();
        } else {
            System.out.println("\n!!! Livro não encontrado. Tente novamente.");
        }
    }

    public void gerarRelatorio() {
        if (livros.isEmpty()) {
            System.out.println("\nNão há livros cadastrados no momento.");
        } else {
            System.out.println("\n=== Relatório de Livros Cadastrados ===");
            for (Livro livro : livros) {
                System.out.println("\n- Título: " + livro.getTitulo());
                System.out.println("  Autor: " + livro.getAutor());
                System.out.println("  Ano de publicação: " + livro.getAnoPublicacao());
                System.out.println("  Exemplares disponíveis: " + livro.getExemplaresDisponiveis());
            }
        }
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Livro> getLivros() {
        return livros;
    }
}
