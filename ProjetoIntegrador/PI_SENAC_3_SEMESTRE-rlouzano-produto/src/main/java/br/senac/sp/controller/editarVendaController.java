/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.controller;

import br.senac.sp.dao.vendaDAO;
import br.senac.sp.model.Venda;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafae
 */
public class editarVendaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String paramId = request.getParameter("idcarrinho");
        int id = Integer.valueOf(paramId);
        vendaDAO dao = new vendaDAO();

        List<Venda> lista = dao.pegaTudo(id);
        for (Venda venda : lista) {
            System.out.println(venda);
        }
        request.setAttribute("lista", lista);
        RequestDispatcher rd = request.getRequestDispatcher("views/vendas/carrinho.jsp");
        rd.forward(request, response);
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
