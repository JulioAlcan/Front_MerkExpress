
<%@page import="br.senac.sp.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    //Acessando a session e pegando objeto usuario
    Usuario usuario = (Usuario) request.getSession().getAttribute("loginController");
%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF8">
        <title>Merk | Cliente</title>
        <link rel="stylesheet" href="css/cliente.css">
    </head>

    <body>
        <form action="ClienteController" method="GET">
            <input type="hidden" name="acao" value="Salvar"/>
            <input type="hidden" name="idCliente" value="${c.idCliente}"/>
            <label>Nome:*</label><br/>
            <input type="text" name="nome" value="${c.nome}"> <br/>

            <label>sexo:*</label><br/>
            <input type="text" name="sexo" value="${c.sexo}"> <br/> 

            <label>CPF:*</label><br/>
            <input type="text" name="CPF" value="${c.cpf}"> <br/> 

            <label>rg*</label><br/>
            <input type="text" name="rg" value="${c.rg}"> <br/>  

            <label>estadoCivil:*</label><br/>
            <input type="text" name="estadoCivil" value="${c.estadoCivil}"> <br/> 

            <label>Telefone:*</label><br/>
            <input type="text" name="telefone" value="${c.telefone}"> <br/>  

            <label>Data de nasc:*</label><br/>
            <input type="text" name="dataNascimento" value="${c.dataNascimento}"> <br/> 

            <label>email:*</label><br/>
            <input type="text" name="email" value="${c.email}"> <br/>           

            <label>logradouro:*</label><br/>
            <input type="text" name="logradouro" value="${c.logradouro}"> <br/>            

            <label>numeroCasa:*</label><br/>
            <input type="text" name="numeroCasa" value="${c.numeroCasa}"> <br/>             

            <label>Complemento:*</label><br/>
            <input type="text" name="complemento" value="${c.complemento}"> <br/> 

            <label>CEP:*</label><br/>
            <input type="text" name="CEP" value="${c.CEP}"> <br/>         

            <label>cidade:*</label><br/>
            <input type="text" name="cidade" value="${c.cidade}"> <br/>       

            <label>uf:*</label><br/>
            <input type="text" name="uf" value="${c.uf}"> <br/> 

            <input type="submit"  value="Salvar"/>
                   </br></br>
            </br></br>
            <input type="reset"  value="Limpar">
        </form>
    </body>
</html>