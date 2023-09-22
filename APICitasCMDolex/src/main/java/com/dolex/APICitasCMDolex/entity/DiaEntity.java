package com.dolex.APICitasCMDolex.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_dias", schema="cmdolex")
public class DiaEntity {
	
	@Id 
	@Column(name="ci_dia_id", unique=true)
	private Integer diaID;
    @Column(name = "cs_descripcion")
	private String descripcion;
    @Column(name="cts_fecha_registro")
	private LocalDateTime fechaRegistro;

	public DiaEntity() {}

	public DiaEntity(Integer diaID, String descripcion, LocalDateTime fechaRegistro) {
		this.diaID = diaID;
		this.descripcion = descripcion;
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getDiaID() {
		return diaID;
	}

	public void setDiaID(Integer diaID) {
		this.diaID = diaID;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
