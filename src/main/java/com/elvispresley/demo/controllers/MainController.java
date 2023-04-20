/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elvispresley.demo.controllers;

import com.elvispresley.demo.entities.Genero;
import com.elvispresley.demo.services.CancionService;
import com.elvispresley.demo.services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Julian Chacon
 */
//
@Controller
public class MainController {
    
    @Autowired
 private CancionService servicio;
    
    @Autowired
    
    private GeneroService service;
 
    @GetMapping("/")
    public String cargarPaginaPrincipal(){
        return "index";
        }
    @GetMapping("/login")
    public String iniciarSesion(){
        return "login";
        }
    
    @GetMapping("/registro")
    public String registro(){
        return "registro";
        }
    
    @GetMapping("/catrock")
    public String Rock(Model rock){
      Genero genero = service.getGeneroById(1).get(0);
      rock.addAttribute("canciones", servicio.getCancionByGenero(genero));
      return "catrock";
    }
    @GetMapping("/catpop")
    public String Pop(Model pop){
      Genero genero = service.getGeneroById(2).get(0);
      pop.addAttribute("canciones", servicio.getCancionByGenero(genero));
        return "catpop";
        }
    @GetMapping("/catelec")
    public String Electronica(Model elec){
      Genero genero = service.getGeneroById(4).get(0);
      elec.addAttribute("canciones", servicio.getCancionByGenero(genero));
        return "catelec";
        }
    @GetMapping("/catragg")
    public String Raggetton(Model ragg){
       Genero genero = service.getGeneroById(3).get(0);
      ragg.addAttribute("canciones", servicio.getCancionByGenero(genero));
        return "catragg";
        }
     @GetMapping("/playlist")
    public String PlayList(){
        return "playlist";
        }
    @GetMapping("/artistas")
    public String Artistas(){
        return "artistas";
        }
    @GetMapping("/generos")
    public String Generos(){
        return "generos";
        }   
    
    }

