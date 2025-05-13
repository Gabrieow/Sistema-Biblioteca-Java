package model;

import java.util.Arrays;
import java.util.Comparator;

import interfaces.Organizador;

public class OrganizadorLivros implements Organizador<Livro> {

    @Override
    public void ordenarPorTitulo(Livro[] livros) {
        Arrays.sort(livros, Comparator.comparing(Livro::getTitulo));
    }

    @Override
    public void ordenarPorAutor(Livro[] livros) {
        Arrays.sort(livros, Comparator.comparing(Livro::getAutor));
    }

    @Override
    public void ordenarPorAnoPublicacao(Livro[] livros) {
        Arrays.sort(livros, Comparator.comparingInt(Livro::getAnoPublicacao));
    }
}
