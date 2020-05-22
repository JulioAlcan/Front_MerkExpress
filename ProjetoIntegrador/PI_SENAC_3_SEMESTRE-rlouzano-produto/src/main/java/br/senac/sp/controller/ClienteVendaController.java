package br.senac.sp.controller;

import br.senac.sp.dao.ClienteDAO;
import br.senac.sp.dao.RelatorioDAO;
import br.senac.sp.dao.produtoDAO;
import br.senac.sp.dao.vendaDAO;
import br.senac.sp.model.Cliente;
import br.senac.sp.model.Relatorio;
import br.senac.sp.model.Usuario;
import br.senac.sp.model.Venda;
import br.senac.sp.model.produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClienteVendaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Usuario usuario = (Usuario) request.getSession().getAttribute("loginController");
        Venda v = new Venda();
        vendaDAO vdao = new vendaDAO();
        produtoDAO pdao = new produtoDAO();
        String acao = request.getParameter("acao");
        if (acao.equals("pagamento")) {
            RequestDispatcher rd = request.getRequestDispatcher("views/vendas/clientevenda.jsp");
            rd.forward(request, response);
        } else if (acao.equals("buscar")) {
            String cpf = request.getParameter("cpf");
            v.setNomecliente(request.getParameter("nomecli"));
            v.setCpfcliente(request.getParameter("cpfcli"));
            ClienteDAO cdao = new ClienteDAO();
            List<Cliente> clista = cdao.BuscaCliente(cpf);
            System.out.println(clista);
            request.setAttribute("clista", clista);
            request.getRequestDispatcher("views/vendas/clientevenda.jsp").forward(request, response);
        } else if (acao.equals("incluir")) {
            v.setNomecliente(request.getParameter("nomecliente"));
            v.setCpfcliente(request.getParameter("cpfcliente"));
            vdao.cadastrarCliente(v.getNomecliente(), v.getCpfcliente(), usuario.getFilial());
            request.getRequestDispatcher("views/vendas/clientevenda.jsp").forward(request, response);
        } else if (acao.equals("proximo")) {
            request.getRequestDispatcher("views/vendas/formaPagto.jsp").forward(request, response);
        } else if (acao.equals("finalizar")) {
            String credito = request.getParameter("credito");
            String debito = request.getParameter("debito");
            String dinheiro = request.getParameter("dinheiro");
            String alimentacao = request.getParameter("alimentacao");
            String formapagamento = null;
            if (credito != (null)) {
                formapagamento = credito;
            } else if (debito != (null)) {
                formapagamento = debito;
            } else if (dinheiro != (null)) {
                formapagamento = dinheiro;
            } else if (alimentacao != (null)) {
                formapagamento = alimentacao;
            }
            Relatorio r = new Relatorio();
            RelatorioDAO rd = new RelatorioDAO();
            List<Venda> listaVenda = vdao.pegaTodos();
            List<produto> listaProd = pdao.pegaTodos();
            int qtd = 0;
            for (produto prod : listaProd) {
                qtd = prod.getQtd();
            }
            for (Venda venda : listaVenda) {
                pdao.alteraVenda((qtd - venda.getQtd()), venda.getCodigoproduto());
                if (rd.cadastrarVendas(venda.getNomeproduto(), venda.getCodigoproduto(), venda.getCategoria(), venda.getQtd(), venda.getPreco_unitario(), (venda.getQtd() * venda.getPreco_unitario()), venda.getUsuario(), venda.getNomecliente(), venda.getCpfcliente(), venda.getNome_filial(), formapagamento)) {
                    vdao.ExcluirTodos();
                }
                request.getRequestDispatcher("views/vendas/clientevenda.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
