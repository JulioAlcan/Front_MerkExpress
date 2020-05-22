
import br.senac.sp.dao.produtoDAO;
import br.senac.sp.model.produto;
import java.util.List;

public class TesteProduto {

    public static void main(String[] args)  {
        // testeBuscaTodos();
        //testCadastrar();
        //  testeBuscaCodigo();
        //Pesquisa();
        testeAlteraVenda();
    }

    public static void testeBuscaTodos() {
        produtoDAO prodDAO = new produtoDAO();
        List<produto> lista = prodDAO.pegaTodos();
        for (produto u : lista) {
            System.out.println(u);
        }
    }

  /* public static void testCadastrar() {
        produto user = new produto();
        user.setNome("Arroz");
        user.setCodigo("1");
        user.setCategoria("Alimento");
        user.setQtd(5);
        user.setPreco(8.00);
        user.setId(1);
        produtoDAO usuDAO = new produtoDAO();
        usuDAO.cadastrar(user);
        System.out.println("Cadastrado com sucesso !");
    }*/

    public static void testeBuscaCodigo() {
        produtoDAO prodDAO = new produtoDAO();
        List<produto> prod = prodDAO.buscaPorPesquisa("1");
        System.out.println(prod);

    }
    public static void Pesquisa() {
        produtoDAO prodDAO = new produtoDAO();
        List<produto> lista = prodDAO.buscaPorPesquisa("Arr");
        for (produto u : lista) {
            System.out.println(u);
        }
    }
    public static void testeAlteraVenda(){
        produtoDAO pdao = new produtoDAO();
        pdao.alteraVenda(5,"32564123574");
    
    }
    
    
}
