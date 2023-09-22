package com.dolex.APICitasCMDolex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolex.APICitasCMDolex.dto.GetServiceResponseDTO;
import com.dolex.APICitasCMDolex.entity.DoctorEntity;
import com.dolex.APICitasCMDolex.model.DoctorModel;
import com.dolex.APICitasCMDolex.repository.IDoctorDAO;
import com.dolex.APICitasCMDolex.values.MessageUser;

@Service
public class MedicosServiceImpl implements IMedicosService {

	@Autowired
	private IDoctorDAO doctorDAO;
	
	@Override
	public GetServiceResponseDTO getMedicos() {
		GetServiceResponseDTO response = new GetServiceResponseDTO();
		
		List<DoctorEntity> doctores = doctorDAO.findAll();
		
		List<DoctorModel> doctoresResponse = new ArrayList<>();
		
		doctores.forEach(d -> {
			DoctorModel doctorModel = new DoctorModel();
			doctorModel.setDoctorId(d.getDoctorID());
			doctorModel.setNombreCompleto(
					d.getNombre()
					.concat(" ")
					.concat(d.getApellidoPaterno() == null ? "" : d.getApellidoMaterno())
					.concat(" ")
					.concat(d.getApellidoPaterno() == null ? "" : d.getApellidoMaterno())
					.trim()
					);
			doctorModel.setTelefono(d.getTelefono());
			doctoresResponse.add(doctorModel);
		});
		
		if (doctoresResponse.isEmpty()) {
			response.setValid(false);
			response.setMessage(MessageUser.NO_SE_ENCOTRARON_MEDICOS);
		} else {
			response.setValid(true);
			response.setMessage(MessageUser.OK);
			response.setResponse(doctoresResponse);
		}
		
		return response;
	}

}
