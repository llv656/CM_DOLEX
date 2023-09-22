package com.dolex.APICitasCMDolex.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dolex.APICitasCMDolex.dto.GetServiceResponseDTO;
import com.dolex.APICitasCMDolex.dto.ServerErrorResponseDTO;
import com.dolex.APICitasCMDolex.service.IMedicosService;
import com.dolex.APICitasCMDolex.values.MessageUser;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

	private static final Logger LOGGER = LogManager.getLogger(MedicosController.class);
	
	@Autowired
	private IMedicosService medicosService;
	
	@Operation(summary = "Recuperar Medicos del sistema")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", 
			description = "OK", 
			content = @Content(mediaType = "application/json",
				schema = @Schema(implementation = GetServiceResponseDTO.class))
		),
		@ApiResponse(responseCode = "404", 
			description = "bad request",
			content = @Content(mediaType = "application/json",
				schema = @Schema(implementation = GetServiceResponseDTO.class))
		),
		@ApiResponse(responseCode = "500", 
		description = "internal server error",
		content = @Content(mediaType = "application/json",
			schema = @Schema(implementation = ServerErrorResponseDTO.class))
		),
	})
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public Object recuperarMedicos() {
		String method = new Object(){}.getClass().getEnclosingMethod().getName();
		LOGGER.info("**Empieza solicitud ".concat(method));
		
		try {
			LOGGER.info("\tEmpieza servicio recuperar medicos");
			GetServiceResponseDTO responseDTO = medicosService.getMedicos();
		
			LOGGER.info("**Termina solicitud ".concat(method));
			
			return new ResponseEntity<Object>(responseDTO,
					responseDTO.isValid() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
			
		} catch (Exception ex) {
			LOGGER.error("**".concat(method).concat(ex.getMessage()));
			LOGGER.error("**".concat(method).concat(ex.toString()));
			
			ServerErrorResponseDTO serverError = new ServerErrorResponseDTO();
			serverError.setError(MessageUser.SERVER_ERROR);
			
			return new ResponseEntity<Object>(serverError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
