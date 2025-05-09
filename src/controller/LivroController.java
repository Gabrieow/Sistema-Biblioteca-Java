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
        System.out.println("=== Cadastrar Livro ===\n\n");
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

        System.out.println("\n\nLivro cadastrado com sucesso!");
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
        System.out.println("=== Buscar Livro ===\n");
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
    
        Livro livro = buscarLivro(titulo);
        if (livro != null) {
            System.out.println("\n== Livro encontrado == \nTítulo: " + livro.getTitulo() + "\nAutor: " + livro.getAutor() + "\nAno: " + livro.getAnoPublicacao() + "\nExemplares disponíveis: " + livro.getExemplaresDisponiveis() + "\n");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }
    

    public List<Livro> listarLivros() {
        return livros;
    }

    public void gerarRelatorio() {
        System.out.println("Relatório de Livros:");
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }
}