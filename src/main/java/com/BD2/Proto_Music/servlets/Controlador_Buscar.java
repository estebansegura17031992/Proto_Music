/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BD2.Proto_Music.servlets;

import com.BD2.Proto_Music.negocios.Artista;
import com.BD2.Proto_Music.negocios.Usuario;
import com.BD2.Proto_Music.servicios.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esteban
 */
@WebServlet(name = "Controlador_Buscar", urlPatterns = {"/Controlador_Buscar"})
public class Controlador_Buscar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador_Buscar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_Buscar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/plain");
        String usuario = request.getParameter("usuario");
        String palabra = request.getParameter("palabra");
        String tipoBusqueda = request.getParameter("tipoBusqueda");

        Conexion conexionNeo4j = new Conexion();
        
        if(tipoBusqueda.equals("Amigos"))
        {
            ArrayList<Usuario> usuario_obtenido=null;
            System.out.println("aqui: "+tipoBusqueda);

            usuario_obtenido = conexionNeo4j.obtenerNodo(palabra);

                System.out.println("salgo aqui");
                PrintWriter out = response.getWriter();
                if(!usuario_obtenido.isEmpty())
                {
                    for (int i = 0; i < usuario_obtenido.size(); i++) 
                    {
                        out.print("<fieldset class='login'>");
                        out.print("<label> Nombre: "+usuario_obtenido.get(i).getNombre()+"</label><br/>");
                        out.print("<label>Apellido1: "+usuario_obtenido.get(i).getApellido1()+"</label><br/>");
                        out.print("<label>Apellido2: "+usuario_obtenido.get(i).getApellido2()+"</label><br/>");
                        out.print("<label>Edad: "+usuario_obtenido.get(i).getEdad()+"</label><br/>");
                        out.print("<label>Pais: "+usuario_obtenido.get(i).getPais()+"</label><br/>");
                        out.print("<label>Email:" + usuario_obtenido.get(i).getEmail()+"</label><br/>");
                        out.print("<input type='submit' value='Agregar a mis amigos' id='agregar_amigo' class='button'/>");
                        out.print("<br/>");
                        out.print("</fieldset>");

                    }
                }
                else
                {
                    out.print("<label>No se encontraron resultados</label>");

                }
        }
        else if(tipoBusqueda.equals("Artistas"))
        {
            System.out.println("Buscando artistas");
            ArrayList<Artista> artista_obtenido=null;
            artista_obtenido = conexionNeo4j.obtenerNodo_Artista(palabra);
            
            System.out.println("salgo aqui");
            PrintWriter out = response.getWriter();
            if(!artista_obtenido.isEmpty())
            {
                System.out.println("Usuario"+artista_obtenido);
                for (int i = 0; i < artista_obtenido.size(); i++) 
                {
                    out.print("<label> Nombre: "+artista_obtenido.get(i).getNombre()+"</label><br/>");
                    out.print("<label>Genero: "+artista_obtenido.get(i).getGenero()+"</label><br/>");
                    out.print("<label>Pais: "+artista_obtenido.get(i).getPais()+"</label><br/>");
                    out.print("<label>Fecha de Conformacion: "+artista_obtenido.get(i).getFechaConformacion()+"</label><br/>");
                    out.print("<label>Estado: "+artista_obtenido.get(i).getEstado()+"</label><br/>");
                    out.print("<label>Sitio Web: " + artista_obtenido.get(i).getSitioWeb()+"</label><br/>");
                    out.print("<input type='submit' value='Seguir' id='agregar_artista' class='button'/>");
                    
                }
            }
            else
            {
                out.print("<label>No se encontro ningun artista</label>");
            }
    
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
