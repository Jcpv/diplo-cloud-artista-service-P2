package unam.diplomado.pixup.artistaservice.config;



import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
			version = "v1",
			title = "Pixup Disco Microservice Endpoints", 
			description = "Definición de los Endpoints de "
					+ "Disco Service para el sistema Pixup", 
			contact = @Contact(
				name = "UNAM", 
				url = "https://www.unam.mx/", 
			email = "candidop@unam.mx; josecandidop@hotmail.com")))

public class OpenApiConfig {

}
