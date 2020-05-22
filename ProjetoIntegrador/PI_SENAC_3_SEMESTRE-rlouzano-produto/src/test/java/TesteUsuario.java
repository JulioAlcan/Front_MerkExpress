
import br.senac.sp.dao.usuarioDAO;
import br.senac.sp.model.Usuario;
import java.sql.SQLException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rafae
 */
public class TesteUsuario {

    public static void main(String[] args) throws SQLException {
       //testCadastrar();
        //testExcluir();
        //testSalvar();
        testeBuscaId();
     //   testeBuscaTodos();
     //  testAutenticar();
    }

   /* public static void testAlterar() throws SQLException {
        Usuario user = new Usuario();
        user.setNome("Rafael louzano");
        user.setLogin("rlouzano");
        user.setSenha("123");
        user.setId(2);
        usuarioDAO usuDAO = new usuarioDAO();
        usuDAO.alterar(user);

        System.out.println("Alterado com sucesso !");
    }*/

 /*   public static void testCadastrar() {
        Usuario user = new Usuario();
        user.setNome("SANDRO OLIVEIRA");
        user.setCpf("325856413");
        user.setFilial("CDSP");
        user.setPerfil("Admin");
        user.setLogin("soliveira");
        user.setSenha("123");
        user.setSenhaAdmin("123");
        usuarioDAO usuDAO = new usuarioDAO();
        usuDAO.cadastrar(user);

        System.out.println("Cadastrado com sucesso !");
    }*/
/*
    public static void testExcluir() {
        Usuario user = new Usuario();
        user.setId(1);
        usuarioDAO usuDAO = new usuarioDAO();
        usuDAO.excluir(user);

        System.out.println("Excluido com sucesso !");
    }*/

   /* public static void testSalvar() {
        Usuario user = new Usuario();
        user.setId(2);
        user.setNome("Rafael Louzano");
        user.setLogin("rlouzano");
        user.setSenha("123");
        usuarioDAO usuDAO = new usuarioDAO();
        usuDAO.salvar(user);

        System.out.println("Salvo com sucesso");
    }*/

    public static void testeBuscaId() {
        usuarioDAO usuDAO = new usuarioDAO();
        Usuario user = usuDAO.buscaPoId(1);
        System.out.println(user);

    }

    public static void testeBuscaTodos() {
        usuarioDAO usuDAO = new usuarioDAO();
        List<Usuario> lista = usuDAO.buscaTodos();
        for (Usuario u : lista) {
            System.out.println(u);
        }
    }

    public static void testAutenticar() {
        usuarioDAO userDAO = new usuarioDAO();
        Usuario user = new Usuario();
        user.setLogin("rlouzano");
        user.setSenha("123");

        Usuario usuRetorno = userDAO.autenticar(user);
        System.out.println(usuRetorno);

    }
}
