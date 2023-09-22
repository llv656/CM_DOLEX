package com.dolex.APICitasCMDolex.service;

import com.dolex.APICitasCMDolex.dto.GetServiceResponseDTO;

public interface IHorarioService {

	public GetServiceResponseDTO getHorarios(Integer doctorID, String fecha);

}
