package com.dolex.APICitasCMDolex.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetCitasModel {

	@JsonProperty("cita_id")
	private int citaId;
	@JsonProperty("doctor_id")
	private int doctorId;
	@JsonProperty("nombre_doctor")
	private String nombreDoctor;
	@JsonProperty("fecha_cita")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaCita;
	@JsonProperty("hora_inicio")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private LocalTime horaInicio;
	@JsonProperty("nombre_paciente")
	private String nombrePaciente;
	@JsonProperty("correo_paciente")
	private String correoPaciente;
	
	public GetCitasModel() {}

	public GetCitasModel(int citaId, int doctorId, String nombreDoctor, LocalDate fechaCita, LocalTime horaInicio,
			String nombrePaciente, String correoPaciente) {
		this.citaId = citaId;
		this.doctorId = doctorId;
		this.nombreDoctor = nombreDoctor;
		this.fechaCita = fechaCita;
		this.horaInicio = horaInicio;
		this.nombrePaciente = nombrePaciente;
		this.correoPaciente = correoPaciente;
	}

	public int getCitaId() {
		return citaId;
	}

	public void setCitaId(int citaId) {
		this.citaId = citaId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getNombreDoctor() {
		return nombreDoctor;
	}

	public void setNombreDoctor(String nombreDoctor) {
		this.nombreDoctor = nombreDoctor;
	}

	public LocalDate getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDate fechaCita) {
		this.fechaCita = fechaCita;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getCorreoPaciente() {
		return correoPaciente;
	}

	public void setCorreoPaciente(String correoPaciente) {
		this.correoPaciente = correoPaciente;
	}

}
