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
        
        <label>Nombre</label><br/>
        <input type="text" name="nombre" id="nombre"><br/>
        <label>Apellido 1</label><br/>
        <input type="text" name="apellido1" id="apellido1"><br/>
        <label>Apellido 2</label><br/>
        <input type="text" name="apellido2" id="apellido2"><br/>
        <label>Edad</label><br/>
        <input type="text" name="edad" id="edad"><br/>
        <label>Pais</label><br/>
        <input type="text" name="pais" id="pais"><br/>
        <label>Usuario</label><br/>
        <select name="tipo" id="tipo">
            <option value="Usuario">Usuario</option>
            <option value="Artista">Artista</option>
        </select><br/>
        <label>Email</label><br/>
        <input type="text" name="email" id="email"><br/>
        <label>Password</label><br/>
        <input type="password" name="password" id="password"><br/>
        <label>Confirmar Password</label><br/>
        <input type="password" name="confirmPassword" id="confirmPassword"><br/>
        
        <input type="submit" id="Registrar" value="Registrar" >
        
        
    </body>
</html>
