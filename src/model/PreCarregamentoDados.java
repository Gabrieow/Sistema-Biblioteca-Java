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
        // Carregar livros de exemplo
        livros.add(new Livro("Dom Casmurro", "Machado de Assis", 1899, 5));
        livros.add(new Livro("O Alquimista", "Paulo Coelho", 1988, 3));
        livros.add(new Livro("1984", "George Orwell", 1949, 4));

        // Carregar usuários de exemplo
        usuarios.add(new Usuario("João Silva", "123456789", "Rua A, 123", "joao@email.com"));
        usuarios.add(new Usuario("Maria Oliveira", "987654321", "Rua B, 456", "maria@email.com"));
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}