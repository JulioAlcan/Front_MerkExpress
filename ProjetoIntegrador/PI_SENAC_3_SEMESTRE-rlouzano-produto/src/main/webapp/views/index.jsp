<%@page import="br.senac.sp.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP novo Page</title>
    </head>
    <body>
       <%@ include file="acao=login&acao=senha" %>
        <%
            //Acessando a session e pegando objeto usuario
            Usuario usuario = (Usuario) request.getSession().getAttribute("loginController");
        %>
    </body>
</html>
