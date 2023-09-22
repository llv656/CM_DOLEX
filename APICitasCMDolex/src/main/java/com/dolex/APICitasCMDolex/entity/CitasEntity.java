package com.dolex.APICitasCMDolex.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_citas", schema="cmdolex")
public class CitasEntity {

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ci_cita_id", unique=true)
	private Integer citaID;
    @Column(name = "ci_doctor_id")
	private Integer doctorID;
	@Column(name="cs_nombre_paciente")
	private String nombrePaciente;
	@Column(name="cd_fecha_cita")
	private LocalDate fechaCita;
	@Column(name="ct_hora_cita")
	private LocalTime horaCita;
	@Column(name="ci_configuracion_tiempo_cita_id")
	private Integer confTiempoCitaID;
	@Column(name="cs_correo_paciente")
	private String correoPaciente;
	@Column(name="cts_fecha_registro")
	private LocalDateTime fechaRegistro;
	
	public CitasEntity() {}

	public CitasEntity(Integer citaID, Integer doctorID, String nombrePaciente, LocalDate fechaCita, LocalTime horaCita,
			Integer confTiempoCitaID, String correoPaciente, LocalDateTime fechaRegistro) {
		this.citaID = citaID;
		this.doctorID = doctorID;
		this.nombrePaciente = nombrePaciente;
		this.fechaCita = fechaCita;
		this.horaCita = horaCita;
		this.confTiempoCitaID = confTiempoCitaID;
		this.correoPaciente = correoPaciente;
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getCitaID() {
		return citaID;
	}

	public void setCitaID(Integer citaID) {
		this.citaID = citaID;
	}

	public Integer getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(Integer doctorID) {
		this.doctorID = doctorID;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public LocalDate getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDate fechaCita) {
		this.fechaCita = fechaCita;
	}

	public LocalTime getHoraCita() {
		return horaCita;
	}

	public void setHoraCita(LocalTime horaCita) {
		this.horaCita = horaCita;
	}

	public Integer getConfTiempoCitaID() {
		return confTiempoCitaID;
	}

	public void setConfTiempoCitaID(Integer confTiempoCitaID) {
		this.confTiempoCitaID = confTiempoCitaID;
	}

	public String getCorreoPaciente() {
		return correoPaciente;
	}

	public void setCorreoPaciente(String correoPaciente) {
		this.correoPaciente = correoPaciente;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
}
