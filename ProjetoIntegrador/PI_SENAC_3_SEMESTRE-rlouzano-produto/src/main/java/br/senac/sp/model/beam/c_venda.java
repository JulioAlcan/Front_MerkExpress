package br.senac.sp.model.beam;

import br.senac.sp.dao.RelatorioDAO;
import br.senac.sp.dao.produtoDAO;
import br.senac.sp.dao.vendaDAO;
import br.senac.sp.model.Relatorio;
import br.senac.sp.model.Usuario;
import br.senac.sp.model.Venda;
import br.senac.sp.model.produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class c_venda extends Venda {

    public produtoDAO pdao = new produtoDAO();
    public vendaDAO vdao = new vendaDAO();
    public Venda v = new Venda();

    public void vendas(HttpServletRequest request, HttpServletResponse response, String pesquisa) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            System.out.println(pesquisa);
            List<produto> prod = pdao.buscaPorPesquisa(pesquisa);
            request.setAttribute("prod", prod);
            request.getRequestDispatcher("views/vendas/vendas.jsp").forward(request, response);
        } catch (ServletException e) {
            System.out.println("ERRO SERVLET AO ACESSAR TELA DE VENDAS: " + e.getMessage());
            response.sendRedirect("loginController");
        }
    }

    public void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            v.setNomeproduto(request.getParameter("nome"));
            v.setCodigoproduto(request.getParameter("codigo"));
            v.setCategoria(request.getParameter("categoria"));
            int qtd = Integer.parseInt(request.getParameter("qtd"));
            v.setPreco_unitario(Double.parseDouble(request.getParameter("preco")));
            v.setUsuario(request.getParameter("login"));
            v.setNomecliente(request.getParameter("nomecliente"));
            v.setCpfcliente(request.getParameter("cpfcliente"));
            v.setNome_filial(request.getParameter("nomefilial"));
            vdao.cadastrar(v.getNomeproduto(), v.getCodigoproduto(), v.getCategoria(), qtd, v.getPreco_unitario(), v.getUsuario(), v.getNome_filial());
            request.getRequestDispatcher("views/vendas/vendas.jsp").forward(request, response);
        } catch (ServletException e) {
            System.out.println("ERRO SERVLET AO INCLUIR PRODUTO: " + e.getMessage());
            response.sendRedirect("vendaController?acao=vendas");
        }
    }

    public void carrinho(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String idcarrinho = request.getParameter("idcarrinho");
            v.setId(Integer.parseInt(idcarrinho));
            System.out.println("ENCONTREI ID: " + v.getId());
            List<Venda> lista = vdao.pegaTudo(v.getId());
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("views/vendas/carrinho.jsp").forward(request, response);
        } catch (ServletException e) {
            System.out.println("ERRO SERVLET AO ACESSAR O CARRINHO: " + e.getMessage());
            response.sendRedirect("vendaController?acao=vendas");
        }
    }

    public void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            int i = Integer.parseInt(request.getParameter("id"));
            int q = Integer.parseInt(request.getParameter("qtd"));
            vendaDAO vlista = new vendaDAO();
            int qtprod = 0;
            List<produto> pd = pdao.pegaQtd();
            for (produto pdq : pd) {
                qtprod = pdq.getQtd();
            }
            System.out.println(qtprod);
            System.out.println(q);
            if (qtprod > q) {
                vlista.Alterar(q, i);
                request.getRequestDispatcher("views/vendas/vendas.jsp").forward(request, response);
            } else {
                out.println("<html><body><script>alert('Quantidade maior que o estoque');window.location.replace('vendaController?acao=vendas');</script></body></html>");
            }
        } catch (ServletException e) {
            System.out.println("ERRO SERVLET AO ALTERAR QTD PRODUTO: " + e.getMessage());
            response.sendRedirect("vendaController?acao=vendas");
        }

    }

    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            int idexcluir = Integer.parseInt(request.getParameter("id"));
            vdao.Excluir(idexcluir);
            request.getRequestDispatcher("views/vendas/vendas.jsp").forward(request, response);
        } catch (ServletException e) {
            System.out.println("ERRO SERVLET AO EXCLUIR PRODUTO DO CARRINHO: " + e.getMessage());
            response.sendRedirect("vendaController?acao=vendas");
        }
    }

    public void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            vdao.ExcluirTodos();
            request.getRequestDispatcher("views/vendas/vendas.jsp").forward(request, response);
        } catch (ServletException e) {
            System.out.println("ERRO SERVLET AO CANCELAR TODOS OS ITENS DO CARRINHO: " + e.getMessage());
            response.sendRedirect("vendaController?acao=vendas");
        }
    }

    public void finalizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensagem = null;
        try {
            response.setContentType("text/html;charset=UTF-8");
            Relatorio r = new Relatorio();
            RelatorioDAO rd = new RelatorioDAO();
            Usuario usuario = (Usuario) request.getSession().getAttribute("loginController");
            List<Venda> listaVenda = vdao.pegaTodos();
            List<produto> listaProd = pdao.pegaTodos();
            int qtdprod = 0;
            for (produto prodqtd : listaProd) {
                qtdprod = prodqtd.getQtd();
            }
            for (Venda venda : listaVenda) {
                pdao.alteraVenda((qtdprod - venda.getQtd()), venda.getCodigoproduto());
                if (rd.cadastrarVendas(venda.getNomeproduto(), venda.getCodigoproduto(),
                        venda.getCategoria(), venda.getQtd(), venda.getPreco_unitario(),
                        (venda.getQtd() * venda.getPreco_unitario()), venda.getUsuario(),
                        venda.getNomecliente(), venda.getCpfcliente(), usuario.getFilial(), venda.getFormpagto())) {
                    mensagem = "Venda efetuado com sucesso!";
                    vdao.ExcluirTodos();
                    request.getRequestDispatcher("views/vendas/vendas.jsp").forward(request, response);
                }else{
                    mensagem = "Erro ao efetuar a venda!";
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(mensagem + e.getMessage());
            response.sendRedirect("vendaController?acao=vendas");
        }
        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + mensagem + "');location.href='vendaController?acao=vendas'</script>");
    }

}
