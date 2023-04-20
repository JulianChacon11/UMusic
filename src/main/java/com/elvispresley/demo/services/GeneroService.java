/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elvispresley.demo.services;

import com.elvispresley.demo.entities.Genero;
import com.elvispresley.demo.repositories.IGeneroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *Clase para los servicios de la clase Genero
 * @author Julian Chacon
 */
//
@Service
public class GeneroService {
    
    @Autowired
    private IGeneroRepository generoRepository;
    /**
     * Metodo para crear un nuevo genero
     * @param g objeto de clase Genero
     * @return nuevoGenero, el genero creado
     */
    public Genero addGenero(Genero g){
        Genero nuevoGenero = generoRepository.save(g);
        return nuevoGenero;
    }
    
    /**
     * Metodo para actualizar un genero
     * @param g objeto de clase Genero a actualizar
     * @return generoActualizado, el genero actualizado
     */
    public Genero updateGenero(Genero g){
        Genero generoActualizado = generoRepository.save(g);
        return generoActualizado;
    }
    
    /**
     * Metodo para traer todos los generos existentes
     * @return generos, lista de generos
     */
    public List<Genero> getAllGeneros(){
        List<Genero> generos = generoRepository.findAll();
        return generos;
    }
    
    /**
     * Metodo para traer un genero en especifico por id
     * @param id, id del genero a traer
     * @return genero, el genero con el id especificado
     */
    public Genero viewGenero(int id){
       Genero genero = generoRepository.findById(id).get();
       return genero;
    }
    
    /**
     * Metodo para traer un genero por nombre
     * @param nombre, el nombre del genero a traer
     * @return generos, lista de generos coincidientes con el nombre especificado
     */
    public List<Genero> getGeneroByNombre(String nombre){
        List<Genero> generos = generoRepository.findGeneroByNombreContaining(nombre);
        return generos;
    }
    
    public List<Genero> getGeneroById(int id){
        List<Genero> generos = generoRepository.findGeneroById(id);
        return generos;
    }
    
    /**
     * Metodo para elminar un genero por id
     * @param g, el genero a eliminar
     */
    public boolean deleteGenero(int id){
        Genero generos = generoRepository.findById(id).orElse(null);
        if(generos == null){
            return false;
        }else{
            generoRepository.delete(generos);
            return true;
        }
    }   
}    