<%-- 
    Document   : vendaCadPagamento
    Created on : 18/05/2020, 20:04:39
    Author     : rafae
--%>

<%@page import="br.senac.sp.dao.FormaPagamentoDAO"%>
<%@page import="br.senac.sp.model.Usuario"%>
<%@page import="br.senac.sp.model.Venda"%>
<%@page import="br.senac.sp.dao.vendaDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.senac.sp.model.Cliente"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //Acessando a session e pegando objeto usuario
    Usuario usuario = (Usuario) request.getSession().getAttribute("loginController");
    //Bem vindo <%= usuario.getLogin()
%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dados do cliente</title>
        <link rel="stylesheet" href="css/pagamento.css">
    </head>

    <body>
        <form action="ClienteVendaController" method="GET">
            <input type="hidden" name="acao" value="buscar"/>
            <input type="hidden" name="novaacao" value="finalizar"/>
            <section>
                <div class="titulo">
                    <h1 style="margin: auto; margin-top: 100px;font: bold 25pt Code;">BUSCA CLIENTE</h1>
                </div>  
                <main>
                    <div class="tabela-final">
                        <strong class="pesquisa-cpf">
                            <label style="font: bold 15pt Code; margin-left: 95px;">CPF:</label>
                            <input id="pesquisa" name="cpf"type="search" var="${param.buscar}">
                            <input type="submit" value="buscar">
                        </strong>
                        <table class="tabela">
                            <tr>
                                <th>Nome Cliente</th>
                                <th>CPF cliente</th>
                                <th>Filial</th>
                                <th>Atendente</th>
                                <th>Metodo</th>
                            </tr>
                            <c:forEach var="c" items="${clista}">
                                <tr>
                                    <c:set var="nome" scope="session" value="${c.nome}"/>
                                    <c:set var="cpf" scope="session" value="${c.cpf}"/>
                                    <td name="nomecliente">${c.nome}</td>
                                    <td name="cpfcliente">${c.cpf}</td>
                                    <td name="nomefilial"><%=usuario.getFilial()%></td>
                                    <td><%=usuario.getNome()%></td>
                                    <td><a href='javascript:confirmaInclusao("${nome}","${cpf}");'>incluir</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </main>
                <div class="proxima-tela">
                    <%
                        vendaDAO vdao = new vendaDAO();
                        List<Venda> lista = vdao.pegaTodos();
                        double soma = 0;
                        for (Venda v : lista) {
                            soma += v.getQtd() * v.getPreco_unitario();
                    %>
                    <input type="hidden" name="nomeproduto" value="<%=v.getNomeproduto()%>"/>
                    <input type="hidden" name="codigoproduto" value="<%=v.getCodigoproduto()%>"/>
                    <input type="hidden" name="categoriaproduto" value="<%=v.getCategoria()%>"/>
                    <input type="hidden" name="qtdvendido" value="<%=v.getQtd()%>"/>
                    <input type="hidden" name="precounitario" value="<%=v.getPreco_unitario()%>"/>
                    <input type="hidden" name="precototal" value="<%=v.getQtd() * v.getPreco_unitario()%>"/>
                    <input type="hidden" name="nomecliente" <c:out value="${nome}"/>
                           <input type="hidden" name="cpfcliente" <c:out value="${cpf}"/>
                           <%
                               }
                           %>
                </div>
                <div class="btn">
                    <button class="Finalizar" style="background-color: #094594;margin-left: -125px;font: bold 15pt Avenir LT Std; width: 95px;">
                        <a href="ClienteVendaController?acao=proximo"style="color: white; text-decoration: none;">Próximo</a>
                    </button>
                    <button class="Retornar" style="background-color: #c94a00;font: bold 15pt Avenir LT Std; ">
                        <a href="vendaController?acao=vendas" style="color: white;text-decoration: none;">Retornar</a>
                    </button>
                    <div style="width: 1200px; margin-left: -62px; height: 72px;">
                        <label style="width: 10px;font: bold 15pt Avenir LT Std; color: rgb(43, 43, 43); margin-left: 205px;margin-top: -200px;">TOTAL: R$</label>
                        <input id="txtTotal"class= "total" value="<fmt:formatNumber value="<%=soma%>"type="currency"/>">
                    </div>
                </div>
            </section>  
        </form>
        <script type="text/javascript">
            function confirmaInclusao(nome, cpf) {
                if (window.confirm('Confirma a inclusão do cliente ?')) {
                    location.href = "ClienteVendaController?acao=incluir&nomecliente=" + nome + "&cpfcliente=" + cpf
                }
            }
        </script>
    </body>

</html>