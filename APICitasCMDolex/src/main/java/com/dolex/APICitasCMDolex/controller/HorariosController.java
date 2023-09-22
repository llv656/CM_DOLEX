package com.dolex.APICitasCMDolex.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dolex.APICitasCMDolex.dto.GetServiceResponseDTO;
import com.dolex.APICitasCMDolex.dto.ServerErrorResponseDTO;
import com.dolex.APICitasCMDolex.service.IHorarioService;
import com.dolex.APICitasCMDolex.values.MessageUser;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/horarios")
public class HorariosController {

	private static final Logger LOGGER = LogManager.getLogger(HorariosController.class);
	
	@Autowired
	private IHorarioService horarioService;
	
	@Operation(summary = "Recuperar horarios disponible por doctor")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", 
			description = "OK", 
			content = @Content(mediaType = "application/json",
				schema = @Schema(implementation = GetServiceResponseDTO.class))
		),
		@ApiResponse(responseCode = "400", 
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
	public Object recuperarHorarios(
			@Parameter(in = ParameterIn.QUERY, name = "doctor_id", description = "Id del doctor a buscar", schema = @Schema(type = "integer"))
			@RequestParam(required = false, name = "doctor_id") Integer doctorID,
			@Parameter(in = ParameterIn.QUERY, name = "fecha", description = "Fecha a buscar", schema = @Schema(type = "string"))
			@RequestParam(required = false, name = "fecha") String fecha
			 ) {
		String method = new Object(){}.getClass().getEnclosingMethod().getName();
		LOGGER.info("**Empieza solicitud ".concat(method));
		
		try {
			LOGGER.info("\tEmpieza servicio recuperar horarios");
			GetServiceResponseDTO responseDTO = horarioService.getHorarios(doctorID, fecha);
		
			LOGGER.info("**Termina solicitud ".concat(method));
			
			return new ResponseEntity<Object>(responseDTO,
					responseDTO.isValid() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
			
		} catch (Exception ex) {
			LOGGER.error("**".concat(method).concat(ex.getMessage()));
			LOGGER.error("**".concat(method).concat(ex.toString()));
			
			ServerErrorResponseDTO serverError = new ServerErrorResponseDTO();
			serverError.setError(MessageUser.SERVER_ERROR);
			
			return new ResponseEntity<Object>(serverError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
