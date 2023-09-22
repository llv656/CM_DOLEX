package com.dolex.APICitasCMDolex.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {
	
	@Value("${cmdolex.openapi.dev-url}")
	private String devUrl;
	
	@Bean
	OpenAPI myOpenAPI() {
	    Server devServer = new Server();
	    devServer.setUrl(devUrl);
	    devServer.setDescription("URL de servidor en ambiente desarrollo");
		
		Contact contact = new Contact();
		contact.setEmail("leinesvitelenin@gmail.com");
		contact.setName("LLV656");
		contact.setUrl("");
		
		License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");
		
		Info info = new Info()
		    .title("API Citas")
		    .version("1.0.0")
		    .contact(contact)
		    .description("Esta API expone servicios para la gestión de citas del consultorio medico dolex.")
		    .license(mitLicense);
		
		return new OpenAPI().info(info).servers(List.of(devServer));
	}
}
