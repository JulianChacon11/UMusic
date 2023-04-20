/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elvispresley.demo.controllers;

import com.elvispresley.demo.entities.Cancion;
import com.elvispresley.demo.entities.Playlist;
import com.elvispresley.demo.services.CancionService;
import com.elvispresley.demo.services.PlaylistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author diegocabrera
 */
//

@Controller
public class PlaylistController {
    
    @Autowired 
    private PlaylistService playlistServicio;
    
    @Autowired 
    private CancionService cancionServicio;
    
    @GetMapping("/playlists")
    public String cargarListaPlaylistsPorNombre(Model model, @RequestParam(name = "name", required = false) String nombre){
        List<Playlist> playlists;
        
        if(nombre == null){
            playlists = playlistServicio.consultarPlaylists();
        }else{
            playlists = playlistServicio.consultarPlaylist(nombre);
        }
        
        model.addAttribute("playlists", playlists);
        
        return "listaplaylists";
    }
    
    @GetMapping("/playlists/form")
    public String cargarFormNuevaPlaylists(Model model){
        List<Cancion> canciones = cancionServicio.getAllCanciones();
        
        Playlist playlist = new Playlist();
        
        model.addAttribute("canciones", canciones);
        model.addAttribute("playlist", playlist);
        
        return "formplaylists";
    }
    
    @GetMapping("/playlists/form/{id}")
    public String cargarFormPlaylist(Model model, @PathVariable int id){
        List<Cancion> canciones = cancionServicio.getAllCanciones();
        
        Playlist playlist = playlistServicio.consultarPlaylist(id);
        
        model.addAttribute("canciones", canciones);
        model.addAttribute("playlist", playlist);
        
        return "formplaylists";
    
    }
    
    @PostMapping("/playlists")
    public String guardarPlaylist(@ModelAttribute Playlist pl){
        playlistServicio.crearNuevaPlaylist(pl);
        
        return "redirect:/playlists";
    }
    
}
