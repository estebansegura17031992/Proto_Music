package com.BD2.Proto_Music.servicios;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author esteban
 */
public class Conexion {
    private String directorio;
    private Node nodo1;
    private Node nodo2;
    private Node nodo3;
    private Relationship conexion;
    private GraphDatabaseService base;
    private Transaction tx;
    private Label etiqueta;

    // Constructor:
    public Conexion() {
            this.setDirectorio("/var/lib/neo4j/data/graph.db");
            this.setConexion(null);
            this.setBase(null);
            this.setTx(null);
            
    }

    
    public enum NodeType implements Label
    {
        Usuario, Sigue,Artista,FanClub;
    }
    public void conectar()
    {
       
        this.setBase(new GraphDatabaseFactory().newEmbeddedDatabase(this.getDirectorio())); 
        this.registerShutdownHook(this.getBase()); 
    }

    public void desconectar() {
            this.getBase().shutdown(); }

    private void registerShutdownHook(final GraphDatabaseService graphDb) {
            Runtime.getRuntime().addShutdownHook( new Thread() {
                    @Override
                    public void run() { graphDb.shutdown(); } }); }

    @SuppressWarnings("deprecation")
    public void anadirNodo_Usuario(String nombre, String apellido1, String apellido2,
                                   String edad, String pais, String tipoCuenta,String email, String password) 
    {
        System.out.println("Tipo Cuenta: "+tipoCuenta);
        switch (tipoCuenta) {
            case "Usuario":
                System.out.println("Estoy en usuario");
                this.conectar();
                this.setTx(this.getBase().beginTx());
                try
                {
                    Node bdNode = this.getBase().createNode(NodeType.Usuario);
                    bdNode.setProperty("nombre", nombre);
                    bdNode.setProperty("apellido1", apellido1);
                    bdNode.setProperty("apellido2", apellido2);
                    bdNode.setProperty("edad", edad);
                    bdNode.setProperty("pais", pais);
                    bdNode.setProperty("tipoCuenta",tipoCuenta);
                    bdNode.setProperty("email", email);
                    bdNode.setProperty("password", password);
                    
                    this.getTx().success();
                    
                    
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error"+nombre+" "+apellido1+" "+
                            apellido2+" "+edad+" "+pais+" "+email+" "+password, 0);
                }
                finally
                {
                    this.getTx().finish();
                    this.desconectar();
                }   break;
            case "Artista":
                
                try
                {
                    System.out.println("Estoy en artista");
                    this.conectar();
                    System.out.println("conectado...");
                    this.setTx(this.getBase().beginTx());
                    System.out.println("Creando nodo");
                    Node bdNode = this.getBase().createNode(NodeType.Artista);
                    bdNode.setProperty("nombre", nombre);
                    bdNode.setProperty("apellido1", apellido1);
                    bdNode.setProperty("apellido2", apellido2);
                    bdNode.setProperty("edad", edad);
                    bdNode.setProperty("pais", pais);
                    bdNode.setProperty("tipoCuenta",tipoCuenta);
                    bdNode.setProperty("email", email);
                    bdNode.setProperty("password", password);
                    System.out.println("Propiedades agregadas");
                    this.getTx().success();
                    
                    
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error"+nombre+" "+apellido1+" "+
                            apellido2+" "+edad+" "+pais+" "+email+" "+password, 0);
            }
                finally
                {
                    this.getTx().finish();
                    this.desconectar();
                }   break;
            default:
                this.conectar();
                this.setTx(this.getBase().beginTx());
                try
                {
                    Node bdNode = this.getBase().createNode(NodeType.FanClub);
                    bdNode.setProperty("nombre", nombre);
                    bdNode.setProperty("apellido1", apellido1);
                    bdNode.setProperty("apellido2", apellido2);
                    bdNode.setProperty("edad", edad);
                    bdNode.setProperty("pais", pais);
                    bdNode.setProperty("tipoCuenta",tipoCuenta);
                    bdNode.setProperty("email", email);
                    bdNode.setProperty("password", password);
                    
                    this.getTx().success();
                    
                    
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error"+nombre+" "+apellido1+" "+
                        apellido2+" "+edad+" "+pais+" "+email+" "+password, 0);
            }
            finally 
            {
                this.getTx().finish();
                this.desconectar(); 
            }   break; 
        }
    
        
    }
    @SuppressWarnings("deprecation")
    public boolean autentificar(String email, String password) 
    {
        boolean retorno = false;
        this.conectar();
        this.setTx(this.getBase().beginTx());
        Node nodo_actual = existeNodoUsuario(email);
        if(nodo_actual!=null)
        {
                retorno = password.equals(nodo_actual.getProperty("password")); 
        

            this.getTx().success();
            this.getTx().finish();

            this.desconectar();
            return retorno;
        }
        else
        {
            return retorno;
        }
    }
    /*sdfsdfd*/
    private Node existeNodoUsuario(String correo) 
    { 
        //Se realiza la consulta a la base de datos para comprobar la existencia del nodo
        Label label_usuario = DynamicLabel.label("Usuario"); 
        ResourceIterator<Node> res = this.getBase().findNodesByLabelAndProperty(label_usuario,
                "email", correo).iterator();
        if (res.hasNext()) 
        {
                Node bdNodo = res.next();
                return bdNodo;
        }
        else 
        {
                return null;
        } 
    }

    @SuppressWarnings("deprecation")
    public ArrayList<String> obtenerNodo(String correo) {
            ArrayList<String> lista = new ArrayList<String>(); 
            this.conectar();
            this.setTx(this.getBase().beginTx());

            Node nodo = existeNodoUsuario(correo);
            if (nodo != null) 
            { 
                lista.add((((String) nodo.getProperty("nombre")) + " ").concat((String) nodo.getProperty("apellido1")));
                lista.add((String) nodo.getProperty("apellido1"));
                lista.add((String) nodo.getProperty("apellido2"));
                lista.add((String) nodo.getProperty("edad"));
                lista.add((String) nodo.getProperty("pais")); 
                lista.add((String) nodo.getProperty("tipoCuenta"));
            }

            this.getTx().success();
            this.getTx().finish();

            this.desconectar();
            return lista; }

/*Comentario*/
    public String getDirectorio() {
            return directorio; }

    public void setDirectorio(String directorio) {
            this.directorio = directorio; }


    public Relationship getConexion() {
            return conexion; }

    public void setConexion(Relationship conexion) {
            this.conexion = conexion; }

    public GraphDatabaseService getBase() {
            return base; }

    public void setBase(GraphDatabaseService base) {
            this.base = base; }

    public Transaction getTx() {
            return tx; }

    public void setTx(Transaction tx) {
            this.tx = tx; }

}
