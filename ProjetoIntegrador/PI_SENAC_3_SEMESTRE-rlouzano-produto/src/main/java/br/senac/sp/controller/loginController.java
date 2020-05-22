package br.senac.sp.controller;

import br.senac.sp.dao.usuarioDAO;
import br.senac.sp.model.Usuario;
import br.senac.sp.model.beam.c_logado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rafae
 */
@WebServlet("/loginController")
public class loginController extends HttpServlet {


    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");
        try (PrintWriter out = response.getWriter()) {
            if (acao == null) {
                //direciona para a pagina que esta determinada no parametro do metodo ("index.html")
                request.getRequestDispatcher("index.html").forward(request, response);
            }
            switch (acao) {
                case "login":
                    request.getRequestDispatcher("views/login/login.jsp").forward(request, response);
                    break;

            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");
        try (PrintWriter out = response.getWriter()) {
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            c_logado c = new c_logado();
            c.setLogin(login);
            Usuario usu = new Usuario();
            usu.setLogin(login);
            usu.setSenha(senha);
            usuarioDAO usuarioDAO = new usuarioDAO();
            Usuario autenticado = usuarioDAO.autenticar(usu);
            List<Usuario> lista = new ArrayList<>();
            lista.add(autenticado);
            if (usu.getLogin().equals(login) && usu.getSenha().equals(senha)) {
                System.out.println(autenticado);
                HttpSession sessao = request.getSession();
                sessao.setMaxInactiveInterval(60 * 3);
                sessao.setAttribute("loginController", autenticado);
                response.sendRedirect("menuController?acao=menu");
            } else {
                // Redireciona para Login
                response.sendRedirect("loginController?acao=login");
            }

        }
        // Busca no banco
        // Se existe
        //if (autenticado != null) {
        // Criando uma sessao

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
