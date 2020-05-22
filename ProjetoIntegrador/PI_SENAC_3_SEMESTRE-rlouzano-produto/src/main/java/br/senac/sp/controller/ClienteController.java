package br.senac.sp.controller;

import br.senac.sp.dao.ClienteDAO;
import br.senac.sp.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//    <td><a href="ClienteControle?acao=delete&idCliente=<c:out value="${c.idCliente}"/>">Delete</a></td>    usar na tela listarCliente
public class ClienteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteDAO cdao = new ClienteDAO();
        Cliente c = new Cliente();
        String acao = request.getParameter("acao");
        try (PrintWriter out = response.getWriter()) {
            switch (acao) {
                case "cliente":
                    try {
                        List<Cliente> cli = cdao.pegaTodos();
                        request.setAttribute("cliente", cli);
                        request.getRequestDispatcher("views/cliente/listarClientes.jsp").forward(request, response);
                    } catch (ServletException e) {
                        System.out.println("ERRO SERVLET AO ACESSAR TELA DE CLIENTE: " + e.getMessage());
                    }
                    break;
                case "alterar":
                    c.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
                    Cliente clientes = cdao.buscaPorId(c.getIdCliente());
                    if (clientes.getIdCliente() > 0) {
                        request.setAttribute("c", clientes);
                        request.getRequestDispatcher("views/cliente/editarCliente.jsp").forward(request, response);
                    } else {
                        out.print("<script>alert('Cliente não encontrado!');location.href='./listarClientes.jsp'</script>");
                    }
                    break;
                case "Salvar":
                    String mensagem;
                    try {
                        if (!request.getParameter("idCliente").isEmpty()) {
                            c.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
                        }
                        c.setNome(request.getParameter("nome"));
                        c.setSexo(request.getParameter("sexo"));
                        c.setCpf(request.getParameter("CPF"));
                        c.setRg(request.getParameter("rg"));
                        c.setEstadoCivil(request.getParameter("estadoCivil"));
                        c.setTelefone(request.getParameter("telefone"));
                        c.setDataNascimento(request.getParameter("dataNascimento"));
                        c.setEmail(request.getParameter("email"));
                        c.setLogradouro(request.getParameter("logradouro"));
                        c.setNumeroCasa(request.getParameter("numeroCasa"));
                        c.setComplemento(request.getParameter("complemento"));
                        c.setCEP(request.getParameter("CEP"));
                        c.setCidade(request.getParameter("cidade"));
                        c.setUf(request.getParameter("uf"));
                        if (cdao.alterar(c.getNome(), c.getSexo(), c.getCpf(), c.getRg(), c.getEstadoCivil(), c.getTelefone(), c.getDataNascimento(), c.getEmail(), c.getLogradouro(), c.getNumeroCasa(), c.getComplemento(), c.getCEP(), c.getCidade(), c.getUf(), c.getIdCliente())) {
                            mensagem = "Cliente Cadastrado com Sucesso";

                        } else {
                            mensagem = "Erro ao cadastrar Cliente";
                        }
                    } catch (NumberFormatException e) {
                        mensagem = "erro ao cadastrar cliente!";
                        System.out.println("erro ao cadastrar cliente:" + e.getMessage());
                    }
                    out.println("<script>alert('" + mensagem + "');location.href='ClienteController?acao=listar'</script>");

                    break;
                case "novo":
                    request.getRequestDispatcher("views/cliente/cadastrarCliente.jsp").forward(request, response);
                    break;
                case "Cadastrar":
                    String msg;
                    try {
                        c.setNome(request.getParameter("nome"));
                        c.setSexo(request.getParameter("sexo"));
                        c.setCpf(request.getParameter("CPF"));
                        c.setRg(request.getParameter("rg"));
                        c.setEstadoCivil(request.getParameter("estadoCivil"));
                        c.setTelefone(request.getParameter("telefone"));
                        c.setDataNascimento(request.getParameter("dataNascimento"));
                        c.setEmail(request.getParameter("email"));
                        c.setLogradouro(request.getParameter("logradouro"));
                        c.setNumeroCasa(request.getParameter("numeroCasa"));
                        c.setComplemento(request.getParameter("complemento"));
                        c.setCEP(request.getParameter("CEP"));
                        c.setCidade(request.getParameter("cidade"));
                        c.setUf(request.getParameter("uf"));
                        if (cdao.cadastrar(c.getNome(), c.getSexo(), c.getCpf(), c.getRg(), c.getEstadoCivil(), c.getTelefone(), c.getDataNascimento(), c.getEmail(), c.getLogradouro(), c.getNumeroCasa(), c.getComplemento(), c.getCEP(), c.getCidade(), c.getUf())) {
                            msg = "Cliente Cadastrado com Sucesso";
                        } else {
                            msg = "Erro ao cadastrar Cliente";
                        }
                    } catch (Exception e) {
                        msg = "erro ao cadastrar cliente!";
                        System.out.println("erro ao cadastrar cliente:" + e.getMessage());
                    }
                    out.println("<script>alert('" + msg + "');location.href='ClienteController?acao=listar'</script>");

                    break;
                case "excluir":
                    int id = Integer.parseInt(request.getParameter("idCliente"));
                    if (cdao.excluir(id)) {
                        out.print("<script>alert('Cliente excluido com sucesso!');location.href='ClienteController?acao=listar'</script>");
                    } else {
                        out.print("<script>alert('Erro ao excluir cliente!');location.href='ClienteController?acao=listar'</script>");
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
    }

}
