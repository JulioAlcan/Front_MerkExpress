
import br.senac.sp.dao.ClienteDAO;
import br.senac.sp.model.Cliente;
import java.util.List;

public class TesteCliente {

    public static void main(String[] args) {
        //testePegaTodos();
        testeCadastrar();
    }

    public static void testeBuscaTodos() {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> lista = dao.BuscaCliente("36492912829");
        for (Cliente cliente : lista) {
            System.out.println(cliente);
        }
    }

    public static void testePegaTodos() {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> lista = dao.pegaTodos();
        for (Cliente cliente : lista) {
            System.out.println(cliente);
        }
    }

    public static void testeCadastrar() {
        ClienteDAO dao = new ClienteDAO();
        dao.cadastrar("r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r");
    }

}
