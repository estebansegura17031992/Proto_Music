<%-- 
    Document   : buscar
    Created on : Mar 18, 2015, 12:27:57 AM
    Author     : esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/basic.css" rel="stylesheet" type="text/css"/>
        <script src="javascript/jquery-2.1.3.js" type="text/javascript"></script>
        <script src="javascript/funciones.js" type="text/javascript"></script>
        
        <script>
            function getUrlParameter(sParam)
            {
                var sPageURL = window.location.search.substring(1);
                var sURLVariables = sPageURL.split('&');
                for (var i = 0; i < sURLVariables.length; i++) 
                {
                    var sParameterName = sURLVariables[i].split('=');
                    if (sParameterName[0] == sParam) 
                    {
                        return sParameterName[1];
                    }
                }
            }
            var usuario = getUrlParameter('usuario');
            var url_perfil = "perfil.jsp?usuario="+usuario;
            $(document).ready(function(){
                $("#enlace_perfl").each(function(i){
                   $(this).attr("href",url_perfil);
                });
            });
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proto Music</title>
    </head>
    <body class="body_intro">
        <div id="header">
             <ul class="ul_header">
                <li><a href="" id="enlace_buscar">Buscar </a> </li>
                <li><a href="" id="enlace_perfl">Perfil</a> </li>
                <li><a href="">Salir</a> </li>
            </ul>
        </div>
        
         <div id="menu">
            <div id="info">
                <div id="info">
                </div>
            </div>
            <ul class="ul_menu">
                <li><a href="">Artistas</a></li>
                <li><a href="">Amigos</a></li>
                <li><a href="">Fans Clubs</a></li>
                <li><a href="">Todo</a></li>
                
            </ul>
        </div>
        <div id="div_noticias">
            <div id="div_noticias_contenido">
                <label>Buscar:</label><br/>
                <input type="text" id="buscar"/><br/>
                <input type="submit" id="buscarPalabra" value="Buscar"/>
            </div>
        </div>
    </body>
</html>
