package com.dolex.APICitasCMDolex.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_horarios_x_dia", schema="cmdolex")
public class HorarioXDiaEntity {

	@Id 
	@Column(name="ci_horario_id", unique=true)
	private Integer horarioID;
	@Column(name="ci_dia_id")
	private Integer diaID;
    @Column(name = "ct_hora_inicio")
	private LocalTime horaInicio;
    @Column(name = "ct_hora_fin")
	private LocalTime horaFin;
    @Column(name="cts_fecha_registro")
	private LocalDateTime fechaRegistro;
	
	public HorarioXDiaEntity() {}

	public HorarioXDiaEntity(Integer horarioID, Integer diaID, LocalTime horaInicio, LocalTime horaFin,
			LocalDateTime fechaRegistro) {
		this.horarioID = horarioID;
		this.diaID = diaID;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getHorarioID() {
		return horarioID;
	}

	public void setHorarioID(Integer horarioID) {
		this.horarioID = horarioID;
	}

	public Integer getDiaID() {
		return diaID;
	}

	public void setDiaID(Integer diaID) {
		this.diaID = diaID;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
