package com.dolex.APICitasCMDolex.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CitaModel {

	@JsonProperty("doctor_id")
	private int doctorId;
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

	public CitaModel() {}

	public CitaModel(int doctorId, LocalDate fechaCita, LocalTime horaInicio, String nombrePaciente,
			String correoPaciente) {
		this.doctorId = doctorId;
		this.fechaCita = fechaCita;
		this.horaInicio = horaInicio;
		this.nombrePaciente = nombrePaciente;
		this.correoPaciente = correoPaciente;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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
