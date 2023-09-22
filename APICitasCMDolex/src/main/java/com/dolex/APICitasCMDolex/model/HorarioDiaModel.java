package com.dolex.APICitasCMDolex.model;

import java.time.LocalTime;

public class HorarioDiaModel {

	private LocalTime horaInicioCita;
	private LocalTime horaFinCita;
	private boolean citaAgendada;
	
	public HorarioDiaModel() {}

	public HorarioDiaModel(LocalTime horaInicioCita, LocalTime horaFinCita, boolean citaAgendada) {
		this.horaInicioCita = horaInicioCita;
		this.horaFinCita = horaFinCita;
		this.citaAgendada = citaAgendada;
	}

	public LocalTime getHoraInicioCita() {
		return horaInicioCita;
	}

	public void setHoraInicioCita(LocalTime horaInicioCita) {
		this.horaInicioCita = horaInicioCita;
	}

	public LocalTime getHoraFinCita() {
		return horaFinCita;
	}

	public void setHoraFinCita(LocalTime horaFinCita) {
		this.horaFinCita = horaFinCita;
	}

	public boolean isCitaAgendada() {
		return citaAgendada;
	}

	public void setCitaAgendada(boolean citaAgendada) {
		this.citaAgendada = citaAgendada;
	}
	
}
