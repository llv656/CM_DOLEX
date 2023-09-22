package com.dolex.APICitasCMDolex.service;

import com.dolex.APICitasCMDolex.model.CitaModel;
import com.dolex.APICitasCMDolex.model.GetServiceResponseModel;

public interface ICitasService {
	
	public GetServiceResponseModel addCita(CitaModel citaModel);
	
	public GetServiceResponseModel getCitas(Integer doctorID, String fecha);
	
	public GetServiceResponseModel deleteCita(Integer idCita);

}
