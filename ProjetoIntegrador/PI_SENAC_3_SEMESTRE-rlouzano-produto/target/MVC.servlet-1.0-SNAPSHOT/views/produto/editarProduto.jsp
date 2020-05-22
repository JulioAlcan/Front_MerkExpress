<%-- 
    Document   : EditarProduto
    Created on : 20/05/2020, 16:38:37
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
        <title>Editar Produtos</title>
        <link rel="stylesheet" href="css/editarProd.css">
    </head>
    <body>
        <section id="fundoTabela">
            <p> Editar produto</p>
            <form action="produtoController" method="GET">
                <input type="hidden" name="acao" value="salvar"/>

                <input type="hidden" name="id" value="${p.idproduto}"/>

                <label id="nome" >Nome:</label>
                <input type="text" name="nome" value="${p.nome}"/>
                <br></br>
                <hr>
                </hr>
                <label id="cod">Código:</label>
                <input type="text" name="codigoproduto"value="${p.codigo}"/>
                <br></br>
                <hr>
                </hr>
                <label id="cat">Categoria:</label>
                <input type="text" name="categoria"value="${p.categoria}"/>
                <br></br>
                <hr>
                </hr>
                <label  id="qtd">Qtd:</label> 
                <input type="text" name="qtd"value="${p.qtd}"/>
                <br></br>
                <hr>
                </hr>
                <label  id="preco">Preço:</label> 
                <input type="text" name="preco"value="${p.preco}"/>
                <br></br>
                <hr>
                </hr>
                <input type="hidden" name="idfilial" value="${p.id}"/>
                <section id="btn">
                <input id="salvar" type="submit" value="salvar"/>   
                </section>
                </br>
                <a id="lista" href="produtoController?acao=listar">Listar Produtos</a>
            </form>
        </section>
    </body>
</html>
