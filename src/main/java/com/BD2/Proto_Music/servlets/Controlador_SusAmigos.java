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
@WebServlet(name = "Controlador_SusAmigos", urlPatterns = {"/Controlador_SusAmigos"})
public class Controlador_SusAmigos extends HttpServlet {

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
            out.println("<title>Servlet Controlador_SusAmigos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_SusAmigos at " + request.getContextPath() + "</h1>");
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
        String email = request.getParameter("usuario");
        Conexion conexion = new Conexion();
        ArrayList<Usuario> mis_amigos = conexion.retonarSusAmigos(email);
        PrintWriter out = response.getWriter();
        if(mis_amigos.size()>0)
        {
            for (int i = 0; i < mis_amigos.size(); i++) 
            {
                out.print("<hr/>");
                out.print("<label><a href=\"perfil_amigo.jsp?usuario="+email+"&amigo="+mis_amigos.get(i).getEmail()+"\">"+mis_amigos.get(i).getNombre()+" "+
                                                mis_amigos.get(i).getApellido1()+" "
                                +mis_amigos.get(i).getApellido2()+"</a></label><br/>");
                out.print("<label>Email:" + mis_amigos.get(i).getEmail()+"</label><br/>");
                out.print("<label>"+mis_amigos.get(i).getEdad()+" a&ntilde;os</label><br/>");
                out.print("<label>"+mis_amigos.get(i).getPais()+"</label><br/>");
                out.print("<hr/>");



            }
        }
        else
        {
            out.print("<h1>"+email+" no tiene amigos</h1>");
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
