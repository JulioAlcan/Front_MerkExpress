<%-- 
    Document   : cadastroFunc.jsp
    Created on : 22/04/2020, 14:05:31
    Author     : rafae
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.senac.sp.model.Usuario"%>
<%    //Acessando a session e pegando objeto usuario
    Usuario usuario = (Usuario) request.getSession().getAttribute("loginController");
%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Merk | Funcionários</title>
        <link rel="stylesheet" href="css/cadUser.css">
    </head>
    <body>
        <section>
            <form action="UsuarioController" method="GET">
                <input type="hidden" name="acao" value="cadastrar"/>
                <h1>Crie a sua conta MerkExpress</h1>
                <label id="lblNome">Nome:</label> 
                <input type="text" name="nome" />
                <br></br>
                <hr>
                </hr>
                <label id="lblCpf">Cpf:</label> 
                <input type="text" placeholder="Seu CPF sem traço" maxlength="14" name="cpf"/>
                <br></br>
                <hr>
                </hr>
                <label id="perfil">Perfil:</label> 
                <input type="text" name="perfil"/>
                <br></br>
                <hr>
                </hr>
                <label id="user">Usuário:</label> 
                <input type="text" placeholder="Qual será seu usuário no sistema?" name="login"/>
                <br></br>
                <hr>
                </hr>
                <label id="senha">Senha:</label> 
                <input type="password" name="senha"/>
                <br></br>
                <hr>
                </hr>
                <label id="adm">Senha admin:</label> 
                <input id="txtAdm" type="password" name="senhaAdmin"/>
                <br id="adm"></br>
                <hr id="hrAdm">
                </hr>
                <br></br>
                <label id="filial">Filial:</label> 
                <input type="text" name="filial"/>
                <br></br>
                <hr>
                </hr>
                <label id="codfilial">Código Filial:</label> 
                <input type="text" name="codigo"/>
                <br></br>
                <hr>
                </hr>
                <input type="submit" id="cadastrar" value="cadastrar">
                <br></br>
                <a href="UsuarioController?acao=listar">Listar Funcionários</a>
            </form>
        </section>
    </body>
</html>
