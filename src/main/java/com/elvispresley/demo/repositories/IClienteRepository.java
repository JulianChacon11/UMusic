/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.elvispresley.demo.repositories;

import com.elvispresley.demo.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author diegocabrera
 */
//
public interface IClienteRepository extends JpaRepository<Cliente,Integer> {
    
}
