package br.senac.sp.controller;

import br.senac.sp.dao.produtoDAO;
import br.senac.sp.model.produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class produtoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        produtoDAO pdao = new produtoDAO();
        produto p = new produto();
        String acao = request.getParameter("acao");
        try (PrintWriter out = response.getWriter()) {
            switch (acao) {
                case "produto":
                    request.getRequestDispatcher("views/produto/cadastroProd.jsp").forward(request, response);
                    break;
                case "Cadastrar":
                    String msg;
                    try {
                        p.setNome(request.getParameter("nome"));
                        p.setCodigo(request.getParameter("codigoproduto"));
                        p.setCategoria(request.getParameter("categoria"));
                        p.setQtd(Integer.parseInt(request.getParameter("qtd")));
                        p.setPreco(Double.parseDouble(request.getParameter("preco")));
                        if (pdao.cadastrar(p.getNome(), p.getCodigo(), p.getCategoria(), p.getQtd(), p.getPreco())) {
                            msg = "Produto Cadastrado com Sucesso";
                        } else {
                            msg = "Erro ao cadastrar o produto";
                        }
                    } catch (NumberFormatException e) {
                        msg = "erro ao cadastrar cliente!";
                        System.out.println("erro ao cadastrar cliente:" + e.getMessage());
                    }
                    out.println("<script>alert('" + msg + "');location.href='produtoController?acao=listar'</script>");
                    break;
                case "listar":

                    try {
                        List<produto> pegatudo = pdao.pegaTudo();
                        request.setAttribute("pegatudo", pegatudo);
                        request.getRequestDispatcher("views/produto/listarProduto.jsp").forward(request, response);
                    } catch (ServletException e) {
                        System.out.println("ERRO AO LISTA OS PRODUTOS: " + e.getMessage());
                    }
                    break;

                case "alterar":
                    int idproduto = Integer.parseInt(request.getParameter("idproduto"));
                    produto prod = pdao.buscaPorId(idproduto);
                    if (prod.getIdproduto() > 0) {
                        request.setAttribute("p", prod);
                        request.getRequestDispatcher("views/produto/editarProduto.jsp").forward(request, response);
                    } else {
                        out.print("<script>alert('Produto não encontrado!');location.href='./listarProduto.jsp'</script>");
                    }
                    break;
                case "salvar":

                    String mensagem;
                    try {
                        if (!request.getParameter("id").isEmpty()) {
                            p.setIdproduto(Integer.parseInt(request.getParameter("id")));
                        }
                        p.setNome(request.getParameter("nome"));
                        p.setCodigo(request.getParameter("codigoproduto"));
                        p.setCategoria(request.getParameter("categoria"));
                        p.setQtd(Integer.parseInt(request.getParameter("qtd")));
                        p.setPreco(Double.parseDouble(request.getParameter("preco")));
                        p.setId(Integer.parseInt(request.getParameter("idfilial")));
                        if (pdao.alterar(p.getNome(), p.getCodigo(), p.getCategoria(), p.getQtd(), p.getPreco(), p.getId(), p.getIdproduto())) {
                            mensagem = "Produto editado com sucesso!";
                        } else {
                            mensagem = "Erro ao editar o produto";
                        }
                    } catch (NumberFormatException e) {
                        mensagem = "Erro ao editar o produto";
                        System.out.println("Erro ao editar o produto:" + e.getMessage());
                    }
                    out.println("<script>alert('" + mensagem + "');location.href='produtoController?acao=listar'</script>");

                    break;
                case "excluir":
                    int id = Integer.parseInt(request.getParameter("idproduto"));
                    if (pdao.excluir(id)) {
                        out.print("<script>alert('Produto excluido com sucesso!');location.href='produtoController?acao=listar'</script>");
                    } else {
                        out.print("<script>alert('Erro ao excluir produto!');location.href='produtoController?acao=listar'</script>");
                    }
                    break;
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
    }// </editor-fold>

}
