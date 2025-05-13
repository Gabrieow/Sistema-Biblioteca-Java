package model;

public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int exemplaresDisponiveis;

    public Livro(String titulo, String autor, int anoPublicacao, int exemplaresDisponiveis) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    public void setExemplaresDisponiveis(int exemplaresDisponiveis) {
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }

    public void emprestar() {
        if (exemplaresDisponiveis > 0) {
            exemplaresDisponiveis--;
        } else {
            throw new RuntimeException("Não há exemplares disponíveis para empréstimo.");
        }
    }

    public void devolver() {
        exemplaresDisponiveis++;
    }

    @Override
    public String toString() {
        return "\nTítulo: " + titulo + 
        "\nAutor: " + autor + 
        "\nAno de Publicação: " + anoPublicacao + 
        "\nExemplares Disponíveis: " + exemplaresDisponiveis + "\n";
    }
}