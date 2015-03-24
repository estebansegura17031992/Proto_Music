<%-- 
    Document   : registroArtista
    Created on : Mar 24, 2015, 1:02:11 AM
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
        <h1>Registro de Artista o Grupo Musical</h1>
        
        <label>Nombre del Artista/Grupo</label><br/>
        <input type="text" name="nombre" id="nombre"><br/>
        <label>Genero</label><br/>
        <input type="text" name="genero" id="genero"><br/>
        <label>Sitio Web</label><br/>
        <input type="text" name="sitioWeb" id="sitioWeb"><br/>
        <label>Pais</label><br/>
        <input type="text" name="pais" id="pais"><br/>
        <label>Fecha de Conformacion</label><br/>
        <input type="text" name="fechaConformacion" id="fechaConformacion"><br/>
        <label>Estado</label><br/>
        <input type="text" name="estado" id="estado"><br/>
        <label>Email</label><br/>
        <input type="text" name="email" id="email"><br/>
        <label>Password</label><br/>
        <input type="password" name="password" id="password"><br/>
        <label>Confirmar Password</label><br/>
        <input type="password" name="confirmPassword" id="confirmPassword"><br/>
        
        <input type="submit" id="RegistrarArtista" value="Registrar" >
        <hr/>
        <a href="registroUsuario.jsp">¿Eres un usuario?</a>
    </body>
</html>
