// ARCHIVO - 1 - 

package unam.diplomado.pixup.artistaservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="artistas") //Collections o TABLA de la base de datos de MONGO de donde se obtiene los datos
public class Artista {

	@Id 
	private String id;
	private String nombre;
}