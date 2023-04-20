/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elvispresley.demo.entities;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 *
 * @author andreastefannygarciamejia
 * 
 */
//
@Entity
@Table(name = "tplaylists", schema = "elvispresley")
public class Playlist implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tplaylists_canciones",
        joinColumns = @JoinColumn(name = "id_playlist"),
        inverseJoinColumns = @JoinColumn(name="id_cancion"))
    private List <Cancion> canciones;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Playlist() {
        
    }

    public Playlist(int id, String nombre, List<Cancion> canciones, Cliente cliente) {
        this.id = id;
        this.nombre = nombre;
        this.canciones = canciones;
        this.cliente = cliente;
    }

    public Playlist(String nombre, List<Cancion> canciones, Cliente cliente) {
        this.nombre = nombre;
        this.canciones = canciones;
        this.cliente = cliente;
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

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCancion(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}

