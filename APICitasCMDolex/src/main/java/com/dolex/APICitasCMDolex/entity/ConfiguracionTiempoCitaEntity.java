package com.dolex.APICitasCMDolex.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_configuracion_tiempo_cita", schema="cmdolex")
public class ConfiguracionTiempoCitaEntity {

	@Id 
	@Column(name="ci_configuracion_tiempo_cita_id", unique=true)
	private Integer confTiempoCitaID;
    @Column(name = "ci_minutos_cita")
	private Integer minutosCita;
    @Column(name="cb_estatus")
	private Boolean estatus;
    @Column(name="cts_fecha_registro")
	private LocalDateTime fechaRegistro;
    
	public ConfiguracionTiempoCitaEntity() {}

	public ConfiguracionTiempoCitaEntity(Integer confTiempoCitaID, Integer minutosCita, Boolean estatus,
			LocalDateTime fechaRegistro) {
		this.confTiempoCitaID = confTiempoCitaID;
		this.minutosCita = minutosCita;
		this.estatus = estatus;
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getConfTiempoCitaID() {
		return confTiempoCitaID;
	}

	public void setConfTiempoCitaID(Integer confTiempoCitaID) {
		this.confTiempoCitaID = confTiempoCitaID;
	}

	public Integer getMinutosCita() {
		return minutosCita;
	}

	public void setMinutosCita(Integer minutosCita) {
		this.minutosCita = minutosCita;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
}
