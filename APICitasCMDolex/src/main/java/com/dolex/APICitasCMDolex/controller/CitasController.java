package com.dolex.APICitasCMDolex.controller;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dolex.APICitasCMDolex.dto.GetServiceResponseDTO;
import com.dolex.APICitasCMDolex.model.CitaModel;
import com.dolex.APICitasCMDolex.service.ICitasService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/citas")
public class CitasController {

	private static final Logger LOGGER = LogManager.getLogger(CitasController.class);
	
	@Autowired
	private ICitasService citasService;
	
	@Operation(summary = "Registrar cita en el sistema")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "201", 
			description = "CREATED", 
			content = @Content(mediaType = "application/json",
				schema = @Schema(implementation = GetServiceResponseDTO.class))
		),
		@ApiResponse(responseCode = "400", 
			description = "bad request",
			content = @Content(mediaType = "application/json",
				schema = @Schema(implementation = GetServiceResponseDTO.class))
		),
	})
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public Object registrarCita(@RequestBody CitaModel citaModel) {
		String method = new Object(){}.getClass().getEnclosingMethod().getName();
		LOGGER.info("**Empieza solicitud ".concat(method));
		
		try {
			LOGGER.info("\tEmpieza servicio agregar cita");
			GetServiceResponseDTO responseDTO = citasService.addCita(citaModel);
		
			LOGGER.info("**Termina solicitud ".concat(method));
			
			return new ResponseEntity<Object>(responseDTO,
					responseDTO.isValid() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
			
		} catch (Exception ex) {
			LOGGER.error("**".concat(method).concat(ex.getMessage()));
			LOGGER.error("**".concat(method).concat(ex.toString()));
			
			return new ResponseEntity<Object>(
					new HashMap<String, String>().put("Error", "Operación inválida"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Operation(summary = "Recuperar citas del sistema")
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
	})
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public Object recuperarCitas(
			@Parameter(in = ParameterIn.QUERY, name = "doctor_id", description = "Id del doctor a buscar", schema = @Schema(type = "integer"))
			@RequestParam(required = false, name = "doctor_id") Integer doctorID,
			@Parameter(in = ParameterIn.QUERY, name = "fecha", description = "Fecha a buscar", schema = @Schema(type = "string"))
			@RequestParam(required = false, name = "fecha") String fecha
			 ) {
		String method = new Object(){}.getClass().getEnclosingMethod().getName();
		LOGGER.info("**Empieza solicitud ".concat(method));
		
		try {
			LOGGER.info("\tEmpieza servicio de recuperación de citas");
			GetServiceResponseDTO responseDTO = citasService.getCitas(doctorID, fecha);
		
			LOGGER.info("**Termina solicitud ".concat(method));
			
			return new ResponseEntity<Object>(responseDTO,
					responseDTO.isValid() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
			
		} catch (Exception ex) {
			LOGGER.error("**".concat(method).concat(ex.getMessage()));
			LOGGER.error("**".concat(method).concat(ex.toString()));
			
			return new ResponseEntity<Object>(
					new HashMap<String, String>().put("Error", "Operación inválida"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Operation(summary = "Eliminar cita del sistema")
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
	})
	@DeleteMapping(value = {"/{idCita}"},produces = {MediaType.APPLICATION_JSON_VALUE})
	public Object eliminarCita(@PathVariable("idCita") Integer idCita) {
		String method = new Object(){}.getClass().getEnclosingMethod().getName();
		LOGGER.info("**Empieza solicitud ".concat(method));
		
		try {
			LOGGER.info("\tEmpieza servicio de eliminar cita");
			GetServiceResponseDTO responseDTO = citasService.deleteCita(idCita);
		
			LOGGER.info("**Termina solicitud ".concat(method));
			
			return new ResponseEntity<Object>(responseDTO,
					responseDTO.isValid() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
			
		} catch (Exception ex) {
			LOGGER.error("**".concat(method).concat(ex.getMessage()));
			LOGGER.error("**".concat(method).concat(ex.toString()));
			
			return new ResponseEntity<Object>(
					new HashMap<String, String>().put("Error", "Operación inválida"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
