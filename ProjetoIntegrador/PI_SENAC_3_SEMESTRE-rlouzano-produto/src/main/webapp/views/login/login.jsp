<%-- 
    Document   : login.jsp
    Created on : 21/04/2020, 17:04:13
    Author     : rafae
--%>


<%@page import="br.senac.sp.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.senac.sp.model.Usuario"%>

<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Merk | Login</title>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
    <section>
         <form method="POST" action="loginController" >
            <div>Inicie sua sessão na</div>
            <div id="merk">MerkExpress</div>
            <input type="hidden" name="id" >
            <input type="text" name="login" maxlength="10" placeholder="Usuário" >
            <span aria-label="Seu usuário é seu nome + o primeiro sobrenome">?</span>
            <hr>
            </hr>
            <input type="password" name="senha" id="senha" maxlength="10" placeholder="Senha" >
            <hr id="senha">
            </hr>
            <input type="submit" id="entrar" value="Entrar">
            <div><a href="esqueciSenha.html" id="linkSenha">Esqueci minha senha</a></div>
            <input type="hidden" name="acao" value="login"/>
        </form>
    </section>
    <form name="form_criarLogin" class="form_criarLogin" action="" method="POST">
        <section id="criarConta">
            <p>Não possui cadastro?</p>
            <section id="bordaCriar">
            <a id="criar" href="UsuarioController?acao=usuario">Criar Conta</a>
            </section>
        </section>
    </form>

    <script src="script.js"></script>
        
    </body>

</html>

