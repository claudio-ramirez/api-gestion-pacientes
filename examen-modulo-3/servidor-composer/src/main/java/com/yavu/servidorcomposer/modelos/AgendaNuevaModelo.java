package com.yavu.servidorcomposer.modelos;

import java.io.Serializable;
import java.time.LocalDate;

public class AgendaNuevaModelo implements Serializable {
	private static final long serialVersionUID = -2832751691447373016L;

	private Long id;
	private PacienteModelo idPaciente;
	private ProfesionalModelo idProfesional;
	private LocalDate fechaAgenda;
	private Integer horaAgenda;

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
