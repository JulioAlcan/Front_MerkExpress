
import br.senac.sp.dao.RelatorioDAO;
import br.senac.sp.model.Relatorio;
import br.senac.sp.model.Usuario;
import java.time.LocalDateTime;
import java.util.List;

public class TesteRelatorio {

    public static void main(String[] args) {
        //testeCadastrar();
        testeBuscaTodosAnalitico();
        //testeBuscaTodos();

    }

    public static void testeCadastrar() {
        Usuario u = new Usuario();
        RelatorioDAO rdao = new RelatorioDAO();
        Relatorio re = new Relatorio();
        RelatorioDAO rd = new RelatorioDAO();
        re.setNomeproduto("Arroz");
        re.setCodigoproduto("123");
        re.setCategoria("Alimento");
        re.setQtd_vendido(1);
        re.setPreco_unitario(5.50);
        re.setPreco_total(11.00);
        // re.setIdCliente(2);
        re.setLocalDateTime(LocalDateTime.MIN);
        re.setUsuario("rlouzano");
        re.setNomeCliente("Francisco");
        re.setCpfCliente("1435431");
        re.setNomefilial("CDSP");
        re.setFormPagto("Dinheiro");
        // re.setIdfilial(1);
        //rd.cadastrarVenda(re);

        System.out.println(re.getNomeproduto());
        System.out.println(re.getCodigoproduto());
        System.out.println(re.getCategoria());
        System.out.println(re.getQtd_vendido());
        System.out.println(re.getPreco_unitario());
        System.out.println(re.getPreco_total());
        System.out.println(re.getLocalDateTime());
        System.out.println(re.getUsuario());
        System.out.println(re.getNomeCliente());
        System.out.println(re.getCpfCliente());
        System.out.println(re.getNomefilial());
        System.out.println(re.getFormPagto());
        rdao.cadastrarVendas(
                re.getNomeproduto(),
                re.getCodigoproduto(),
                re.getCategoria(),
                re.getQtd_vendido(),
                re.getPreco_unitario(),
                re.getPreco_total(),
                re.getUsuario(),
                re.getNomeCliente(),
                re.getCpfCliente(),
                re.getNomefilial(),
                re.getFormPagto());
    }

    public static void testeBuscaTodos() {
        RelatorioDAO rdao = new RelatorioDAO();
        List<Relatorio> r = rdao.pegaTodos("2020-05-10", "2020-05-19");
        System.out.println(r);
    }

    public static void testeBuscaTodosAnalitico() {
        RelatorioDAO rdao = new RelatorioDAO();
        List<Relatorio> r = rdao.pegaTodosAnalitico("2020-05-10", "2020-05-19");
        System.out.println(r);
    }

}
