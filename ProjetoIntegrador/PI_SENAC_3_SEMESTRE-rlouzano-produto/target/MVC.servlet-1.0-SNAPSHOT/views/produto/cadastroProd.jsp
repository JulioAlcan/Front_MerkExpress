<%-- 
    Document   : cadastroProd.jsp
    Created on : 22/04/2020, 14:05:50
    Author     : rafae
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.senac.sp.model.Usuario"%>
<%
    //Acessando a session e pegando objeto usuario
    Usuario usuario = (Usuario) request.getSession().getAttribute("loginController");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/cadProd.css">

        <title>Merk | Cadastrar Produto</title>

    </head>
    <body>
        <section>
            <form action="produtoController" method="GET">
                <input type="hidden" name="acao" value="Cadastrar"/>
                <h1>Cadastro de produtos</h1>
                <label id="nome">Nome:</label> 
                <input type="text" name="nome"/>
                <br></br>
                <hr>
                </hr>
                <label id="cod">Código:</label> 
                <input type="text" placeholder="Número inteiro" maxlength="14" name="codigoproduto"/>
                <br></br>
                <hr>
                </hr>
                <label id="cat">Categoria:</label> 
                <input type="text" placeholder="Ex: Laticínios" name="categoria"/>
                <br></br>
                <hr>
                </hr>
                <label id="qtd">QTD:</label> 
                <input type="text" name="qtd"/>
                <br></br>
                <hr>
                </hr>
                <label id="preco">Preço:</label> 
                <input type="text" placeholder="valor unitário do produto" name="preco"/>
                <br></br>
                <hr>
                </hr>
                <input id="cadastrar" type="submit" value="Cadastrar"/>   
            </form>
            <a href="produtoController?acao=listar">Listar Produtos</a>


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


                                    </section>
                                    </body>
                                    </html>
