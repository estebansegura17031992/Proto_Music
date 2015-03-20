/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function()
    {
       $("#Registrar").click(function()
        {
               var nombre= $("#nombre").val();
               var apellido1 = $("#apellido1").val();
               var apellido2 = $("#apellido2").val();
               var edad = $("#edad").val();
               var pais = $("#pais").val();
               var tipo = $("#tipo option:selected").text(); 
               var email = $("#email").val();
               var password = $("#password").val();
               var confirmPassword = $("#confirmPassword").val();
              
               $.ajax({
                   type: 'POST',
                   data: {nombre: nombre, apellido1: apellido1, apellido2: apellido2, edad: edad,
                          pais: pais,tipo: tipo, email: email, password:password, 
                          confirmPassword: confirmPassword},
                   url: 'Controlador_Registro',

                   success: function(result)
                   {
                       alert("Registro Exitoso");
                       window.location.href = "index.jsp";

                   }
                   
               });
        }); 
        
        $("#Entrar").click(function()
        {
            var email = $("#email_index").val();
            var password = $("#password_index").val();
              
            $.ajax({
            type: 'POST',
            data: { email: email, password: password},
            url: 'Controlador_Identificacion',

            success: function(result)
            {
                window.location.href = "perfil.jsp?usuario="+email;
                
            }
            });
        }); 
        
        

        
       $("#buscarPalabra").click(function()
       {
            //var usuario = getUrlParameter('usuario');
            var palabra = $("#txtBuscar").val();
            var tipoBusqueda = $("#tipo_busqueda option:selected").text();
          
            $.ajax(
            {
                type:'GET',
                data:{usuario: usuario,palabra: palabra, tipoBusqueda: tipoBusqueda},
                url: 'Controlador_Buscar',
                
                success: function(result)
                {
                    $("#div_resultados").html(result);
                    $("#div_resultados").on("click","#agregar_amigo",function()
                    {
                        
       
                        var usuario = getUrlParameter('usuario');
                        var palabra = $("#txtBuscar").val();
                        var tipoBusqueda = $("#tipo_busqueda option:selected").text();

                        $.ajax(
                        {
                            type:'POST',
                            data:{usuario: usuario,palabra: palabra, tipoBusqueda: tipoBusqueda},
                            url: 'Controlador_Relacionar',

                            success: function(result)
                            {
                                alert("Amigo Agregado");
                            }
                        });
           
       
                    });
                }
            });
           
       });
       
    
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
    });

