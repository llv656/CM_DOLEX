package com.dolex.APICitasCMDolex.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dolex.APICitasCMDolex.dto.GetServiceResponseDTO;
import com.dolex.APICitasCMDolex.entity.CitasEntity;
import com.dolex.APICitasCMDolex.entity.ConfiguracionTiempoCitaEntity;
import com.dolex.APICitasCMDolex.entity.DoctorEntity;
import com.dolex.APICitasCMDolex.model.CitaModel;
import com.dolex.APICitasCMDolex.model.GetCitasModel;
import com.dolex.APICitasCMDolex.model.GetCitasPaginadoModel;
import com.dolex.APICitasCMDolex.repository.ICitasDAO;
import com.dolex.APICitasCMDolex.repository.IConfiguracionTiempoCitaDAO;
import com.dolex.APICitasCMDolex.repository.IDoctorDAO;
import com.dolex.APICitasCMDolex.values.MessageUser;

@Service
public class CitasServiceImpl implements ICitasService {

	@Autowired
	private ICitasDAO citasDAO;
	
	@Autowired
	private IConfiguracionTiempoCitaDAO configuracionTiempoCitaDAO;
	
	@Autowired
	private IDoctorDAO doctorDAO;
	
	@Override
	public GetServiceResponseDTO addCita(CitaModel citaModel) {
		GetServiceResponseDTO response = new GetServiceResponseDTO();
		
		if (citaModel.getDoctorId() <= 0
				|| citaModel.getFechaCita() == null
				|| citaModel.getHoraInicio() == null
				|| citaModel.getNombrePaciente() == null || citaModel.getNombrePaciente().isEmpty()
				|| citaModel.getCorreoPaciente() == null || citaModel.getCorreoPaciente().isEmpty()) {
			response.setValid(false);
			response.setMessage(MessageUser.ERR_REGISTRO_CITA);
		} else {
			
			LocalDateTime fechaHoraCita = LocalDateTime.of(citaModel.getFechaCita(), citaModel.getHoraInicio());
			
			List<CitasEntity> citasDoctor = citasDAO.findByDoctorIDAndFechaCita(citaModel.getDoctorId(), citaModel.getFechaCita());
			
			boolean horaReservada = citasDoctor
					.stream()
					.filter(c -> c.getHoraCita().compareTo(citaModel.getHoraInicio()) == 0)
					.count() > 0;
			
			if (horaReservada) {
				response.setValid(false);
				response.setMessage(MessageUser.ERR_HORA_CITA);
			} else if (fechaHoraCita.compareTo(LocalDateTime.now()) >= 0) {
				List<ConfiguracionTiempoCitaEntity> configTiempoCitaList = configuracionTiempoCitaDAO.findAll();
				//Se recupera configuracion de tiempo por cita 
				int confTiempoCitaID = configTiempoCitaList.stream()
						.filter(p -> p.getEstatus()).findFirst().get().getConfTiempoCitaID();
				
				CitasEntity citaEntity = new CitasEntity();
				
				citaEntity.setDoctorID(citaModel.getDoctorId());
				citaEntity.setNombrePaciente(citaModel.getNombrePaciente());
				citaEntity.setCorreoPaciente(citaModel.getCorreoPaciente());
				citaEntity.setFechaCita(citaModel.getFechaCita());
				citaEntity.setHoraCita(citaModel.getHoraInicio());
				citaEntity.setConfTiempoCitaID(confTiempoCitaID);
				citaEntity.setFechaRegistro(LocalDateTime.now());
				
				citasDAO.saveAndFlush(citaEntity);
				
				response.setValid(true);
				response.setMessage(MessageUser.OK);
			} else {
				response.setValid(false);
				response.setMessage(MessageUser.ERR_FECHA_CITA);
			}
			
		}
		
		return response;
	}

	@Override
	public GetServiceResponseDTO getCitas(Integer doctorID, String fecha, Integer pageSize, Integer pageNumber) {
		GetServiceResponseDTO response = new GetServiceResponseDTO();
		
		//configuracion de paginado
		pageSize = pageSize == null || pageSize == 0 ? 5 : pageSize;
		pageNumber = pageNumber == null ? 0 : pageNumber;
		Sort sort = Sort.by(Sort.Order.desc("fechaCita"));
		Pageable paging = PageRequest.of(pageNumber, pageSize, sort);
		
		//Se establece el filtro de la entidad
		CitasEntity filtersConfig = new CitasEntity(); 
		filtersConfig.setDoctorID(doctorID);
		if (fecha != null && !fecha.isEmpty() && fecha.matches("^(\\d{2}-\\d{2}-\\d{4})")) {
			filtersConfig.setFechaCita(LocalDate.of(Integer.valueOf(fecha.split("-")[2]), 
					Integer.valueOf(fecha.split("-")[1]), 
					Integer.valueOf(fecha.split("-")[0])));
		}
		
		//Se configura objeto matcher
		ExampleMatcher matcher = ExampleMatcher.matchingAll()
				.withMatcher("fechaCita", ExampleMatcher.GenericPropertyMatchers.contains())
				.withMatcher("doctorID", ExampleMatcher.GenericPropertyMatchers.contains());
		Example<CitasEntity> filter = Example.of(filtersConfig, matcher);
		
		Page<CitasEntity> page = citasDAO.findAll(filter, paging);
		
		if (!page.isEmpty()) {
			List<GetCitasModel> citas = new ArrayList<>();
			page.getContent().forEach(c -> {
				
				DoctorEntity d = doctorDAO.findById(c.getDoctorID()).get();
				
				GetCitasModel cita = new GetCitasModel();
				cita.setCitaId(c.getCitaID());
				cita.setDoctorId(c.getDoctorID());
				cita.setNombreDoctor(d.getNombre()
						.concat(" ")
						.concat(d.getApellidoPaterno() == null ? "" : d.getApellidoMaterno())
						.concat(" ")
						.concat(d.getApellidoPaterno() == null ? "" : d.getApellidoMaterno())
						.trim());
				cita.setNombrePaciente(c.getNombrePaciente());
				cita.setCorreoPaciente(c.getCorreoPaciente());
				cita.setFechaCita(c.getFechaCita());
				cita.setHoraInicio(c.getHoraCita());
				citas.add(cita);
			});
			
			GetCitasPaginadoModel usersPaging = new GetCitasPaginadoModel();
			citas.sort(Comparator.comparing(GetCitasModel::getFechaCita));
			citas.sort(Comparator.comparing(GetCitasModel::getHoraInicio));
			usersPaging.setItems(citas);
			usersPaging.setPages(page.getTotalPages());
			usersPaging.setTotalItems(page.getTotalElements());
			
			response.setValid(true);
			response.setMessage(MessageUser.OK);
			response.setResponse(usersPaging);
			
		} else {
			response.setValid(false);
			response.setMessage(MessageUser.ERR_GET_CITAS);
		}
		
		return response;
	}

	@Override
	public GetServiceResponseDTO deleteCita(Integer idCita) {
		GetServiceResponseDTO response = new GetServiceResponseDTO();
		
		if (idCita == null || idCita <=0 ) {
			response.setValid(false);
			response.setMessage(MessageUser.ERR_ID_CITA);
		} else {
			citasDAO.deleteById(idCita);
			response.setValid(true);
			response.setMessage(MessageUser.OK);
		}
		
		return response;
	}

}
