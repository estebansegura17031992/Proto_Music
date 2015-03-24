/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BD2.Proto_Music.servlets;

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
@WebServlet(name = "Controlador_SuPerfilArtista", urlPatterns = {"/Controlador_SuPerfilArtista"})
public class Controlador_SuPerfilArtista extends HttpServlet {

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
            out.println("<title>Servlet Controlador_SuPerfilArtista</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_SuPerfilArtista at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException {
        String email_artista = request.getParameter("artista");
        
        Conexion conexion = new Conexion();
        /*ArrayList<Usuario> usuario_obtenido = conexion.obtenerNodo_Artista(email_artista);
        PrintWriter out = response.getWriter();
        for (int i = 0; i < usuario_obtenido.size(); i++) 
        {
            out.print("<h1> Informacion Basica</h1>");
            out.print("<label> Nombre: "+usuario_obtenido.get(i).getNombre()+"</label><br/>");
            out.print("<label>Pais: "+usuario_obtenido.get(i).getPais()+"</label><br/>");
            out.print("<label>Email:" + usuario_obtenido.get(i).getEmail()+"</label><br/>");
//            out.print("<input type='submit' value='Agregar a mis amigos' id='agregar_amigo'/>");
        }*/
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
        processRequest(request, response);
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
