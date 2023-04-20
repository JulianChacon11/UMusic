package com.elvispresley.demo;

import com.elvispresley.demo.entities.Artista;
import com.elvispresley.demo.entities.Cancion;
import com.elvispresley.demo.entities.Cliente;
import com.elvispresley.demo.entities.Genero;
import com.elvispresley.demo.entities.Playlist;
import com.elvispresley.demo.services.ArtistaService;
import com.elvispresley.demo.services.CancionService;
import com.elvispresley.demo.services.GeneroService;
import com.elvispresley.demo.services.PlaylistService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties= "spring.main.allow-bean-definition-overriding=true")
class RockolaApplicationTests {
    
    @Autowired
    private CancionService cancionServicio;
        
    @Autowired
    private GeneroService generoServicio;
        
    @Autowired 
    private ArtistaService artistaServicio;
    
    @Autowired 
     private PlaylistService playlistServicio;
        
        @Test
        @Disabled
	void probarAddGenero() {
            Genero genero = new Genero("Boleros");
            Genero generoGuardado = generoServicio.addGenero(genero);
            Assertions.assertTrue(generoGuardado.getId() > 0, 
                    "*** Error *** /nGénero no guardada");
        }
        
        @Test
        @Disabled       
	void probarAddCancion() {
            Cancion cancion = new Cancion("Por debajo de la mesa", "3:26", "https://www.youtube.com");
            Cancion cancionGuardada = cancionServicio.addCancion(cancion);
            Assertions.assertTrue(cancionGuardada.getId() > 0, 
                    "*** Error *** /nCanción no guardada");
        }
        
        @Test
        @Disabled
	void probarEliminarCancion() {
            //Eliminar canción con el id 4
            Cancion cancion = cancionServicio.getCancionByNombre("Por debajo").get(0);
            cancionServicio.deleteCancion(cancion.getId());
            List<Cancion> canciones = cancionServicio.getAllCanciones();
            Assertions.assertTrue(!canciones.contains(cancion), 
                    "*** Error *** /nCanción no eliminada");
        }
        
        @Test
        @Disabled
	void probarAddCancion2() {
            Genero genero = generoServicio.getAllGeneros().get(0);
            Cancion cancion = new Cancion("Bésame mucho", "3:26", "https://www.youtube.com");
            cancion.setGenero(genero);
            Cancion cancionGuardada = cancionServicio.addCancion(cancion);
            Assertions.assertTrue(cancionGuardada.getId() > 0, 
                    "*** Error *** /nCanción no guardada");
        }
        
        @Test
        @Disabled      
	void probarAddArtista() {
            Artista artista = new Artista("Luis Miguel", "mexican");
            Artista artistaGuardado = artistaServicio.addArtista(artista);
            Assertions.assertTrue(artistaGuardado.getId() > 0, 
                    "*** Error *** /nArtista no guardado");
        }
        
        @Test
        @Disabled
        void probarRelacionCancionArtista(){
            List<Artista> artista= artistaServicio.getArtistaByNombre("Luis");
            Cancion cancion1 = cancionServicio.getCancionByNombre("Por debajo").get(0);
            Cancion cancion2 = cancionServicio.getCancionByNombre("Besame").get(0);
            
            cancion1.setArtistas(artista);
            cancion2.setArtistas(artista);

            Cancion cancion1Up = cancionServicio.updateCancion(cancion1);
            Cancion cancion2Up = cancionServicio.updateCancion(cancion2);
            //Artista artistaUp = artistaServicio.updateArtista(artista);
            
            Assertions.assertTrue(cancion1Up.getId() > 0 && cancion2Up.getId() > 0, 
                    "*** Error *** /nRelación no establecida ");
        }

        @Test
        @Disabled
        void probarCrearPlaylist(){
            Playlist pl = new Playlist();
            pl.setNombre("Boleritos");
            pl.setCliente(new Cliente("Juan", "Hernández", "abcd@gmail.com",
                    LocalDate.now(), "4436785678","male","mexican",true));
            pl.setCancion(new ArrayList<Cancion>());
            
            Playlist plGuardada = playlistServicio.crearNuevaPlaylist(pl);
            
            Assertions.assertTrue(plGuardada.getId() > 0, 
                    "*** Error *** /nPlaylist no guardada");  
        }
        
        @Test
        @Disabled
        void probarRelacionPlaylistCancion(){
            List<Cancion> canciones = cancionServicio.getAllCanciones();
            Playlist playlist = playlistServicio.consultarPlaylist("Boleritos").get(0);
            
            playlist.setCancion(canciones);

            Playlist playlistUp = playlistServicio.actualizarPlaylist(playlist);
            
            Assertions.assertTrue(playlistUp.getId() > 0, 
                    "*** Error *** /nRelación no establecida ");
        }
        @Autowired
        private GeneroService servicioGenero;
        
