<%-- 
    Document   : listarFuncionario
    Created on : 20/05/2020, 17:24:42
    Author     : rafae
--%>

<%@page import="br.senac.sp.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%    //Acessando a session e pegando objeto usuario
    Usuario usuario = (Usuario) request.getSession().getAttribute("loginController");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de funcionários</title>
        <link rel="stylesheet" href="css/listaUsuario.css">
    </head>
    <body>
        <a id="txtCad" href="UsuarioController?acao=novo">Cadastrar Usuário</a>
        <section id="fundoTabela">
            <form action="UsuarioController" method="GET">
                <input type="hidden" name="acao" value="listar"/> 
                <table>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Perfil</th>
                        <th>Login</th>
                        <th>Senha</th>
                        <th>Senha Administrador</th>
                        <th>Filial</th>
                        <th>Código Filial</th>
                    </tr>
                    <c:forEach var="u" items="${user}">
                        <tr>
                            <td>${u.nome}</td>
                            <td>${u.cpf}</td>
                            <td>${u.perfil}</td>
                            <td>${u.login}</td>
                            <td><input style="text-align: center;" type="password" value="${u.senha}"/></td>
                            <td><input style="text-align: center;" type="password" value="${u.senhaAdmin}"/></td>
                            <td>${u.filial}</td>
                            <td>${u.idfilial}</td>
                            <td><a href="javascript:confirmarAlteracao(${u.id});">EDITAR</a>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </section>
        
        <input type="submit" id="cadastrar" value="cadastrar">
                
        
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
        
        <script>
            function confirmarExclusao(id) {
                if (confirm('Deseja realmente excluir esse funcionário?')) {
                    location.href = "UsuarioController?acao=excluir&id=" + id;
                }
            }
            function confirmarAlteracao(id) {
                if (confirm('Deseja realmente alterar esse funcionário?')) {
                    location.href = "UsuarioController?acao=alterar&id=" + id;
                }
            }
        </script>

    </body>
</html>
