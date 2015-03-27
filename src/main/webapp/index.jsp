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
        <h1>Proto Music</h1>
        <fieldset class="login">
            <label class="title" >Tipo</label><br/><br/>
            <label>Usuario</label>
            <input id="usuario" type="radio" name="tipo" value="Usuario">
            <label>Artista</label>
            <input id="artista" type="radio" name="tipo" value="Artista" ><br/><br/>
            <label>Correo</label><br/>
            <input type="text" name="email" id="email_index" class="input"><br/>
            <label>Password</label><br/>
            <input type="password" name="password" id="password_index" class="input"><br/>
            <input type="submit" id="Entrar" value="Entrar" class="button"><br/><br/>
            <a>Si es nuevo presione registrar</a><br/><br/>
            <div>
                <form method="POST" action="registroUsuario.jsp">
                <input type="submit" id="registro" value="Registrar" class="button2">
                </form>
            </div>
        </fieldset>
        
        <div id="respuesta">
            
            
        </div>
    </body>
</html>
