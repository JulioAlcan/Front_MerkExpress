<%@page import="br.senac.sp.dao.vendaDAO"%>
<%@page import="br.senac.sp.model.Filial"%>
<%@page import="br.senac.sp.model.Usuario"%>
<%@page import="br.senac.sp.model.Relatorio"%>
<%@page import="br.senac.sp.dao.RelatorioDAO"%>
<%@page import="br.senac.sp.dao.ClienteDAO"%>
<%@page import="br.senac.sp.model.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.senac.sp.model.Venda"%>
<%@page import="java.util.List" %>
<%@page import="br.senac.sp.dao.produtoDAO"%>
<%@page import="br.senac.sp.model.produto"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    //Acessando a session e pegando objeto usuario
    Usuario usuario = (Usuario) request.getSession().getAttribute("loginController");%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova venda</title>
        <link rel="stylesheet" href="css/venda.css">
    </head>
    <body>
        <form action="vendaController" method="GET">
            <div style="width: 1200px; margin-left: 300px; margin-right: 300px; ">
                <input type="search" id="buscaProd" placeholder=" Digite um nome ou código" name="pesquisa"
                       var="${param.pesquisa}">
                <input type="hidden" name="acao" value="vendas"/>
                <input class="pesquisa-produto"type="submit" value="Pesquisar">
            </div>
            <hr>
            </hr>
            <section id="fundoTabela">
            <table style="width: 1200px; margin-left: 50px; background-color: white; font: bold 15pt Avenir LT Std">
                <tr style="width: 1200px; margin-left: 50px; background-color: white; font: bold 15pt Avenir LT Std">
                    <th id="tituloNome">Nome</th>
                    <th id="tituloCateg">Código</th>
                    <th id="tituloCateg">Categoria</th>
                    <th id="tituloCodigo">Quantidade</th>
                    <th id="tituloCodigo">Quantidade Estoque</th>
                    <th id="tituloQtd">Preço Unitário</th>
                    <th id="tituloPreco">Usuário</th>
                    <th id="tituloPreco">Método</th>
                </tr>
                <jsp:useBean id="pdao" class="br.senac.sp.dao.produtoDAO"/>
                <c:forEach var="prod" items="${pdao.buscaPorPesquisa(param.pesquisa)}">
                    <c:if test="${param.pesquisa != null}">
                        <tr>
                            <td dir="rtl" id="nome" name="nome">${prod.nome}</td>
                            <td dir="rtl" id="id" name="codigo">${prod.codigo}</td>
                            <td dir="rtl" id="categ" name="categoria">${prod.categoria}</d>
                            <td dir="rtl" type="text" id="qtd" name="qtd">${1}</d>
                            <td dir="rtl" type="text" id="qtd" name="estoque">${prod.qtd}</d>
                            <td dir="rtl" id="valor" name="preco"><fmt:formatNumber value="${prod.preco}" type="currency"/></td>
                            <td dir="rtl" id="qtd" name="login"><%=usuario.getLogin()%></td>
                            <td dir="rtl">
                                <a href="vendaController?acao=incluir&nome=${prod.nome}&codigo=${prod.codigo}&categoria=${prod.categoria}&qtd=${1}&preco=${prod.preco}&login=<%=usuario.getLogin()%>">Incluir</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach> 
                <jsp:useBean id="cdao" class="br.senac.sp.dao.ClienteDAO"/>
                <c:forEach var="cli" items="${cdao.BuscaCliente(param.buscar)}">
                    <input type="hidden" name="nomecliente" >${c.nome}</td>
                    <input type="hidden" name="cpfcliente" >${c.cpf}</td>
                </c:forEach>
                </section>
            </table>
            <hr></hr>
        </table>
        <tbody>
        <table class="tbl" style="width: 600px; margin-left: 50px; font: bold 15pt Avenir LT Std; background-color: white; width: 1200px;">
            <thead>
                <tr>
                    <th class="colunas" >Método</th>
                    <th class="colunas">Nome</th>
                    <th class="colunas">Código</th>
                    <th class="colunas">Categoria</th>
                    <th class="colunas">Qtd.</th>
                    <th class="colunas">Preço</th>
                    <th class="colunas">Total</th>
                </tr>
            </thead>
            <%boolean ok = true;
                String nomefilial = null;
                double somaPreco = 0;
                vendaDAO vdao = new vendaDAO();
                List<Venda> vd = vdao.pegaTodos();
                for (Venda venda : vd) {%>
            <div class="lista">
                <tr>
                    <td>
                        <a name="idcarrinho" var="<%=venda.getId()%>" href="javascript:confirmaExclusao(<%=venda.getId()%>)">Excluir</a> - <a href="editarVendaController?idcarrinho=<%=venda.getId()%>">Editar Qtd</a>
                    </td>
                    <td class="linhas" type="text" name="nomeproduto"><%=venda.getNomeproduto()%></td>
                    <td class="linhas" type="text" name="codigoproduto"> <%=venda.getCodigoproduto()%></td>
                    <td class="linhas" type="text" name="categoriaproduto"><%=venda.getCategoria()%></td>
                    <td class="linhas" type="text" name="qtdvendido"><%=venda.getQtd()%></td>
                    <td class="linhas" type="text" name="precounitario"><fmt:formatNumber value="<%=venda.getPreco_unitario()%>" type="currency"/></td>
                    <td class="linhas" type="text" name="precototal"><fmt:formatNumber value="<%=venda.getQtd() * venda.getPreco_unitario()%>" type="currency"/></td>
                </tr>
            </div>
            <input type="hidden" var="${param.venda}"name="nomefilial" value="<%=venda.getNome_filial()%>"/>
            <%nomefilial = venda.getNome_filial();
                    somaPreco += venda.getQtd() * venda.getPreco_unitario();
                }%>
        </table>
        <%if (ok) {%>
        <section style="width: 290px; margin-left: 922px; margin-top: 10px;">
            <label style="width: 10px;font: bold 15pt Avenir LT Std; color: rgb(43, 43, 43);">TOTAL: R$</label>
            <input id="txtTotal"  value="<fmt:formatNumber value="<%=somaPreco%>"type="currency"/>">
        </section>
        <%}%>
    </tbody>
    <div class="carrinho" style="width: 1200px; margin-left: 300px; margin-right: 300px;"   >
        <div class="botoes-finalizar">
            <a id="finalizar" href="ClienteVendaController?acao=pagamento">PRÓXIMO</a></br>
            <a id="cancelar" href="javascript:confirmaCancelamento()">CANCELAR CARRINHO</a>

        </div>
    </div>
    
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
    
</form>   

<script type="text/javascript">
    function confirmaExclusao(id) {
        if (window.confirm('Tem certeza que deseja excluir')) {
            location.href = "vendaController?acao=excluir&id=" + id
        }
    }
    function confirmaCancelamento() {
        if (window.confirm('Tem certeza que deseja cancelar os itens do carrinho?')) {
            location.href = "vendaController?acao=cancelar"
        }
    }
</script>
</body>
</html>