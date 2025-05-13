// Gabriel Henrique Vaz dos Santos RGM: 37340611 & Vinicius Mulling RGM: 37996622

import model.PreCarregamentoDados;
import view.MenuConsole;
import controller.LivroController;
import controller.UsuarioController;
import controller.EmprestimoController;

public class App {
    public static void main(String[] args) throws Exception {

        PreCarregamentoDados dados = new PreCarregamentoDados();
        LivroController livroController = new LivroController();
        UsuarioController usuarioController = new UsuarioController();
        EmprestimoController emprestimoController = new EmprestimoController();
        MenuConsole menu = new MenuConsole(livroController, usuarioController, emprestimoController);

        livroController.setLivros(dados.getLivros());
        usuarioController.setUsuarios(dados.getUsuarios());

        menu.exibirMenu();
    }
}

// Professor, vou deixar aqui o nome de 2 livros e 2 usuários que foram pré-cadastrados para facilitar a visualização e consulta aqui no console:

// Livros:
// 1. O Chamado de Cthulhu
// 2. O Corvo

// Usuários:
// 1. Carlos Souza
// 2. Ana Silva