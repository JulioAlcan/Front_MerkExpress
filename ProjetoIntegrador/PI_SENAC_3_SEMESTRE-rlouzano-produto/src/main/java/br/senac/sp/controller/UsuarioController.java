package br.senac.sp.controller;

import br.senac.sp.dao.usuarioDAO;
import br.senac.sp.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafae
 */
public class UsuarioController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        usuarioDAO udao = new usuarioDAO();
        Usuario u = new Usuario();
        String acao = request.getParameter("acao");
        try (PrintWriter out = response.getWriter()) {
            switch (acao) {
                case "usuario":
                    request.getRequestDispatcher("views/funcionario/cadastroFunc.jsp").forward(request, response);
                    break;
                case "cadastrar":
                    String msg;
                    try {
                        u.setNome(request.getParameter("nome"));
                        u.setCpf(request.getParameter("cpf"));
                        u.setPerfil(request.getParameter("perfil"));
                        u.setLogin(request.getParameter("login"));
                        u.setSenha(request.getParameter("senha"));
                        u.setSenhaAdmin(request.getParameter("senhaAdmin"));
                        u.setFilial(request.getParameter("filial"));
                        u.setIdfilial(Integer.parseInt(request.getParameter("codigo")));
                        if (udao.cadastrar(u.getNome(), u.getCpf(), u.getPerfil(), u.getLogin(), u.getSenha(), u.getSenhaAdmin(), u.getFilial(), u.getIdfilial())) {
                            msg = "Usuario Cadastrado com Sucesso";
                        } else {
                            msg = "Erro ao cadastrar o Usuario";
                        }
                    } catch (NumberFormatException e) {
                        msg = "erro ao cadastrar usuario!";
                        System.out.println("erro ao cadastrar usuario:" + e.getMessage());
                    }
                    out.println("<script>alert('" + msg + "');location.href='UsuarioController?acao=listar'</script>");
                    break;
                case "listar":
                    List<Usuario> lista = udao.buscaTodos();
                    request.setAttribute("user", lista);
                    request.getRequestDispatcher("views/funcionario/listarFuncionario.jsp").forward(request, response);
                    break;
                case "alterar":
                    int id = Integer.parseInt(request.getParameter("id"));
                    Usuario user = udao.buscaPoId(id);
                    if (user.getId() > 0) {
                        request.setAttribute("u", user);
                        request.getRequestDispatcher("views/funcionario/editarFuncionario.jsp").forward(request, response);
                    } else {
                        out.print("<script>alert('Funcionário não encontrado!');location.href='UsuarioController?acao=listar'</script>");
                    }
                    break;
                case "salvar":
                    String mensagem;
                    try {
                        if (!request.getParameter("id").isEmpty()) {
                            u.setId(Integer.parseInt(request.getParameter("id")));
                        }
                        u.setNome(request.getParameter("nome"));
                        u.setCpf(request.getParameter("cpf"));
                        u.setPerfil(request.getParameter("perfil"));
                        u.setLogin(request.getParameter("login"));
                        u.setSenha(request.getParameter("senha"));
                        u.setSenhaAdmin(request.getParameter("senhaAdmin"));
                        u.setFilial(request.getParameter("filial"));
                        u.setIdfilial(Integer.parseInt(request.getParameter("idfilial")));
                        if (udao.alterar(u.getNome(), u.getCpf(), u.getPerfil(), u.getLogin(), u.getSenha(), u.getSenhaAdmin(), u.getFilial(), u.getIdfilial(), u.getId())) {
                            mensagem = "Funcionário editado com sucesso!";
                        } else {
                            mensagem = "Erro ao editar o Funcionário";
                        }
                    } catch (NumberFormatException e) {
                        mensagem = "Erro ao editar o Funcionário";
                        System.out.println("Erro ao editar o Funcionário:" + e.getMessage());
                    }
                    out.println("<script>alert('" + mensagem + "');location.href='UsuarioController?acao=listar'</script>");

                    break;
                case "excluir":
                    int idfunc = Integer.parseInt(request.getParameter("id"));
                    if (udao.excluir(idfunc)) {
                        out.print("<script>alert('funcionário excluido com sucesso!');location.href='UsuarioController?acao=listar'</script>");
                    } else {
                        out.print("<script>alert('Erro ao excluir funcionário!');location.href='UsuarioController?acao=listar'</script>");
                    }
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
