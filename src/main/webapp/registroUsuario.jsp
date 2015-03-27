<%-- 
    Document   : registro
    Created on : Mar 14, 2015, 5:35:41 PM
    Author     : esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Proto Music</title>
        
        <link href="css/basic.css" rel="stylesheet" type="text/css"/>
        <script src="javascript/jquery-2.1.3.js" type="text/javascript"></script>
        <script src="javascript/funciones.js" type="text/javascript"></script>
        
    </head>
    <body>
        <h1>Registro de Usuario</h1>
        <fieldset class="login">
            <label>Nombre</label><br/>
            <input type="text" name="nombre" id="nombre" class="input"><br/>
            <label>Apellido 1</label><br/>
            <input type="text" name="apellido1" id="apellido1" class="input"><br/>
            <label>Apellido 2</label><br/>
            <input type="text" name="apellido2" id="apellido2" class="input"><br/>
            <label>Edad</label><br/>
            <input type="text" name="edad" id="edad" class="input"><br/>
            <label>Pais</label><br/>
            <input type="text" name="pais" id="pais" class="input"><br/>
            <label>Email</label><br/>
            <input type="text" name="email" id="email" class="input"><br/>
            <label>Password</label><br/>
            <input type="password" name="password" id="password" class="input"><br/>
            <label>Confirmar Password</label><br/>
            <input type="password" name="confirmPassword" id="confirmPassword" class="input"><br/>
            <input type="submit" id="RegistrarUsuario" value="Registrar" class="button" >
            <hr/>
            <a href="registroArtista.jsp">¿Eres un artista o un grupo musical?</a>
        </fieldset>
    </body>
</html>
