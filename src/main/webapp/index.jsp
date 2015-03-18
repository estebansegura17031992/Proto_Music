<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html id="index">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/basic.css" rel="stylesheet" type="text/css"/>
        <script src="javascript/jquery-2.1.3.js" type="text/javascript"></script>
        <script src="javascript/funciones.js" type="text/javascript"></script>
        
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form method="POST" action="registroUsuario.jsp">
            <input type="submit" id="registro" value="Registrar">
            </form>
        </div>
        <h1>Proto Music</h1>
        <fieldset>
            <legend>Login</legend>
            <label>Correo</label><br/>
            <input type="text" name="email" id="email_index"><br/>
            <label>Password</label><br/>
            <input type="password" name="password" id="password_index"><br/>
            <input type="submit" id="Entrar" value="Entrar">
        </fieldset>
        
        <div id="respuesta">
            
            
        </div>
    </body>
</html>
