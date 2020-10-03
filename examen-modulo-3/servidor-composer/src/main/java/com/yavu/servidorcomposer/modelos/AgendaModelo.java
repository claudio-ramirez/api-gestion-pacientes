package com.yavu.servidorcomposer.modelos;

import java.io.Serializable;
import java.time.LocalDate;

public class AgendaModelo implements Serializable {
	private static final long serialVersionUID = 267368124646016122L;

	private Long id;
	private Long idPaciente;
	private Long idProfesional;
	private LocalDate fechaAgenda;
	private Integer horaAgenda;

	public AgendaModelo() {}

	public AgendaModelo( Long id, Long idPaciente, Long idProfesional, LocalDate fechaAgenda, Integer horaAgenda ) {
		super();

		this.id = id;
		this.idPaciente = idPaciente;
		this.idProfesional = idProfesional;
		this.fechaAgenda = fechaAgenda;
		this.horaAgenda = horaAgenda;
	}

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente( Long idPaciente ) {
		this.idPaciente = idPaciente;
	}

	public Long getIdProfesional() {
		return idProfesional;
	}

	public void setIdProfesional( Long idProfesional ) {
		this.idProfesional = idProfesional;
	}

	public LocalDate getFechaAgenda() {
		return fechaAgenda;
	}

	public void setFechaAgenda( LocalDate fechaAgenda ) {
		this.fechaAgenda = fechaAgenda;
	}

	public Integer getHoraAgenda() {
		return horaAgenda;
	}

	public void setHoraAgenda( Integer horaAgenda ) {
		this.horaAgenda = horaAgenda;
	}
}
