package com.yavu.apiagenda.modelos;

import java.time.LocalDate;

public class CalendarioModelo {
	private Long idProfesional;
	private Long idPaciente;
	private LocalDate fecha;
	private Integer hora;
	private boolean disponible;

	public CalendarioModelo() {}

	public CalendarioModelo(Long idPaciente, Long idProfesional, LocalDate fecha, Integer hora, boolean disponible) {
		super();

		this.idPaciente = idPaciente;
		this.idProfesional = idProfesional;
		this.fecha = fecha;
		this.hora = hora;
		this.disponible = disponible;
	}

	public Long getIdProfesional() {
		return idProfesional;
	}

	public void setIdProfesional( Long idProfesional ) {
		this.idProfesional = idProfesional;
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente( Long idPaciente ) {
		this.idPaciente = idPaciente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha( LocalDate fecha ) {
		this.fecha = fecha;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora( Integer hora ) {
		this.hora = hora;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible( boolean disponible ) {
		this.disponible = disponible;
	}
}
