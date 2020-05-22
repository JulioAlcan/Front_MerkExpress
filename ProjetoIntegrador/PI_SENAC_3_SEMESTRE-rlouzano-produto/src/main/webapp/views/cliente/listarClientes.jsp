
<%@page import="br.senac.sp.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%    //Acessando a session e pegando objeto usuario
    Usuario usuario = (Usuario) request.getSession().getAttribute("loginController");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
        <link rel="stylesheet" href="css/cliente.css">

    </head>
    <body>
        <form action="ClienteController" method="GET">
            <input type="hidden" name="acao" value="listar"/>
            <a id="nc" href="ClienteController?acao=novo">Novo Cliente</a>
            <p id="lc">Lista de Clientes</p>
            <section id="fundoTabela">
            <table>
                <tr>
                    <th>Nome</th>
                    <th>Sexo</th>
                    <th>CPF</th>
                    <th>RG</th>
                    <th>Data Nascimento</th>
                    <th>Email</th>
                    <th>Telefone</th>
                    <th>Estado Civil</th>
                    <th>Endereço</th>
                    <th>Número</th>
                    <th>Complemento</th>
                    <th>CEP</th>
                    <th>Cidade</th>
                    <th>UF</th>
                    <th>Método</th>
                </tr>
                <c:forEach var="c" items="${cliente}">             
                    <tr>
                        <td>${c.nome}</td>
                        <td>${c.sexo}</td>
                        <td>${c.cpf}</td>
                        <td>${c.rg}</td>
                        <td>${c.dataNascimento}</td> 
                        <td>${c.estadoCivil}</td>
                        <td>${c.email}</td>
                        <td>${c.telefone}</td>
                        <td>${c.logradouro}</td>
                        <td>${c.numeroCasa}</td>
                        <td>${c.complemento}</td>
                        <td>${c.CEP}</td>
                        <td>${c.cidade}</td>
                        <td>${c.uf}</td>
                        <td><a href="javascript:confirmarExclusao(${c.idCliente});">EXCLUIR</a> - <a href="javascript:confirmarAlteracao(${c.idCliente});">ALTERAR</a></td>
                    </tr>
                </c:forEach>
            </table>
            </section>
        </form>
        
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
            function confirmarExclusao(idCliente) {
                if (confirm('Deseja realmente excluir esse cliente?')) {
                    location.href = "./ClienteController?acao=excluir&idCliente=" + idCliente;
                }
            }
            function confirmarAlteracao(idCliente) {
                if (confirm('Deseja realmente alterar esse cliente?')) {
                    location.href = "./ClienteController?acao=alterar&idCliente=" + idCliente;
                }
            }
        </script>
    </body>
</html>


