<%-- 
    Document   : mis_amigos
    Created on : Mar 21, 2015, 7:47:24 PM
    Author     : esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
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
            var url_buscar = "buscar.jsp?usuario="+usuario;
            var url_mis_amigos = "mis_amigos.jsp?usuario="+usuario;
            var url_mis_artistas = "mis_artistas.jsp?usuario="+usuario;
            $(document).ready(function(){
                $("#enlace_perfl").each(function(i){
                   $(this).attr("href",url_perfil);
                   
                });
            });
            $(document).ready(function(){
                $("#enlace_buscar").each(function(i){
                   $(this).attr("href",url_buscar);
                   
                });
            });
           
            $(document).ready(function(){
               
                $("#enlace_misAmigos").each(function(i){
                    $(this).attr("href",url_mis_amigos);
                }); 
            });
            
            $(document).ready(function(){
               
                $("#enlace_misArtistas").each(function(i){
                    $(this).attr("href",url_mis_artistas);
                }); 
            });
            
            $(document).ready(function(){
                $.ajax(
                {
                    type:'GET',
                    data:{usuario: usuario},
                    url: 'Controlador_MisAmigos',

                    success: function(result)
                    {
                        $("#div_noticias_contenido").html(result)
                    }
                });
            })
            
        </script>
        <title>Proto Music</title>
    </head>
    <body class="body_intro">
        <div id="header">
             <ul class="ul_header" >
                <li><a href="" id="enlace_buscar">Buscar </a> </li>
                <li><a href="" id="enlace_perfl">Perfil</a> </li>
                <li><a href="">Salir</a> </li>
            </ul>
        </div>
        <div id="menu">
            <header class="header_menu">Menu</header>
            <ul class="ul_menu">
                <li><a href="" id="enlace_misArtistas">Mis Artistas</a></li>
                <li><a href="" id="enlace_misAmigos">Mis Amigos</a></li>
                <li><a href="">Fans Clubs</a></li>
               
            </ul>
            <ul class="ul_menu">
                
               
            </ul>
        </div>
        <div id="div_noticias">
            
                <h1>Mis Amigos</h1>
            <div id="div_noticias_contenido">
                
            </div>
        </div>
    </body>
</html>
