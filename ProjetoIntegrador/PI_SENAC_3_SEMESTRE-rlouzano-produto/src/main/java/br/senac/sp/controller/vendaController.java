package br.senac.sp.controller;

import br.senac.sp.model.beam.c_venda;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "vendaController", urlPatterns = {"/vendaController"})
public class vendaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        c_venda c = new c_venda();
        String acao = request.getParameter("acao");
        String pesquisa = request.getParameter("pesquisa");
        if (acao == null) {
            request.getRequestDispatcher("views/vendas/vendas.jsp").forward(request, response);
        }
        switch (acao) {
            case "vendas":
                c.vendas(request, response, pesquisa);
                break;
            case "incluir":
                c.incluir(request, response);
                break;
            case "carrinho":
                c.carrinho(request, response);
                break;
            case "alterar":
                c.alterar(request, response);
                break;
            case "excluir":
                c.excluir(request, response);
                break;
            case "cancelar":
                c.cancelar(request, response);
                break;
            case "finalizar":
                c.finalizar(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
