/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.elvispresley.demo.repositories;

import com.elvispresley.demo.entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author diegocabrera
 */
//
public interface IAdministradorRepository extends JpaRepository<Administrador,Integer>{
    
}
