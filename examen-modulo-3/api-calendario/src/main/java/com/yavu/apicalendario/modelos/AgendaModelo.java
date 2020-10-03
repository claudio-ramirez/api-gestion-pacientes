package com.yavu.apicalendario.modelos;

import java.io.Serializable;
import java.time.LocalDate;

public class AgendaModelo implements Serializable {
	private static final long serialVersionUID = -188138404086138217L;

	private Long id;
	private PacienteModelo idPaciente;
	private ProfesionalModelo idProfesional;
	private LocalDate fechaAgenda;
	private Integer horaAgenda;

	public AgendaModelo() {}

	public AgendaModelo( Long id, PacienteModelo idPaciente, ProfesionalModelo idProfesional, LocalDate fechaAgenda, Integer horaAgenda ) {
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

	public PacienteModelo getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente( PacienteModelo idPaciente ) {
		this.idPaciente = idPaciente;
	}

	public ProfesionalModelo getIdProfesional() {
		return idProfesional;
	}

	public void setIdProfesional( ProfesionalModelo idProfesional ) {
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
