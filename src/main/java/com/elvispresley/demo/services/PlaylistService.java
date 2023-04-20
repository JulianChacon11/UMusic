/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elvispresley.demo.services;

import com.elvispresley.demo.entities.Playlist;
import com.elvispresley.demo.repositories.ICancionRepository;
import com.elvispresley.demo.repositories.IPlaylistRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diegocabrera
 */
//

@Service
public class PlaylistService {
    
    @Autowired
    private IPlaylistRepository playlistRepository;
    
    public Playlist crearNuevaPlaylist(Playlist playlist){
        Playlist pl = playlistRepository.save(playlist);
        return pl;
    }
    
    public List<Playlist> consultarPlaylists(){
        List<Playlist> listaPlaylist = playlistRepository.findAll();
        return listaPlaylist;
                
    }
    
    public Playlist consultarPlaylist(int id){
        Playlist pl = playlistRepository.findById(id).get();
        return pl;
    }
    
    public List<Playlist> consultarPlaylist(String criterio){
        List<Playlist> listaPlaylist;
        listaPlaylist = playlistRepository.findPlaylistByNombreContaining(criterio);
        return listaPlaylist;
    }
    
    public void eliminarPlaylist(int id){
        playlistRepository.deleteById(id);
    }
    
    public Playlist actualizarPlaylist(Playlist playlist){
        Playlist plUp = playlistRepository.save(playlist);
        return plUp;
    }

    
}
