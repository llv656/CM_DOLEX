package com.dolex.APICitasCMDolex.service;

import com.dolex.APICitasCMDolex.dto.GetServiceResponseDTO;
import com.dolex.APICitasCMDolex.model.CitaModel;

public interface ICitasService {
	
	public GetServiceResponseDTO addCita(CitaModel citaModel);
	
	public GetServiceResponseDTO getCitas(Integer doctorID, String fecha, Integer pageSize, Integer pageNumber);
	
	public GetServiceResponseDTO deleteCita(Integer idCita);

}
