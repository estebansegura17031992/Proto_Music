/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BD2.Proto_Music.negocios;

/**
 *
 * @author esteban
 */
public class Disco {
    String nombre;
    String genero;
    String publicacion;
    String discografia;
    String duracion;
    String productor;

    public Disco(String nombre, String genero, String publicacion, String discografia, String duracion, String productor) {
        this.nombre = nombre;
        this.genero = genero;
        this.publicacion = publicacion;
        this.discografia = discografia;
        this.duracion = duracion;
        this.productor = productor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

    public String getDiscografia() {
        return discografia;
    }

    public void setDiscografia(String discografia) {
        this.discografia = discografia;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }
    
    
}
