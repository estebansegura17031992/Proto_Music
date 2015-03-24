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
public class Artista {

    private String nombre;
    private String genero;
    private String pais;
    private String fechaConformacion;
    private String estado;
    private String sitioWeb;
    private String email;

    public Artista(String nombre, String genero, String pais, String fechaConformacion, String estado, String sitioWeb, String email) {
        this.nombre = nombre;
        this.genero = genero;
        this.pais = pais;
        this.fechaConformacion = fechaConformacion;
        this.estado = estado;
        this.sitioWeb = sitioWeb;
        this.email = email;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getFechaConformacion() {
        return fechaConformacion;
    }

    public void setFechaConformacion(String fechaConformacion) {
        this.fechaConformacion = fechaConformacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
}
