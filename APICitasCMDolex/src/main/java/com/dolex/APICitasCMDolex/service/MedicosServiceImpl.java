package com.dolex.APICitasCMDolex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolex.APICitasCMDolex.entity.DoctorEntity;
import com.dolex.APICitasCMDolex.model.GetServiceResponseModel;
import com.dolex.APICitasCMDolex.repository.IDoctorDAO;
import com.dolex.APICitasCMDolex.values.MessageUser;

@Service
public class MedicosServiceImpl implements IMedicosService {

	@Autowired
	private IDoctorDAO doctorDAO;
	
	@Override
	public GetServiceResponseModel getMedicos() {
		GetServiceResponseModel response = new GetServiceResponseModel();
		
		List<DoctorEntity> doctores = doctorDAO.findAll();
		
		if (doctores == null || doctores.isEmpty()) {
			response.setValid(false);
			response.setMessage(MessageUser.NO_SE_ENCOTRARON_MEDICOS);
		} else {
			response.setValid(true);
			response.setMessage(MessageUser.OK);
			response.setResponse(doctores);
		}
		
		return response;
	}

}
