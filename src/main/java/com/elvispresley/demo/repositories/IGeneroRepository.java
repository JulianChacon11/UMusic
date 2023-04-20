/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elvispresley.demo.repositories;

import com.elvispresley.demo.entities.Genero;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *Interfaz del repositorio de generos
 * @author Julian Chacon
 */
//
@Repository
public interface IGeneroRepository extends JpaRepository<Genero, Integer>{
    
    public List<Genero> findGeneroByNombreContaining(String nombre);
    public List<Genero> findGeneroById(int id);
}
