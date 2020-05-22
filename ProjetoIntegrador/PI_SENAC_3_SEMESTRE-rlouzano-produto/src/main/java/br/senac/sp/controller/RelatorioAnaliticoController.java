package br.senac.sp.controller;

import br.senac.sp.dao.RelatorioDAO;
import br.senac.sp.model.Relatorio;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RelatorioAnaliticoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");
        if (acao.equals("ranalitico")) {
            String datainicio = request.getParameter("datainicio");
            String datafim = request.getParameter("datafim");
            RelatorioDAO rdao = new RelatorioDAO();
            List<Relatorio> lista = rdao.pegaTodosAnalitico(datainicio, datafim);
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("views/relatorio/relatorioAnalitico.jsp").forward(request, response);
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
