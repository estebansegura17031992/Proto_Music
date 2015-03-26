/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BD2.Proto_Music.servlets;

import com.BD2.Proto_Music.negocios.Disco;
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
@WebServlet(name = "Controlador_SusDiscos2", urlPatterns = {"/Controlador_SusDiscos2"})
public class Controlador_SusDiscos2 extends HttpServlet {

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
            out.println("<title>Servlet Controlador_SusDiscos2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_SusDiscos2 at " + request.getContextPath() + "</h1>");
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
       String usuario = request.getParameter("usuario");
        Conexion conexion = new Conexion();
        ArrayList<Disco> mis_discos = conexion.retonarMisDiscos(usuario);
        PrintWriter out = response.getWriter();
        if(!mis_discos.isEmpty())
        {
            out.print("<h1>Numero de discos: "+mis_discos.size()+"</h1>");
            for (int i = 0; i < mis_discos.size(); i++) 
            {
                
                out.print("<hr/>");
                out.print("<label> Nombre: "+mis_discos.get(i).getNombre()+"</label><br/>");
                out.print("<label>Genero: "+mis_discos.get(i).getGenero()+"</label><br/>");
                out.print("<label>Publicacion:" + mis_discos.get(i).getPublicacion()+"</label><br/>");
                out.print("<label>Discografica"+mis_discos.get(i).getDiscografia()+" a&ntilde;os</label><br/>");
                out.print("<label>Duracion: "+mis_discos.get(i).getDuracion()+"</label><br/>");
                out.print("<label>Productor"+mis_discos.get(i).getProductor()+"</label><br/>");
                out.print("<hr/>");



            }
        }
        else
        {
           out.print("<h1>No tiene discos creados</h1>");
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
