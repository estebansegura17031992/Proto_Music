<%-- 
    Document   : perfilArtista
    Created on : Mar 24, 2015, 2:46:47 AM
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
        
            /*OBTENCION DE PARAMETROS*/
            var usuario = getUrlParameter('usuario');
            
            /*RUTAS*/
            var urlCrearDisco = "crearDisco.jsp?usuario="+usuario;
            var url_mis_seguidores = "mis_seguidores.jsp?usuario="+usuario;
            var url_mis_artistas = "mis_artistas.jsp?usuario="+usuario;
            var url_mis_discos = "mis_discos.jsp?usuario="+usuario;
            
             $(document).ready(function()
            {
                $.ajax(
                {
                    type: 'GET',
                    data: {usuario: usuario},
                    url:'Controlador_PerfilArtista',
                    success:function(result)
                    {
                        $('#div_noticias_contenido').html(result);
                    }
                    
                    
                    
                });
                
            });
            $(document).ready(function(){
                $("#enlaceCrearDisco").each(function(i){
                   $(this).attr("href",urlCrearDisco);
                   
                });
            });
           
            $(document).ready(function(){
               
                $("#enlace_misSeguidores").each(function(i){
                    $(this).attr("href",url_mis_seguidores);
                }); 
            });
            
            $(document).ready(function(){
               
                $("#enlace_misArtistas").each(function(i){
                    $(this).attr("href",url_mis_artistas);
                }); 
            });
            
             $(document).ready(function(){
               
                $("#enlace_misDiscos").each(function(i){
                    $(this).attr("href",url_mis_discos);
                }); 
            });
            
            
            
        </script>
        <title>Proto Music</title>
    </head>
    <body class="body_intro">
        <div id="header">
             <ul class="ul_header">
                <li><a href="" id="enlaceCrearDisco">Crear Disco </a> </li>
                <li><a href="" id="enlace_perfl">Perfil</a> </li>
                <li><a href="">Salir</a> </li>
            </ul>
        </div>
        <div id="menu">
            <header class="header_menu">Menu</header>
            <ul class="ul_menu">
                <li><a href="" id="enlace_misSeguidores">Mis Seguidores</a></li>
                <li><a href="" id="enlace_misDiscos">Mis Discos</a></li>
               
            </ul>
        </div>
        <div id="div_noticias">
            <div id="div_noticias_contenido">
            
            </div>
        </div>
    </body>
</html>
