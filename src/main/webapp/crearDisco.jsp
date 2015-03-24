<%-- 
    Document   : crearDisco
    Created on : Mar 24, 2015, 2:54:35 AM
    Author     : esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
            var url_mis_amigos = "mis_amigos.jsp?usuario="+usuario;
            var url_mis_artistas = "mis_artistas.jsp?usuario="+usuario;
            
            $(document).ready(function(){
                $("#enlaceCrearDisco").each(function(i){
                   $(this).attr("href",urlCrearDisco);
                   
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
            
            
            $(document).ready(function()
            {
                $("#CrearDisco").click(function()
                {
                    var nombre= $("#nombre").val();
                    var genero = $("#genero").val();
                    var publicacion = $("#publicacion").val();
                    var discografica = $("#discografica").val();
                    var duracion = $("#duracion").val();
                    var productor = $("#productor").val();

                   $.ajax({
                       type: 'POST',
                       data: {usuario: usuario,nombre: nombre, genero: genero, publicacion: publicacion, 
                           discografica: discografica,duracion: duracion,productor: productor},
                       url: 'Controlador_CrearDisco',

                       success: function(result)
                       {
                           alert("El disco se creo correctamente");
                           window.location.href = "perfilArtista.jsp?usuario="+usuario;

                       }

                   });

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
            <ul class="ul_menu">
                <li><a href="" id="enlace_misArtistas">Mis Seguidores</a></li>
                <li><a href="" id="enlace_misAmigos">Discos</a></li>
               
            </ul>
        </div>
        <div id="div_noticias">
            <div id="div_noticias_contenido">
                <h1>Crear Disco</h1>
        
                <label>Nombre del Disco</label><br/>
                <input type="text" name="nombre" id="nombre"><br/>
                <label>Genero</label><br/>
                <input type="text" name="genero" id="genero"><br/>
                <label>Publicacion</label><br/>
                <input type="text" name="publicacion" id="publicacion"/><br/>
                <label>Discografica Web</label><br/>
                <input type="text" name="discografica" id="discografica"><br/>
                <label>Duracion</label><br/>
                <input type="text" name="duracion" id="duracion"><br/>
                <label>Productor(es)</label><br/>
                <input type="text" name="productor" id="productor"><br/>

                <input type="submit" id="CrearDisco" value="Crear Disco" >
            </div>
        </div>
    </body>
</html>
