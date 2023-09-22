package com.dolex.APICitasCMDolex.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dolex.APICitasCMDolex.dto.GetServiceResponseDTO;
import com.dolex.APICitasCMDolex.entity.CitasEntity;
import com.dolex.APICitasCMDolex.entity.ConfiguracionTiempoCitaEntity;
import com.dolex.APICitasCMDolex.entity.HorarioXDiaEntity;
import com.dolex.APICitasCMDolex.model.HorarioDiaModel;
import com.dolex.APICitasCMDolex.repository.ICitasDAO;
import com.dolex.APICitasCMDolex.repository.IConfiguracionTiempoCitaDAO;
import com.dolex.APICitasCMDolex.repository.IDiasDAO;
import com.dolex.APICitasCMDolex.repository.IHorarioXDiaDAO;
import com.dolex.APICitasCMDolex.values.MessageUser;

@Service
public class HorarioServiceImpl implements IHorarioService {
	
	@Autowired
	private IHorarioXDiaDAO horarioDAO;
	
	@Autowired
	private IDiasDAO diasDAO;
	
	@Autowired
	private IConfiguracionTiempoCitaDAO configuracionTiempoCitaDAO;
	
	@Autowired
	private ICitasDAO citasDAO;

	@Override
	public GetServiceResponseDTO getHorarios(Integer doctorID, String fecha) {
		GetServiceResponseDTO response = new GetServiceResponseDTO();
		
		if (doctorID == null || doctorID <=0 || fecha == null || fecha.isEmpty() || !fecha.matches("^(\\d{2}-\\d{2}-\\d{4})")) {
			response.setValid(false);
			response.setMessage(MessageUser.ERR_CAMPOS_HORARIOS);
		} else {
			
			List<ConfiguracionTiempoCitaEntity> configTiempoCitaList = configuracionTiempoCitaDAO.findAll();
			//Se recupera configuracion de tiempo por cita 
			ConfiguracionTiempoCitaEntity confTiempoCita = configTiempoCitaList.stream()
					.filter(p -> p.getEstatus()).findFirst().get();
			
			List<HorarioXDiaEntity> horariosXDiaList = horarioDAO.findAll();
			
			//Empieza la configuracion de horario de la fecha solicitada
			
			//Se establece la fecha cita
			LocalDate fechaCita = LocalDate.of(Integer.valueOf(fecha.split("-")[2]), 
					Integer.valueOf(fecha.split("-")[1]), 
					Integer.valueOf(fecha.split("-")[0]));
			
			//Se recupera el numero del dia de la semana {1 - 7}
			int diaSemana = fechaCita.getDayOfWeek().getValue();
			
			//Se recupera el horario del dia
			HorarioXDiaEntity horarioDia = horariosXDiaList.stream().filter(p -> p.getDiaID() == diaSemana).findFirst().get();
			
			//Se recupera el nombre del dia de la semana
			String nombreDia = diasDAO.findById(diaSemana).get().getDescripcion();
			
			//Se recuperan las citas del doctor en el dia
			List<CitasEntity> citasDoctor = citasDAO.findByDoctorIDAndFechaCita(doctorID, fechaCita);
			
			List<HorarioDiaModel> horarioDiaList = new ArrayList<>();
			
			LocalTime hora = horarioDia.getHoraInicio();
			while (hora.compareTo(horarioDia.getHoraFin()) < 0) {
				HorarioDiaModel horarioDiaModel = new HorarioDiaModel();
				horarioDiaModel.setHoraInicioCita(hora);
			
				final LocalTime horaInicioCita = hora;
				boolean horaReservada = citasDoctor
						.stream()
						.filter(c -> c.getHoraCita().compareTo(horaInicioCita) == 0)
						.count() > 0;
				if (citasDoctor != null 
						&& !citasDoctor.isEmpty()
						&& horaReservada) {
					horarioDiaModel.setCitaAgendada(true);
				} else {
					horarioDiaModel.setCitaAgendada(false);
				}
				
				hora = hora.plusMinutes(confTiempoCita.getMinutosCita());
				horarioDiaModel.setHoraFinCita(hora);
				
				horarioDiaList.add(horarioDiaModel);
			}
			
			response.setValid(true);
			response.setMessage(MessageUser.OK);
			response.setResponse(horarioDiaList);
		}
		
		return response;
	}

}
