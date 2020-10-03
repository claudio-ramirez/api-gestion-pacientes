package com.yavu.apiagenda.modelos;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table( name = "agenda", schema = "apiagenda" )
public class AgendaModelo implements Serializable {
	private static final long serialVersionUID = -8130481353707414206L;

	@Id
	@Column( name = "id", unique = true, nullable = false )
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;

//	@ManyToOne
//	@JoinColumn(name = "id_paciente")
	@Column( name = "id_paciente", nullable = false )
	private Long idPaciente;

//	@ManyToOne
//	@JoinColumn(name = "id_profesional")
	@Column( name = "id_profesional", nullable = false )
	private Long idProfesional;

	@JsonFormat( pattern = "yyyy-MM-dd" )
	@Column( name = "fecha_agenda", nullable = false )
	private LocalDate fechaAgenda;

	@Column( name = "hora_agenda", nullable = false )
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
