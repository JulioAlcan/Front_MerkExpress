<%-- 
    Document   : editarFuncionario
    Created on : 21/05/2020, 00:47:37
    Author     : rafae
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <section>
            <form action="UsuarioController" method="GET">
                <input type="hidden" name="acao" value="salvar"/>
                <h1>Crie a sua conta MerkExpress</h1>
                <input type="hidden" name="id" value="${u.id}"/>
                <label>Nome:</label> 
                <input type="text" name="nome" value="${u.nome}" />
                <br></br>
                
                <label>Cpf:</label> 
                <input type="text"  name="cpf" value="${u.cpf}"/>
                <br></br>
                
                <label>Perfil</label> 
                <input type="text" name="perfil" value="${u.perfil}"/>
                <br></br>
                
                <label>Usuário:</label> 
                <input type="text" placeholder="Qual será seu usuário no sistema?" name="login" value="${u.login}"/>
                <br></br>
                
                <label>Senha:</label> 
                <input type="password" name="senha" value="${u.senha}"/>
                <br></br>
                
                <label id="adm">Senha admin:</label> 
                <input type="password" name="senhaAdmin" value="${u.senhaAdmin}"/>
                <br id="adm"></br>
                
                <label>Filial:</label> 
                <input type="text" name="filial" value="${u.filial}"/>
                <br></br>
                <label>Codigo Filial:</label> 
                <input type="text" name="idfilial" value="${u.idfilial}"/>
                <br></br>
                
                <input type="submit" value="salvar">
                <br></br>
                <a href="UsuarioController?acao=listar">Listar Funcionários</a>
            </form>
        </section>
    </body>
</html>