        @Autowired 
        private ArtistaService artistaService;
        
//         -------------------CANCION-------------
//	
//        @Test
//	void probarAddCancion() {
//            Cancion c = new Cancion("Monkey Dance", "3:26", "https://www.youtube.comka5", 1);
//            Cancion guardada = servicio.addCancion(c);
//            Assertions.assertTrue(guardada.getId() > 0, "Error, no se guardó la canción");
//        }
//              
//        @Test
//        void probarUpdateCancion(){
//         String nombreNuevo = "Something About Us";
//         Integer generoNuevo = 2;
//         Cancion update = new Cancion(nombreNuevo, "3:10", "https://www.youtube.comka4,",generoNuevo);
//         update.setId(16);
//         Cancion guardar = servicio.updateCancion(update);
//        
//         Cancion update2 = (Cancion) servicio.getCancionByNombre(nombreNuevo);
//         Assertions.assertTrue(update2.getNombre() == nombreNuevo, "Error, no se actualizo el campo");
//        }
        
//        @Test
//        void probarGetAllCanciones(){
//          List<Cancion> allCanciones = servicio.getAllCanciones();
//          Assertions.assertNotNull(allCanciones, "Error, no existen canciones en la lista");
//        }
//        
//        @Test
//       
//       void probarViewCancion(){
//           Cancion view = servicio.viewCancion(14);
//          Assertions.assertTrue(view.getId() == 14, "Error, no se puede mostrar la cancion"); 
//       }
//        
//        @Test
//       void probarGetCancionByNombre(){
//           List <Cancion> getCancion = servicio.getCancionByNombre("Something About Us");
//          Assertions.assertTrue(getCancion.size() > 0 , "Error, la cancion que busca no existe!");
//       }
//        
//        @Test
//        void probarGetCancionById(){
//            int id = 15;
//            List<Cancion> getCancion = servicio.getCancionById(id);
//            Assertions.assertNotNull(getCancion, "Error, no se encontró canción");
//        }
//        
//        @Test
//        void probarGetCancionByIdGenero(){
//            int id = 2;
//            List<Cancion> getCancion = servicio.getCancionByIdGenero(id);
//            Assertions.assertNotNull(getCancion, "Error!");
//       }
//          @Test
//          void probarDeleteCancion(){
//            Integer id = 18;
//            List<Cancion> getCancion = servicio.getCancionById(id);
//            boolean borrar = servicio.deleteCancion(id);
//            Assertions.assertNull(borrar); 
//        }       
//   --------------------ARTISTA-----------------------------     
//        @Test
//        void probarAddArtista(){
//            Artista a = new Artista("Tones and I", "Australia");
//            Artista guardado = artistaService.addArtista(a);
//            Assertions.assertTrue(guardado.getId() > 0 , "Error, no se encontró artista");
//        }
////        
//        @Test
//        void probarUpdateArtista(){
//         String nacionalidadNueva = "Francia";
//         Artista update = new Artista("Something About Us", nacionalidadNueva);
//         update.setId(2);
//         Artista guardar = artistaService.updateArtista(update);
//         Artista update2 = (Artista) artistaService.getArtistaByNacionalidad(nacionalidadNueva);
//         Assertions.assertTrue(update2.getNombre() == nacionalidadNueva, "Error, no se actualizo el campo");          
//        }
//        
//        @Test
//        void probarGetAllArtista(){
//            List<Artista> artista = artistaService.getAllArtistas();
//            Assertions.assertTrue(artista.size()>0, "Error, no hay artistas");
//        }
//        
//        @Test
//        void probarGetViewArtista(){
//         Artista view = artistaService.viewArtista(2);
//         Assertions.assertTrue(view.getId() == 14, "Error, no se puede mostrar la cancion"); 
//        }
//        
//        @Test
//        void probarGetArtistaByNombre(){
//            List<Artista> artista = artistaService.getArtistaByNombre("Shakira");
//            Assertions.assertTrue(artista.size() > 0, "Error, no se encontró el artista");
//        }
//        
//        @Test
//        void probarGetArtistaByNacionalidad(){
//            List<Artista> artista = artistaService.getArtistaByNacionalidad("Francia");
//            Assertions.assertTrue(artista.size() > 0, "Error, no se encontró el artista");
//        }
//        
//        @Test
//        void probarDeleteArtista(){
//            Integer id = 4;
//            List<Artista> getArtista = artistaService.getArtistaById(id);
//            boolean borrar = artistaService.deleteArtista(id);
//            Assertions.assertNull(borrar); 
//        } 
////    ----------------GENERO----------------    
        @Test
        @Disabled
        void probarAddGenero2(){
            Genero g = new Genero();
            g.setNombre("Soul");
            Genero guardado = generoServicio.addGenero(g);
            Assertions.assertTrue(guardado.getId() > 0, 
                    "*** Error *** /nGénero no guardada");
        }
//        
//         @Test
//         void probarUpdateGenero(){
//         String nombreNuevo = "Jazz";
//         Genero update = new Genero(nombreNuevo);
//         update.setId(5);
//         Genero guardar = servicioGenero.updateGenero(update);
//         Genero update2 = (Genero) servicioGenero.getGeneroByNombre(nombreNuevo);
//         Assertions.assertTrue(update2.getNombre() == nombreNuevo, "Error, no se actualizo el campo");          
//        }
//        
//        @Test
//        void probarGetAllGenero(){
//            List<Genero> generos = servicioGenero.getAllGeneros();
//            Assertions.assertTrue(generos.size()>0, "Error, no hay artistas");
//        }
//        
//        @Test
//        void probarGetViewGenero(){
//         Genero view = servicioGenero.viewGenero(3);
//         Assertions.assertTrue(view.getId() == 3, "Error, no se puede mostrar la cancion"); 
//        }
//        
//        @Test
//        void probarGetGeneroByNombre(){
//            List<Genero> generos = servicioGenero.getGeneroByNombre("Rock");
//            Assertions.assertTrue(genero.size() > 0, "Error, no se encontró el artista");
//        }
//        
//        @Test
//        void probarDeleteGenero(){
//            Integer id = 5;
//            List<Genero> getGenero = servicioGenero.getGeneroById(id);
//            boolean borrar = servicioGenero.deleteGenero(id);
//            Assertions.assertNull(borrar); 
//        } 
}
