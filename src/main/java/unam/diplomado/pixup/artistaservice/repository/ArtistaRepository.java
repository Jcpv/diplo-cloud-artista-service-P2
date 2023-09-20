// ARCHIVO - 2 - 

package unam.diplomado.pixup.artistaservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import unam.diplomado.pixup.artistaservice.domain.Artista;

public interface ArtistaRepository 
	extends MongoRepository <Artista, String> { 
}
