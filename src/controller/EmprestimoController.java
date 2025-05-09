package controller;

import model.Emprestimo;
import model.Livro;
import model.Usuario;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoController {
    private List<Emprestimo> emprestimos;

    public EmprestimoController() {
        this.emprestimos = new ArrayList<>();
    }

    public void emprestarLivro(Livro livro, Usuario usuario) {
        if (livro.getExemplaresDisponiveis() > 0) {
            LocalDate dataEmprestimo = LocalDate.now();
            LocalDate dataDevolucao = calcularDataDevolucao();

            Emprestimo emprestimo = new Emprestimo(livro, usuario, dataEmprestimo, dataDevolucao);
            emprestimos.add(emprestimo);

            livro.setExemplaresDisponiveis(livro.getExemplaresDisponiveis() - 1);
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Não há exemplares disponíveis para empréstimo.");
        }
    }

    public void devolverLivro(Emprestimo emprestimo) {
        if (emprestimos.contains(emprestimo)) {
            emprestimos.remove(emprestimo);
            emprestimo.getLivro().setExemplaresDisponiveis(
                emprestimo.getLivro().getExemplaresDisponiveis() + 1
            );
            System.out.println("Devolução realizada com sucesso!");
        } else {
            System.out.println("Empréstimo não encontrado.");
        }
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimos;
    }

    public int calcularAtraso(Emprestimo emprestimo) {
        LocalDate dataAtual = LocalDate.now();
        if (dataAtual.isAfter(emprestimo.getDataDevolucaoPrevista())) {
            return (int) ChronoUnit.DAYS.between(emprestimo.getDataDevolucaoPrevista(), dataAtual);
        }
        return 0;
    }

    private LocalDate calcularDataDevolucao() {
        return LocalDate.now().plusDays(14);
    }
}
