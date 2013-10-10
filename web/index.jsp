<%-- 
    Document   : index
    Created on : Oct 10, 2013, 2:59:33 PM
    Author     : Fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
        
        
        <form class="form-horizontal" action="MongoServlet" role="form">
            <label for="nome">Nome: </label>
            <input type="text" id="nome" placeholder="Nome" name="nome"/><br>
            <label for="email">Email: </label>
            <input type="text" id="email" placeholder="Email" name="email"/><br>
            <label for="senha">Senha: </label>
            <input type="password" id="senha" placeholder="Senha" name="senha"/><br>
            <label for="agente">É agente de viagens? </label>
            <input type="radio" name="agente" value="s"> Sim
            <input type="radio" name="agente" value="n" checked> Não<br>
            <div id="agencia">
                <label for="nomeAgencia">Nome da agência: </label>
                <input type="text" id="nomeAgencia" placeholder="Nome da agência" name="nomeAgencia"/><br>
                <label for="endereco">Endereço da agência: </label>
                <input type="text" id="endereco" placeholder="Endereco da agência" name="endereco"/><br>
                <label for="tel">Telefone: </label>
                <input type="text" id="tel" placeholder="Telefone da agência" name="tel"/><br>
            </div>
            <button type="submit" id="button">Enviar</button>
        </form>
    </body>
    
    <script>
        $(document).ready(function() {
            $('#agencia').hide();
            $('input[name=agente]').click(function (){
                if($(this).val()==='s'){
                    $('#agencia').show();
                } else {
                    $('#agencia').hide();
                }
            });
        });
    </script>
</html>
