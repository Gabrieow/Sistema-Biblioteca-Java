package model;

import java.util.ArrayList;
import java.util.List;

public class PreCarregamentoDados {

    private List<Livro> livros;
    private List<Usuario> usuarios;

    public PreCarregamentoDados() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
        carregarDados();
    }

    private void carregarDados() {
        livros.add(new Livro("O Chamado de Cthulhu", "H.P. Lovecraft", 1928, 5));
        livros.add(new Livro("Nas Montanhas da Loucura", "H.P. Lovecraft", 1931, 3));
        livros.add(new Livro("O Corvo", "Edgar Allan Poe", 1845, 4));
        livros.add(new Livro("O Gato Preto", "Edgar Allan Poe", 1843, 6));
        livros.add(new Livro("A Sombra sobre Innsmouth", "H.P. Lovecraft", 1936, 2));

        usuarios.add(new Usuario("Carlos Souza", "123456789", "Rua das Flores, 123", "carlos.souza@email.com"));
        usuarios.add(new Usuario("Ana Silva", "987654321", "Avenida Central, 456", "ana.silva@email.com"));
        usuarios.add(new Usuario("Lucas Almeida", "456789123", "Travessa do Sol, 789", "lucas.almeida@email.com"));
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}