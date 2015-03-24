<%-- 
    Document   : perfil_artista
    Created on : Mar 23, 2015, 9:03:04 PM
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
            
            /*VARIABLES DINAMICAS*/
            var usuario = getUrlParameter('usuario');
            var artista = getUrlParameter('artista');
            var url_perfil = "perfil.jsp?usuario="+usuario;
            var url_buscar = "buscar.jsp?usuario="+usuario;
            var url_sus_seguidores = "sus_seguidores.jsp?usuario="+usuario+"&artista="+artista;
            var url_sus_discos = "sus_discos.jsp?usuario="+usuario+"&artista="+artista;
           
           /*CARGAR INFORMACION EN LA PAGINA*/
            $(document).ready(function()
            {
                $.ajax(
                {
                    type: 'GET',
                    data: {artista: artista},
                    url:'Controlador_SuPerfilArtista',
                    success:function(result)
                    {
                        $('#div_noticias_contenido').html(result);
                    }
                    
                    
                    
                });
                
            });
            /*------------------------------------*/
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
               
                $("#enlace_susSeguidores").each(function(i){
                    $(this).attr("href",url_sus_seguidores);
                }); 
            });
            
            $(document).ready(function(){
               
                $("#enlace_susDiscos").each(function(i){
                    $(this).attr("href",url_sus_discos);
                }); 
            });
            /*----------------------------------------------------*/
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
            <div id="info">
                <div id="info">
                </div>
            </div>
            <ul class="ul_menu">
                <li><a href="" id="enlace_susSeguidores">Seguidores</a></li>
                <li><a href="" id="enlace_susDiscos">Discos</a></li>
               
            </ul>
        </div>
        <div id="div_noticias">
            <div id="div_noticias_contenido">
            
            </div>
        </div>
    </body>
</html>
