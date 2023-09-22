package com.dolex.APICitasCMDolex.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_doctores", schema="cmdolex")
public class DoctorEntity {

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ci_doctor_id", unique=true)
	private Integer doctorID;
	@Column(name="cs_nombre")
	private String nombre;
	@Column(name="cs_apellido_paterno")
	private String apellidoPaterno;
	@Column(name="cs_apellido_materno")
	private String apellidoMaterno;
	@Column(name="cs_telefono")
	private String telefono;
	@Column(name="cts_fecha_registro")
	private LocalDateTime fechaRegistro;
	
	public DoctorEntity() {}
	
	public DoctorEntity(Integer doctorID, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono,
			LocalDateTime fechaRegistro) {
		this.doctorID = doctorID;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.telefono = telefono;
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(Integer doctorID) {
		this.doctorID = doctorID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	

}
