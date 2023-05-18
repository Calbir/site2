<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>QIso</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css"/>
        <link href="img/rubi3.png" rel="icon">
    </head>
    <body style="background-image: url(img/fundo2.jpg); background-size: 10%;">
        <img src="img/logo2.png" width="200" alt="QIso"/>
        
        <form action="login_controller" method="post">
            
            <input style="color: red; background-color: #660000;" type="text" name="user" id="user" class="fields" placeholder="Digite seu nome" required>
            <br><br>
            <input style="color: red; background-color: #660000;" type="number" name="pass" id="pass" class="fields" placeholder="Coloque sua senha" required>
            <br><br>
            
            <input style="color: red; background-color: #660000;" type="submit" value="Entrar"> 
            
        </form>
        <input style="color: red; background-color: #660000;" type="button" value="Registrar" onclick="window.location.href='registro.jsp'">
        
    </body>
</html>
