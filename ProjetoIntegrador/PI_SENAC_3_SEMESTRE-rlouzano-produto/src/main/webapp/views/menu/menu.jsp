<%-- 
    Document   : menu.jsp
    Created on : 22/04/2020, 10:31:38
    Author     : rafae
--%>

<%@page import="br.senac.sp.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.senac.sp.model.Usuario"%>
<%
    //Acessando a session e pegando objeto usuario
    Usuario usuario = (Usuario) request.getSession().getAttribute("loginController");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Menu | Merk</title>
        <link rel="stylesheet" href="css/menu.css">
    </head>
    <body>
        <form action="menuController" method="GET">
            <a id="cadprod" href="produtoController?acao=produto">Cadastro Produto</a>
            <a id="cadfunc" href="UsuarioController?acao=usuario">Cadastro Usuario</a>
            <a id="cadcli"  href="ClienteController?acao=cliente">Cadastro Cliente</a>
            <a id="vendas"  href="vendaController?acao=vendas">Vendas</a>
            <a id="ra"      href="RelatorioAnaliticoController?acao=ranalitico">Relatório Analitico</a>
            <a id="rs"      href="RelatorioSinteticoController?acao=rsintetico">Relatório Sintético</a>

            <input type="checkbox" id="check">
            <label id="icone" for="check"><img src="img/icone-menu.png" title="Menu"></label>
            
            <div class="barra">
                <nav>
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
                <input type="hidden" name="acao" value="menu"/>
        </form>
    </body>
</html>
