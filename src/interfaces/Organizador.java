package interfaces;

public interface Organizador<T> {
    void ordenarPorTitulo(T[] itens);
    void ordenarPorAutor(T[] itens);
    void ordenarPorAnoPublicacao(T[] itens);
}