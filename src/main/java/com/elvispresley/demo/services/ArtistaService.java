/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elvispresley.demo.services;

import com.elvispresley.demo.entities.Artista;
import com.elvispresley.demo.repositories.IArtistaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase para los servicios de la clase Artistas
 * @author Julian Chacon
 */
//
@Service
public class ArtistaService {
   
    @Autowired
    private IArtistaRepository artistaRepository;
    
    /**
     * Metodo para crear un nuevo artista
     * @param a objeto de clase Artista
     * @return nuevoArtista, el artista creado
     */
     public Artista addArtista(Artista a){
        Artista nuevoArtista = artistaRepository.save(a);
        return nuevoArtista;
    }
    
     /**
     * Metodo para actualizar un artista
     * @param a objeto de clase Artista a actualizar
     * @return artistaActualizado, el artista actualizado
     */
    public Artista updateArtista(Artista a){
        Artista artistaActualizado = artistaRepository.save(a);
        return artistaActualizado;
    }
    
    /**
     * Metodo para traer todos los artistas existentes
     * @return artistas, lista de artistas
     */
    public List<Artista> getAllArtistas(){
        List<Artista> artistas = artistaRepository.findAll();
        return artistas;
    }
    
    /**
     * Metodo para traer un artista en especifico por id
     * @param id, id del artista a traer
     * @return a, el artista con el id especificado
     */
    public Artista viewArtista(int id){
       Artista a = artistaRepository.findById(id).get();
       return a;
    }
    
     /**
     * Metodo para traer un artista por nombre
     * @param nombre, el nombre del artista a traer
     * @return artistas, lista de artistas coincidientes con el nombre especificado
     */
    public List<Artista> getArtistaByNombre(String nombre){
        List<Artista> artistas = artistaRepository.findArtistaByNombreContaining(nombre);
        return artistas;
    }
    
    public List<Artista> getArtistaById(int id){
        List<Artista> artistas = artistaRepository.findArtistaById(id);
        return artistas;
    }
    
    public List<Artista> getArtistaByNacionalidad(String nacionalidad){
    List<Artista> artistas = artistaRepository.findArtistaByNacionalidad(nacionalidad);
    return artistas;
    }    
     /**
     * Metodo para elminar un artista por id
     * @param a, el artista a eliminar
     */
    public boolean deleteArtista(int id){
       Artista a = artistaRepository.findById(id).orElse(null);
       if(a == null){
           return false;
       }else{
           artistaRepository.delete(a);
           return true;
       }    
    }
}
