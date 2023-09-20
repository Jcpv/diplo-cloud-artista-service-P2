// ARCHIVO - 4 -
package unam.diplomado.pixup.artistaservice.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import unam.diplomado.pixup.artistaservice.domain.Artista;
import unam.diplomado.pixup.artistaservice.repository.ArtistaRepository;
import unam.diplomado.pixup.artistaservice.service.ArtistaService;

@RestController
@RequestMapping (path="api/artistas", produces="application/json")
@CrossOrigin(origins="*")
@Tag(name="artista", description ="API del Recurso - Artista - ")
public class ArtistaController {
	
	@Autowired
	private ArtistaRepository artistaRepository;
	@Autowired
	private ArtistaService artistaService;
	
	
	@Operation(summary="Obtener todos los artistas")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", 
					description="Ok - al obtener todos los artistas")
	})
	@GetMapping
	public List<Artista> obtenerArtistas() {
		return artistaRepository.findAll();
	}
	
	
	
	
	@Operation(summary="Crear Artista")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "201", 
					description="Artista Creado Correctamente", 
					content = {
							@Content (mediaType ="application/json",
							schema = @Schema(implementation=Artista.class)) })
	})
	@PostMapping (consumes="application/json")
	@ResponseStatus (HttpStatus.CREATED)
	public Artista crearArtista(@RequestBody Artista artista){
		return artistaRepository.save(artista);
	}
	
	
	
	
	@Operation(summary="Obtener Artista por un ID determinado")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", 
					description="Ok - al buscar artista por ID")
	})
	@GetMapping("{id}")
	public ResponseEntity<Artista> obtenerArtistaPorId(@PathVariable ("id") String id) {
		Optional<Artista>  artista = artistaRepository.findById(id);
		if (artista.isPresent()) {
			// return estado.get();
			return new ResponseEntity<>(artista.get(), HttpStatus.OK);
		}
		//return null;
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	
	
	@Operation(summary="Actualizar NOMBRE de Artista")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "201", 
					description="Artista ACTUALIZADO Correctamente", 
					content = {
							@Content (mediaType ="application/json",
							schema = @Schema(implementation=Artista.class)) })
	})
	@PutMapping(path="{id}", consumes ="application/json") 
	public ResponseEntity<Artista> actualizarArtista (@PathVariable("id") String id, @RequestBody Artista artista)
	{
		
		try {
			
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		}
		
		Artista artistaActualizado = artistaService.actualizarArtista(id, artista);
		if (artistaActualizado != null) {
			return new ResponseEntity<>(artistaActualizado, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	} 
	
	
	
	
	@Operation(summary="Eliminar a un determinado Artista por ID")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "204", 
					description="No hay datos de respuesta, pero se elimina al artista")
	})
	@DeleteMapping ("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarArtista(@PathVariable("id") String id) {
		artistaRepository.deleteById(id);
	}
}
