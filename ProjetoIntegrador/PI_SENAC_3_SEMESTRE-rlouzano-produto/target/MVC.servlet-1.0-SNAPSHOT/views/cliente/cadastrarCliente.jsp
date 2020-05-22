<%-- 
    Document   : cadastrarCliente
    Created on : 20/05/2020, 15:14:49
    Author     : rafae
--%>

<%@page import="br.senac.sp.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    //Acessando a session e pegando objeto usuario
    Usuario usuario = (Usuario) request.getSession().getAttribute("loginController");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Merk | Cadastro Cliente</title>
        <link rel="stylesheet"  href="css/cadCliente.css">
    </head>
    <body>
        <p id="titulo">Cadastrar cliente</p>
        <section id="fundo">
            <form action="ClienteController" method="GET">
                <input type="hidden" name="acao" value="Cadastrar"/>
                <br/>
                <label id="nome">Nome:</label>
                <input  type="text" name="nome" ><br/> <hr/>

                <label id="sexo">Sexo:</label>
                <input  type="text" name="sexo" > <br/> <hr/>

                <label id="cpf">CPF:</label>
                <input  type="text" name="CPF" > <br/> <hr/>

                <label id="rg">RG:</label>
                <input  type="text" name="rg" > <br/> <hr/>  

                <label id="ec">Estado Civil:</label>
                <input  type="text" name="estadoCivil" > <br/> <hr/>

                <label id="tel">Telefone:</label>
                <input  type="text" name="telefone" > <br/> <hr/>  

                <label id="dn">Data de Nasc:</label>
                <input  type="text" name="dataNascimento" > <br/> <hr/>

                <label id="email">Email:</label>
                <input  type="text" name="email"> <br/> <hr/>         

                <label id=log">Logradouro:</label>
                <input id="log" type="text" name="logradouro"> <br/> <hr/>     
                
                <label id="nc">Número Casa:</label>
                <input type="text" name="numeroCasa" > <br/> <hr/>          

                <label id="comp">Complemento:</label>
                <input  type="text" name="complemento"> <br/> <hr/>

                <label id="cep">CEP:</label>
                <input  type="text" name="CEP" > <br/> <hr/>        
                
                <label id="cid">Cidade:</label>
                <input  type="text" name="cidade"> <br/> <hr/>    

                <label id="uf">UF:</label>
                <input  type="text" name="uf" > <br/> <hr/> 

                <input type="submit" id="cadastrar" value="Cadastrar"
                       </br></br>
                <a href="ClienteController?acao=cliente">Listar Clientes</a>
            </form>
            
        </section>
        
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
        
    </body>
</html>
