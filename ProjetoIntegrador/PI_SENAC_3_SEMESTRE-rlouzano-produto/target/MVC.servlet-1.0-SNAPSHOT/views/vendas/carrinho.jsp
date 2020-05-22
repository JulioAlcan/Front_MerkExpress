<%@page import="br.senac.sp.model.Usuario"%>
<%@page import="br.senac.sp.model.produto"%>
<%@page import="br.senac.sp.dao.produtoDAO"%>
<%@page import="br.senac.sp.dao.vendaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.senac.sp.model.Venda"%>
<%@page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    //Acessando a session e pegando objeto usuario
    Usuario usuario = (Usuario) request.getSession().getAttribute("loginController");
%>
<!DOCTYPE html0>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho</title>
        <link rel="stylesheet" href="css/venda.css">
    </head>
    <body>
        <form action="vendaController" method="GET">
            <input type="hidden" name="acao" value="alterar"/>
            <table style="width: 1200px; margin-left: 300px; margin-right: 300px;">
                </div>
                <tr>
                    <th scope="col">Nome</th>
                    <th scope="col">Codigo</th>
                    <th scope="col">Categoria</th>
                    <th scope="col">Preço</th>
                    <th scope="col">QTD</th>
                    <th scope="col">EDITAR</th>
                </tr>
                <c:forEach var="v" items="${lista}">
                    <tr>
                        <td><input type="text" value="${v.nomeproduto}"/></td>
                        <td><input type="text" value="${v.codigoproduto}"/></td>
                        <td><input type="text" value="${v.categoria}"/></td>
                        <td><input type="text" value="<fmt:formatNumber value='${v.preco_unitario}'type="currency"/>"/></td>
                        <td><input name="qtd" type="text" value="${v.qtd}"/>
                        <td><input type="submit" value="alterar"></td>
                        <td><input name="id" type="hidden" value="${v.id}"/></td>
                    </tr>
                    </c:forEach>
            </table>
        </form>
    </body>
</html>