package com.dolex.APICitasCMDolex.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DoctorModel {

	@JsonProperty("doctor_id")
	private int doctorId;
	@JsonProperty("nombre_completo")
	private String nombreCompleto;
	private String telefono;
	
	public DoctorModel() {}

	public DoctorModel(int doctorId, String nombreCompleto, String telefono) {
		this.doctorId = doctorId;
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
