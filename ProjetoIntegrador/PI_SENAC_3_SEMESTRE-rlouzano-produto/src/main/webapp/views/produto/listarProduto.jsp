    <%-- 
    Document   : listarProduto
    Created on : 20/05/2020, 16:38:21
    Author     : rafae
--%>

<%@page import="br.senac.sp.model.Usuario"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    //Acessando a session e pegando objeto usuario
    Usuario usuario = (Usuario) request.getSession().getAttribute("loginController");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/listaProduto.css">
        <title>Lista de Produtos</title>
    </head>
    <body>
        <p id="titulolp">Lista de produtos</p>
        <section id="fundoTabela">
            <form action="produtoController" method="GET">

                <input type="hidden" name="acao" value="cadastrar"/>

                <table>
                    <tr>
                        <th>Nome Produto</th>
                        <th>Código Produto</th>
                        <th>Categoria</th>
                        <th>Quantidade</th>
                        <th>Preço</th> 
                        <th>Ação</th> 
                    </tr>
                    <c:forEach var="p" items="${pegatudo}">
                        <tr>
                            <td>${p.nome}</td>
                            <td>${p.codigo}</td>
                            <td>${p.categoria}</td>
                            <td>${p.qtd}</td>
                            <td>${p.preco}</td>
                            <td><a id="edit" href="javascript:confirmarAlteracao(${p.idproduto});">Editar - </a> <a id="edit" href="javascript:confirmarExclusao(${p.idproduto});">Excluir</a></td>
                        </tr>
                    </c:forEach>
                </table>
        </section>
        </br>
        
        <a id="cad" href="produtoController?acao=produto">Cadastrar Produto</a>
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

                                </br>

                                <script>
                                    function confirmarExclusao(idproduto) {
                                        if (confirm('Deseja realmente excluir esse produto?')) {
                                            location.href = "produtoController?acao=excluir&idproduto=" + idproduto;
                                        }
                                    }
                                    function confirmarAlteracao(idproduto) {
                                        if (confirm('Deseja realmente alterar esse produto?')) {
                                            location.href = "produtoController?acao=alterar&idproduto=" + idproduto;
                                        }
                                    }
                                </script>
                                </body>
                                </html>
