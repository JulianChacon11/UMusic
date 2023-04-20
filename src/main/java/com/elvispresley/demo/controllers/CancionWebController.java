/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elvispresley.demo.controllers;

import com.elvispresley.demo.entities.Cancion;
import com.elvispresley.demo.entities.Genero;
import com.elvispresley.demo.repositories.ICancionRepository;
import com.elvispresley.demo.services.CancionService;
import com.elvispresley.demo.services.GeneroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author andreastefannygarciamejia
 */
@RestController
public class CancionWebController {
    @Autowired
    private ICancionRepository repository;
    
    @Autowired
    private CancionService servicio;
    
    @Autowired
    private GeneroService service;
    
    @GetMapping("/api/catrock")
    private ResponseEntity<Cancion> getCancionByGeneroRock( @PathVariable String nombre){
        Cancion c = servicio.getCancionByNombre(nombre).get(0);
        if (c != null){
          return  new ResponseEntity<>(c , HttpStatus.OK);   
        }else{
            return  new ResponseEntity<>(c , HttpStatus.NOT_FOUND); 
        }
          
    }
    
    @GetMapping("/api/catpop")
    private ResponseEntity<List<Cancion>> getCancionByGeneroPop(@PathVariable String nombre){
       
        return new ResponseEntity<>(servicio.getCancionByNombre(nombre), HttpStatus.OK);
    }
    
    @GetMapping("/api/catelec")
    private ResponseEntity<List<Cancion>> getCancionByGeneroElect(@PathVariable String nombre){
        return new ResponseEntity<>(servicio.getCancionByNombre(nombre), HttpStatus.OK);
    }
    
    @GetMapping("/api/genero")
    private ResponseEntity<List<Genero>> getCancionByGeneroRagg( @RequestParam(value="nombre", required=false) String nombre){
        List <Genero> lista;
        if (nombre != null){
         lista= service.getAllGeneros();
         
        }else{
            lista=service.getGeneroByNombre(nombre);
            
        }
        if(lista.size() >0){
           return  new ResponseEntity<>(lista , HttpStatus.OK);   
        }else{
            return  new ResponseEntity<>(lista, HttpStatus.NOT_FOUND);  
        }
    }
}
