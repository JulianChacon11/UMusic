/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elvispresley.demo.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Clase para la gestión de canciones
 * @author Julian Chacon
 */
//
@Entity(name = "tcanciones")
public class Cancion {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;
    
    @Column(name = "duracion", length = 5, nullable = false)
    private String duracion;
    
    @Column(name = "link", length = 200, nullable = false)
    private String link;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_genero")
    private Genero genero;
    
    @ManyToMany(mappedBy = "canciones")
    private List <Playlist> playlists;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tcanciones_artistas",
        joinColumns = @JoinColumn(name = "id_cancion"),
        inverseJoinColumns = @JoinColumn(name="id_artista"))
    
    private List <Artista> artistas;
    
    public Cancion() {
    }

    public Cancion(int id, String nombre, String duracion, String link) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.link = link;
    }
    
    public Cancion(String nombre, String duracion, String link) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.link = link;
    }

    public Cancion(String nombre, String duracion, String link, Genero genero) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.link = link;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    @Override
    public String toString() {
        return "Cancion{" + "id=" + id + ", nombre=" + nombre + ", duracion=" + 
                duracion + ", link=" + link + ", genero=" + genero + 
                ", playlists=" + playlists + ", artistas=" + artistas + '}';
    }

    
    
    
    
}

