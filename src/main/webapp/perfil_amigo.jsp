<%-- 
    Document   : perfil_amigo
    Created on : Mar 22, 2015, 5:09:20 PM
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
            /*VARIABLES*/
            var usuario = getUrlParameter('usuario');
            var usuario_amigo = getUrlParameter('amigo');
            var url_perfil = "perfil.jsp?usuario="+usuario;
            var url_buscar = "buscar.jsp?usuario="+usuario;
            var url_sus_amigos = "sus_amigos.jsp?usuario="+usuario+"&amigo="+usuario_amigo;
            var url_sus_artistas = "sus_artistas.jsp?usuario="+usuario+"&amigo="+usuario_amigo;
            
            /*CARGAR INFORMACION EN LA PAGINA*/
            $(document).ready(function()
            {
                $.ajax(
                {
                    type: 'GET',
                    data: {usuario_amigo: usuario_amigo},
                    url:'Controlador_SuPerfil',
                    success:function(result)
                    {
                        $('#div_noticias_contenido').html(result);
                    }
                    
                    
                    
                });
                
            });
            
            /*-------------------------------*/
            /*LINKS DEL PERFIL PRINCIPAL*/
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
           
           /*---------------------------------------------------*/
           /*LINK DEL PERFIL LATERAL*/
            $(document).ready(function(){
               
                $("#enlace_susAmigos").each(function(i){
                    $(this).attr("href",url_sus_amigos);
                }); 
            });
            $(document).ready(function(){
               
                $("#enlace_susArtistas").each(function(i){
                    $(this).attr("href",url_sus_artistas);
                }); 
            });
            /*-------------*/
        </script>
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
            <header class="header_menu">Menu</header>
            <div id="info">
                <div id="info">
                </div>
            </div>
            <ul class="ul_menu">
                <li><a href="" id="enlace_susArtistas">Sus Artistas</a></li>
                <li><a href="" id="enlace_susAmigos">Sus Amigos</a></li>
                <li><a href="">Sus Fans Clubs</a></li>
               
            </ul>
        </div>
        <div id="div_noticias">
            <div id="div_noticias_contenido">
            
            </div>
        </div>
    </body>
</html>
