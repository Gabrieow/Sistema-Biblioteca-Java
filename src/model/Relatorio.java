package model;

import java.util.List;

public class Relatorio {
    private List<Emprestimo> emprestimos;

    public Relatorio(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public void gerarRelatorioEmprestimos() {
        System.out.println("Relatório de Empréstimos:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo.toString());
        }
    }

    public void gerarRelatorioAtrasos() {
        System.out.println("Relatório de Atrasos:");
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.isAtrasado(java.time.LocalDate.now())) {
                System.out.println(emprestimo.toString());
            }
        }
    }

    public void gerarRelatorioLivrosPopulares() {
        // Implementar lógica para gerar relatório de livros mais emprestados
        System.out.println("Relatório de Livros Populares: (Implementar lógica)");
    }
}