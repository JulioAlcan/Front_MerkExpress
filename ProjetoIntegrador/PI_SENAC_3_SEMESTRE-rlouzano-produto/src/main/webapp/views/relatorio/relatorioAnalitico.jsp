<%-- 
    Document   : relatorioAnalitico
    Created on : 19/05/2020, 12:33:20
    Author     : rafae
--%>
<%@page import="br.senac.sp.model.Usuario"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //Acessando a session e pegando objeto usuario
    Usuario usuario = (Usuario) request.getSession().getAttribute("loginController");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório Analítico | Merk</title>
        <link rel="stylesheet" href="css/relatorioAnalitico.css">
    </head>
    <body>
        <form action="RelatorioAnaliticoController" method="GET">
            <input type="hidden" name="acao" value="ranalitico"/>
            <div style="margin-top: -5px; margin-left: 720px;">
                <label>Início</label>
                <input id="pesq" type="date" name="datainicio" value="pesquisa"/>
                <label>Fim</label>
                <input id="pesq" type="date" name="datafim" value="pesquisa"/>
                <input id="btnPesq" type="submit" value="pesquisa"/>
            </div>
            <p id="titulo">Relatório Analítico</p><style>#titulo{margin-left: 800px;font: bold 28pt Avenir LT Std;position: absolute;}</style>
            <section id="fundoTabela">
            <table>
                <tr>
                    <th>Nome Produto</th>
                    <th>Código Produto</th>
                    <th>Categoria</th>
                    <th>Soma Qtd.</th>
                    <th>Média Qtd.</th>
                    <th>Preço Unitário</th> 
                    <th>Soma Total</th>
                    <th>Média Total</th>   
                    <th>Data da Venda</th>
                    <th>Usuário</th>
                    <th>Nome do Cliente</th>
                    <th>Cpf do Cliente</th>
                    <th>Nome Filial</th>
                    <th>Forma de pagamento</th>
                </tr>
                <c:forEach var="r" items="${lista}">
                    <tr>
                        <td>${r.nomeproduto}</td>
                        <td>${r.codigoproduto}</td>
                        <td>${r.categoria}</td>
                        <td>${r.getSoma_Qtd()}</td>
                        <td>${r.getSoma_Qtd()}</td>
                        <td><fmt:formatNumber value="${r.preco_unitario}" type="currency"/></td>
                        <td><fmt:formatNumber value="${r.getSoma_Total()}" type="currency"/></td>
                        <td><fmt:formatNumber value="${r.getMedia_preco()}" type="currency"/></td>
                        <td>${r.data}</td>
                        <td>${r.usuario}</td>
                        <td>${r.nomeCliente}</td>
                        <td>${r.cpfCliente}</td>
                        <td>${r.nomefilial}</td>
                        <td>${r.formPagto}</td>
                    </tr>
                </c:forEach>
               
            </table>
            </section>
            
            <input type="checkbox" id="check">
            <label id="icone" for="check"><img src="img/icone-menu.png" title="Menu"></label>
            
            <div class="barra">
                <nav>
                    <label><a href="menuController?acao=menu">
                        <div id="menu"><img src="img/icone-home.png" title="Menu"></div>
                    </a><label>
                    <a href="produtoController?acao=produto">
                        <div class="link">Controle de estoque</div>
                    </a>
                    <a href="ClienteController?acao=cliente">
                        <div class="link">Cadastro de cliente</div>
                    </a>
                    <a href="UsuarioController?acao=usuario">
                        <div class="link">Gerenciar Funcionários</div>
                    </a>
                    <a href="RelatorioAnaliticoController?acao=ranalitico">
                        <div class="link">Relatório Analítico</div>
                    </a>
                    <a href="RelatorioSinteticoController?acao=rsintetico">
                        <div class="link">Relatório Sintético</div>
                    </a>     
                    <label><a href="loginController?acao=login">
                        <div id="sair"><img src="img/icone-sair.png" title="Sair"></div>
                    </a><label>   
                        
                </nav>
        </form>
    </body>
</html>
