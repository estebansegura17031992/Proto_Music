package com.BD2.Proto_Music.servicios;

import com.BD2.Proto_Music.negocios.Artista;
import com.BD2.Proto_Music.negocios.Disco;
import com.BD2.Proto_Music.negocios.Usuario;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
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
    private Relationship conexion;
    private GraphDatabaseService base;
    private Transaction tx;
    private Label etiqueta;

    // Constructor:
    public Conexion() {
            this.setDirectorio("/home/esteban/Documents/Librerias Java/neo4j-community-2.1.7/data/graph.db");
            this.setConexion(null);
            this.setBase(null);
            this.setTx(null);
            
    }

    
    public enum NodeType implements Label
    {
        Usuario, Artista,Disco;
    }
    
    public enum Relacion implements RelationshipType{
	SIGUE,RELACIONAMISTAD,TIENE;
        
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
        }   
        
    }
    
    public void anadirNodoArtista(String nombre, String genero, String sitioWeb,String pais, 
                                   String fechaConformacion,String estado,String tipoCuenta, String email, String password) 
    {
        System.out.println("Tipo Cuenta: "+tipoCuenta);
        try
        {
            System.out.println("Estoy en artista");
            this.conectar();
            System.out.println("conectado...");
            this.setTx(this.getBase().beginTx());
            System.out.println("Creando nodo");
            Node bdNode = this.getBase().createNode(NodeType.Artista);
            bdNode.setProperty("nombre", nombre);
            bdNode.setProperty("genero", genero);
            bdNode.setProperty("pais", pais);
            bdNode.setProperty("fechaConformacion", fechaConformacion);
            bdNode.setProperty("estado", estado);
            bdNode.setProperty("tipoCuenta",tipoCuenta);
            bdNode.setProperty("sitioWeb", sitioWeb);
            bdNode.setProperty("email", email);
            bdNode.setProperty("password", password);
            System.out.println("Propiedades agregadas");
            this.getTx().success();


        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error"+nombre+" "+pais+" "+email+" "+password, 0);
        }
        finally
        {
            this.getTx().finish();
            this.desconectar();
        }   
    }
    
     public void anadirNodo_Disco(String usuario,String nombre, String genero, String publicacion,
                                   String discografia, String duracion, String productor) 
    {
        this.conectar();
        this.setTx(this.getBase().beginTx());
        try
        {
            Node bdNode = this.getBase().createNode(NodeType.Disco);
            bdNode.setProperty("nombre", nombre);
            bdNode.setProperty("genero", genero);
            bdNode.setProperty("publicacion", publicacion);
            bdNode.setProperty("discografia", discografia);
            bdNode.setProperty("duracion", duracion);
            bdNode.setProperty("productor",productor);
            
            
            
            this.getTx().success();
            

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error"+nombre+" "+productor, 0);
        }
        finally
        {
            this.getTx().finish();
            this.desconectar();
        }   
        
    }
     
    @SuppressWarnings("deprecation")
    public boolean autentificarUsuario(String email, String password) 
    {
        boolean retorno = false;
        try
        {
            this.conectar();
            this.setTx(this.getBase().beginTx());
            Node nodo_actual = existeNodoUsuario(email);
            if(nodo_actual!=null)
            {

                retorno = password.equals(nodo_actual.getProperty("password")); 
            }
            this.getTx().success();
            this.getTx().finish();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        finally
        {
            
            
            this.desconectar();
            return retorno;
        }
    }
    
    @SuppressWarnings("deprecation")
    public boolean autentificarArtista(String email, String password) 
    {
        boolean retorno = false;
        try
        {
        this.conectar();
        this.setTx(this.getBase().beginTx());
        Node nodo_actual = existeNodoArtista(email);
        if(nodo_actual!=null)
        {
            
            retorno = password.equals(nodo_actual.getProperty("password")); 
        }
        }
        catch(Exception ex)
        {
        }
        finally
        {
            this.getTx().success();
            this.getTx().finish();
            this.desconectar();
            return retorno;
        }
    }
    
    /*sdfsdfd*/
    private Node existeNodoUsuario(String email) 
    { 
        //Se realiza la consulta a la base de datos para comprobar la existencia del nodo
        Label label_usuario = DynamicLabel.label("Usuario"); 
        ResourceIterator<Node> res = this.getBase().findNodesByLabelAndProperty(label_usuario,
                "email", email).iterator();
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

    private Node existeNodoAmigo(String email) 
    { 
        //Se realiza la consulta a la base de datos para comprobar la existencia del nodo
        Label label_usuario = DynamicLabel.label("Amigo"); 
        ResourceIterator<Node> res = this.getBase().findNodesByLabelAndProperty(label_usuario,
                "email", email).iterator();
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
    
    private Node existeNodoDisco(String nombre) 
    { 
        //Se realiza la consulta a la base de datos para comprobar la existencia del nodo
        Label label_usuario = DynamicLabel.label("Disco"); 
        ResourceIterator<Node> res = this.getBase().findNodesByLabelAndProperty(label_usuario,
                "nombre", nombre).iterator();
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
    public ArrayList<Usuario> obtenerNodo(String email) 
    {
            ArrayList<Usuario> lista = new ArrayList<Usuario>(); 
            this.conectar();
            this.setTx(this.getBase().beginTx());

            Node nodo = existeNodoUsuario(email);
            if (nodo != null) 
            { 
                
                String nombreUsuarioObtenido = (String) nodo.getProperty("nombre");
                String apellido1UsuarioObtenido = (String) nodo.getProperty("apellido1");
                String apellido2UsuarioObtenido = (String) nodo.getProperty("apellido2");
                String edadUsuarioObtenido = (String) nodo.getProperty("edad");
                String paisUsuarioObtenido = (String) nodo.getProperty("pais"); 
                
                String emailUsuarioObtenido = (String) nodo.getProperty("email");
                
                Usuario usuario_obtenido = new Usuario(nombreUsuarioObtenido, apellido1UsuarioObtenido, apellido2UsuarioObtenido,
                                                        paisUsuarioObtenido, edadUsuarioObtenido, emailUsuarioObtenido);
                
                lista.add(usuario_obtenido);
            }

            this.getTx().success();
            this.getTx().finish();

            this.desconectar();
            return lista; 
    }
    
     private Node existeNodoArtista(String email) 
    { 
        System.out.println("Artistas");
        //Se realiza la consulta a la base de datos para comprobar la existencia del nodo
        Label label_usuario = DynamicLabel.label("Artista"); 
        ResourceIterator<Node> res = this.getBase().findNodesByLabelAndProperty(label_usuario,
                "email", email).iterator();
        if (res.hasNext()) 
        {
                Node bdNodo = res.next();
                System.out.println("estoy en existeNodoArtista");
                return bdNodo;
        }
        else 
        {
                return null;
        } 
    }
     
    @SuppressWarnings("deprecation")
    public ArrayList<Artista> obtenerNodo_Artista(String email) 
    {
            ArrayList<Artista> lista = new ArrayList<Artista>(); 
            this.conectar();
            this.setTx(this.getBase().beginTx());

            Node nodo = existeNodoArtista(email);
            if (nodo != null) 
            { 
                
                String nombreArtistaObtenido = (String) nodo.getProperty("nombre");
                String generoArtistaObtenido = (String) nodo.getProperty("genero");
                String paisArtistaObtenido = (String) nodo.getProperty("pais");
                String fechaConformacionArtistaObtenido = (String) nodo.getProperty("fechaConformacion");
                String estadoArtistaObtenido = (String) nodo.getProperty("estado"); 
                String sitioWebArtistaObtenido = (String) nodo.getProperty("sitioWeb");
                String emailUsuarioObtenido = (String) nodo.getProperty("email");
                
                Artista artista_obtenido = new Artista(nombreArtistaObtenido, generoArtistaObtenido, paisArtistaObtenido, 
                        fechaConformacionArtistaObtenido, estadoArtistaObtenido, sitioWebArtistaObtenido, emailUsuarioObtenido);
                
                lista.add(artista_obtenido);
            }

            this.getTx().success();
            this.getTx().finish();

            this.desconectar();
            return lista; 
    }
    
    @SuppressWarnings("deprecation")
    public void relacionarAmigos(String correo, String correo2) 
    {
        this.conectar();
        this.setTx(this.getBase().beginTx());
        try
        {
            Node nodoUsuario = existeNodoUsuario(correo);

            Node nodoUsuarioAmigo = existeNodoUsuario(correo2);


            this.setConexion(nodoUsuario.createRelationshipTo(nodoUsuarioAmigo, Relacion.RELACIONAMISTAD));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage()+"Usuario: "+correo+" relacionar con UsuarioAmigo"+correo2);
        }
        finally
        {
            this.getTx().success();
            this.getTx().finish();

            this.desconectar();     
        }
    }

     @SuppressWarnings("deprecation")
    public void relacionarArtista(String correo, String correo2) 
    {
        this.conectar();
        this.setTx(this.getBase().beginTx());
        try
        {
            Node nodoUsuario = existeNodoUsuario(correo);

            Node nodoUsuarioArtista = existeNodoArtista(correo2);


            this.setConexion(nodoUsuario.createRelationshipTo(nodoUsuarioArtista, Relacion.SIGUE));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage()+"Usuario: "+correo+" relacionar con Artista"+correo2);
        }
        finally
        {
            this.getTx().success();
            this.getTx().finish();

            this.desconectar();     
        }
    }
    
    @SuppressWarnings("deprecation")
    public void relacionarDiscoConArtista(String artista, String nombre) 
    {
        this.conectar();
        this.setTx(this.getBase().beginTx());
        try
        {
            Node nodoUsuario = existeNodoArtista(artista);

            Node nodoDisco = existeNodoDisco(nombre);


            this.setConexion(nodoUsuario.createRelationshipTo(nodoDisco, Relacion.TIENE));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage()+"Usuario: "+artista+" relacionar con UsuarioAmigo"+nombre);
        }
        finally
        {
            this.getTx().success();
            this.getTx().finish();

            this.desconectar();     
        }
    }

    
    @SuppressWarnings("deprecation")
	public ArrayList<Usuario> retonarMisAmigos(String email) 
        {
            System.out.println("retornarAmigos de: "+email);
		this.conectar();
                ArrayList<Usuario> amigos = new ArrayList<Usuario>();
                try
                {
                    ExecutionEngine engine = new ExecutionEngine(this.getBase());
                    ExecutionResult resultado;
                    this.setTx(this.getBase().beginTx());
                    resultado = engine.execute("MATCH (n {email: \""+email+"\"})<-[:RELACIONAMISTAD]->(p) RETURN p.email");

                     int i = 0;
                    
                    for (Map<String, Object> row : resultado) 
                    {
                        
                        for (Map.Entry<String, Object> column : row.entrySet()) 
                        {
                            
                            String email_amigo = column.getValue().toString(); 
                            //JOptionPane.showMessageDialog(null, email_amigo);

                            Node nodo = existeNodoUsuario(email_amigo);
                            if (nodo != null) 
                            { 

                                String nombreUsuarioObtenido = (String) nodo.getProperty("nombre");
                                String apellido1UsuarioObtenido = (String) nodo.getProperty("apellido1");
                                String apellido2UsuarioObtenido = (String) nodo.getProperty("apellido2");
                                String edadUsuarioObtenido = (String) nodo.getProperty("edad");
                                String paisUsuarioObtenido = (String) nodo.getProperty("pais"); 

                                String emailUsuarioObtenido = (String) nodo.getProperty("email");

                                Usuario usuario_obtenido = new Usuario(nombreUsuarioObtenido, apellido1UsuarioObtenido, apellido2UsuarioObtenido,
                                                                        paisUsuarioObtenido, edadUsuarioObtenido, emailUsuarioObtenido);
                                System.out.println(usuario_obtenido.getNombre()+" - "+usuario_obtenido.getEmail());
                                amigos.add(usuario_obtenido);
                            }
                            
                        } 
                }
                    
                    
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                
		finally
                {
                    this.getTx().success();
                    this.getTx().finish();
                    this.desconectar();
                }
                System.out.println("AMIGOS:" +amigos);
		return amigos; 
        }
        
        public ArrayList<Usuario> retonarSusAmigos(String email) 
        {
            System.out.println("retornarAmigos de: "+email);
		this.conectar();
                ArrayList<Usuario> amigos = new ArrayList<Usuario>();
                try
                {
                    ExecutionEngine engine = new ExecutionEngine(this.getBase());
                    ExecutionResult resultado;
                    this.setTx(this.getBase().beginTx());
                    resultado = engine.execute("MATCH (n {email: \""+email+"\"})<-[:RELACIONAMISTAD]->(p) RETURN p.email");

                     int i = 0;
                    
                    for (Map<String, Object> row : resultado) 
                    {
                        
                        for (Map.Entry<String, Object> column : row.entrySet()) 
                        {
                            
                            String email_amigo = column.getValue().toString(); 
                            //JOptionPane.showMessageDialog(null, email_amigo);

                            Node nodo = existeNodoUsuario(email_amigo);
                            if (nodo != null) 
                            { 

                                String nombreUsuarioObtenido = (String) nodo.getProperty("nombre");
                                String apellido1UsuarioObtenido = (String) nodo.getProperty("apellido1");
                                String apellido2UsuarioObtenido = (String) nodo.getProperty("apellido2");
                                String edadUsuarioObtenido = (String) nodo.getProperty("edad");
                                String paisUsuarioObtenido = (String) nodo.getProperty("pais"); 

                                String emailUsuarioObtenido = (String) nodo.getProperty("email");

                                Usuario usuario_obtenido = new Usuario(nombreUsuarioObtenido, apellido1UsuarioObtenido, apellido2UsuarioObtenido,
                                                                        paisUsuarioObtenido, edadUsuarioObtenido, emailUsuarioObtenido);
                                System.out.println(usuario_obtenido.getNombre()+" - "+usuario_obtenido.getEmail());
                                amigos.add(usuario_obtenido);
                            }
                            
                        } 
                }
                    
                    
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                
		finally
                {
                    this.getTx().success();
                    this.getTx().finish();
                    this.desconectar();
                }
                System.out.println("AMIGOS:" +amigos);
		return amigos; 
        }
        
        @SuppressWarnings("deprecation")
	public ArrayList<Artista> retonarMisArtistas(String email) 
        {
            System.out.println("retornarArtistas de: "+email);
		this.conectar();
                ArrayList<Artista> artistas = new ArrayList<Artista>();
                try
                {
                    ExecutionEngine engine = new ExecutionEngine(this.getBase());
                    ExecutionResult resultado;
                    this.setTx(this.getBase().beginTx());
                    resultado = engine.execute("MATCH (n {email: \""+email+"\"})-[:SIGUE]->(p) RETURN p.email");

                     int i = 0;
                    
                    for (Map<String, Object> row : resultado) 
                    {
                        
                        for (Map.Entry<String, Object> column : row.entrySet()) 
                        {
                            
                            String email_artista = column.getValue().toString(); 
                            //JOptionPane.showMessageDialog(null, email_amigo);

                            Node nodo = existeNodoArtista(email_artista);
                            if (nodo != null) 
                            { 

                                String nombreArtistaObtenido = (String) nodo.getProperty("nombre");
                                String generoArtistaObtenido = (String) nodo.getProperty("genero");
                                String paisArtistaObtenido = (String) nodo.getProperty("pais");
                                String fechaConformacionArtistaObtenido = (String) nodo.getProperty("fechaConformacion");
                                String estadoArtistaObtenido = (String) nodo.getProperty("estado"); 
                                String sitioWebArtistaObtenido = (String) nodo.getProperty("sitioWeb");
                                String emailArtistaObtenido = (String) nodo.getProperty("email");

                                Artista artista_obtenido = new Artista(nombreArtistaObtenido, generoArtistaObtenido, paisArtistaObtenido,
                                        fechaConformacionArtistaObtenido, estadoArtistaObtenido, sitioWebArtistaObtenido, 
                                        emailArtistaObtenido);
                                System.out.println("Aritsta RECUPERADO: "+ artista_obtenido.getNombre());
                                artistas.add(artista_obtenido);
                            }
                            
                        } 
                }
                    
                    
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                
		finally
                {
                    this.getTx().success();
                    this.getTx().finish();
                    this.desconectar();
                }
                System.out.println("ARTISTAS: " +artistas);
		return artistas; 
        }
        
        public ArrayList<Artista> retonarSusArtistas(String email) 
        {
            System.out.println("retornarArtistas de: "+email);
		this.conectar();
                ArrayList<Artista> artistas = new ArrayList<Artista>();
                try
                {
                    ExecutionEngine engine = new ExecutionEngine(this.getBase());
                    ExecutionResult resultado;
                    this.setTx(this.getBase().beginTx());
                    resultado = engine.execute("MATCH (n {email: \""+email+"\"})-[:SIGUE]->(p) RETURN p.email");

                     int i = 0;
                    
                    for (Map<String, Object> row : resultado) 
                    {
                        
                        for (Map.Entry<String, Object> column : row.entrySet()) 
                        {
                            
                            String email_amigo = column.getValue().toString(); 
                            //JOptionPane.showMessageDialog(null, email_amigo);

                            Node nodo = existeNodoArtista(email_amigo);
                            if (nodo != null) 
                            { 

                                String nombreUsuarioObtenido = (String) nodo.getProperty("nombre");
                                String generoArtistaObtenido = (String) nodo.getProperty("genero");
                                String paisArtistaObtenido = (String) nodo.getProperty("pais");
                                String fechaArtistaObtenido = (String) nodo.getProperty("fechaConformacion");
                                String estadoArtistaObtenido = (String) nodo.getProperty("estado"); 

                                String sitioWebArtistaObtenido = (String) nodo.getProperty("sitioWeb");
                                
                                String emailArtistaObtenido = (String) nodo.getProperty("email");
                                Artista artista_obtenido = new Artista(nombreUsuarioObtenido, generoArtistaObtenido, 
                                        paisArtistaObtenido, fechaArtistaObtenido, estadoArtistaObtenido, sitioWebArtistaObtenido,
                                        emailArtistaObtenido);
                                artistas.add(artista_obtenido);
                            }
                            
                        } 
                }
                    
                    
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                
		finally
                {
                    this.getTx().success();
                    this.getTx().finish();
                    this.desconectar();
                }
                System.out.println("ARTISTAS:" +artistas);
		return artistas; 
        }
        
        public ArrayList<Usuario> retonarMisSeguidores(String nombreArtista)
        {
            this.conectar();
                ArrayList<Usuario> artistas = new ArrayList<Usuario>();
                try
                {
                    ExecutionEngine engine = new ExecutionEngine(this.getBase());
                    ExecutionResult resultado;
                    this.setTx(this.getBase().beginTx());
                    resultado = engine.execute("MATCH (n {email: \""+nombreArtista+"\"})<-[:SIGUE]-(p) RETURN p.email");

                     int i = 0;
                    
                    for (Map<String, Object> row : resultado) 
                    {
                        
                        for (Map.Entry<String, Object> column : row.entrySet()) 
                        {
                            
                            String email_amigo = column.getValue().toString(); 
                            //JOptionPane.showMessageDialog(null, email_amigo);

                            Node nodo = existeNodoUsuario(email_amigo);
                            if (nodo != null) 
                            { 

                                String nombreUsuarioObtenido = (String) nodo.getProperty("nombre");
                                String apellido1UsuarioObtenido = (String) nodo.getProperty("apellido1");
                                String apellido2UsuarioObtenido = (String) nodo.getProperty("apellido2");
                                String edadUsuarioObtenido = (String) nodo.getProperty("edad");
                                String paisUsuarioObtenido = (String) nodo.getProperty("pais"); 

                                String emailUsuarioObtenido = (String) nodo.getProperty("email");

                                Usuario usuario_obtenido = new Usuario(nombreUsuarioObtenido, apellido1UsuarioObtenido, apellido2UsuarioObtenido,
                                                                        paisUsuarioObtenido, edadUsuarioObtenido, emailUsuarioObtenido);
                                System.out.println(usuario_obtenido.getNombre()+" - "+usuario_obtenido.getEmail());
                                artistas.add(usuario_obtenido);
                            }
                            
                        } 
                }
                    
                    
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                
		finally
                {
                    this.getTx().success();
                    this.getTx().finish();
                    this.desconectar();
                }
                System.out.println("ARTISTAS:" +artistas);
		return artistas; 
        }
        
        public ArrayList<Usuario> retonarSusSeguidores(String nombreArtista)
        {
            this.conectar();
                ArrayList<Usuario> artistas = new ArrayList<Usuario>();
                try
                {
                    ExecutionEngine engine = new ExecutionEngine(this.getBase());
                    ExecutionResult resultado;
                    this.setTx(this.getBase().beginTx());
                    resultado = engine.execute("MATCH (n {email: \""+nombreArtista+"\"})<-[:SIGUE]-(p) RETURN p.email");

                     int i = 0;
                    
                    for (Map<String, Object> row : resultado) 
                    {
                        
                        for (Map.Entry<String, Object> column : row.entrySet()) 
                        {
                            
                            String email_amigo = column.getValue().toString(); 
                            //JOptionPane.showMessageDialog(null, email_amigo);

                            Node nodo = existeNodoUsuario(email_amigo);
                            if (nodo != null) 
                            { 

                                String nombreUsuarioObtenido = (String) nodo.getProperty("nombre");
                                String apellido1UsuarioObtenido = (String) nodo.getProperty("apellido1");
                                String apellido2UsuarioObtenido = (String) nodo.getProperty("apellido2");
                                String edadUsuarioObtenido = (String) nodo.getProperty("edad");
                                String paisUsuarioObtenido = (String) nodo.getProperty("pais"); 

                                String emailUsuarioObtenido = (String) nodo.getProperty("email");

                                Usuario usuario_obtenido = new Usuario(nombreUsuarioObtenido, apellido1UsuarioObtenido, apellido2UsuarioObtenido,
                                                                        paisUsuarioObtenido, edadUsuarioObtenido, emailUsuarioObtenido);
                                System.out.println(usuario_obtenido.getNombre()+" - "+usuario_obtenido.getEmail());
                                artistas.add(usuario_obtenido);
                            }
                            
                        } 
                }
                    
                    
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                
		finally
                {
                    this.getTx().success();
                    this.getTx().finish();
                    this.desconectar();
                }
                System.out.println("ARTISTAS:" +artistas);
		return artistas; 
        }
        
        public ArrayList<Disco> retonarMisDiscos(String emailArtista)
        {
            this.conectar();
                ArrayList<Disco> discos = new ArrayList<Disco>();
                try
                {
                    ExecutionEngine engine = new ExecutionEngine(this.getBase());
                    ExecutionResult resultado;
                    this.setTx(this.getBase().beginTx());
                    resultado = engine.execute("MATCH (n {email: \""+emailArtista+"\"})-[:TIENE]->(p) RETURN p.nombre");

                     int i = 0;
                    
                    for (Map<String, Object> row : resultado) 
                    {
                        
                        for (Map.Entry<String, Object> column : row.entrySet()) 
                        {
                            
                            String nombreDisco = column.getValue().toString(); 
                            //JOptionPane.showMessageDialog(null, email_amigo);

                            Node nodo = existeNodoDisco(nombreDisco);
                            if (nodo != null) 
                            { 

                                String nombreDiscoObtenido = (String) nodo.getProperty("nombre");
                                String generoDiscoObtenido = (String) nodo.getProperty("genero");
                                String publicacionDiscoUsuarioObtenido = (String) nodo.getProperty("publicacion");
                                String discografiaDiscoObtenido = (String) nodo.getProperty("discografia");
                                String duracionDiscoObtenido = (String) nodo.getProperty("duracion");
                                String productorDiscoObtenido = (String) nodo.getProperty("productor"); 


                                Disco disco_obtenido = new Disco(nombreDisco, generoDiscoObtenido, publicacionDiscoUsuarioObtenido, 
                                        discografiaDiscoObtenido, duracionDiscoObtenido, productorDiscoObtenido);
                                discos.add(disco_obtenido);
                            }
                            
                        } 
                }
                    
                    
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                
		finally
                {
                    this.getTx().success();
                    this.getTx().finish();
                    this.desconectar();
                }
                System.out.println("DISCOS:" +discos);
		return discos; 
        }
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
