package com.dolex.APICitasCMDolex.service;

import com.dolex.APICitasCMDolex.model.GetServiceResponseModel;

public interface IHorarioService {

	public GetServiceResponseModel getHorarios(Integer doctorID, String fecha);

}
