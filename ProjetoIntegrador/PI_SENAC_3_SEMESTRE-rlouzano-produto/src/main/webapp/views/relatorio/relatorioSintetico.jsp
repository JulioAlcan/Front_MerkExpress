<%-- 
    Document   : relatorio
    Created on : 19/05/2020, 10:19:29
    Author     : rafae
--%>
<%@page import="br.senac.sp.model.Usuario"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    //Acessando a session e pegando objeto usuario
    Usuario usuario = (Usuario) request.getSession().getAttribute("loginController");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/relatorioSintetico.css">
        <title>Relatório Sintético | Merk</title>
    </head>
    <body>
        <form action="RelatorioSinteticoController" method="GET">
            <p id="titulo">Relatório Sintético</p><style>#titulo{margin-left: 800px;font: bold 28pt Avenir LT Std;margin-top:60px;position: absolute;}</style>
            <div style="margin-top: -5px; margin-left: 720px;">
                <input type="hidden" name="acao" value="rsintetico"/>
                <label>Início</label>
                <input id="pesq" type="date" name="datainicio" value="pesquisa"/>
                <label>Fim</label>
                <input id="pesq" type="date" name="datafim" value="pesquisa"/>
                <input id="btnPesq" type="submit" value="pesquisa"/>
            </div>

            <section id="fundoTabela">
                <table style="width: 1552px; margin-top: 12px;">
                    <tr>
                        <th>Nome Produto</th>
                        <th>Codigo Produto</th>
                        <th>Categoria</th>
                        <th>QTD</th>
                        <th>Preço Unitário</th>
                        <th>Preço Total</th>   
                        <th>Data da Venda</th>
                        <th>Usuario</th>
                        <th>Nome do Cliente</th>
                        <th>Cpf do Cliente</th>
                        <th>Nome Filial</th>
                        <th>Forma de pagamento</th>
                    </tr>
                    <c:forEach var="r" items="${rlista}">
                        <tr>
                            <td>${r.nomeproduto}</td>
                            <td>${r.codigoproduto}</td>
                            <td>${r.categoria}</td>
                            <td>${r.qtd_vendido}</td>
                            <td>${r.preco_unitario}</td>
                            <td>${r.preco_total}</td>
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
