package com.yavu.apiagenda.modelos;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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

	@EmbeddedId
	private AgendaPrimaryKey agendaPrimaryKey;

	@Column( name = "confirmacion" )
	private boolean confirmacion;

	@JsonFormat( pattern = "yyyy-MM-dd" )
	@Column( name = "fecha_agenda", nullable = false )
	private LocalDate fechaAgenda;

	@Column( name = "hora_agenda", nullable = false )
	private Integer horaAgenda;

	public AgendaModelo() {}

	public AgendaModelo(AgendaPrimaryKey agendaPrimaryKey, boolean confirmacion, LocalDate fechaAgenda, Integer horaAgenda) {
		super();

		this.agendaPrimaryKey = agendaPrimaryKey;
		this.confirmacion = confirmacion;
		this.fechaAgenda = fechaAgenda;
		this.horaAgenda = horaAgenda;
	}

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public AgendaPrimaryKey getAgendaPrimaryKey() {
		return agendaPrimaryKey;
	}

	public void setAgendaPrimaryKey( AgendaPrimaryKey agendaPrimaryKey ) {
		this.agendaPrimaryKey = agendaPrimaryKey;
	}

	public boolean isConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion( boolean confirmacion ) {
		this.confirmacion = confirmacion;
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
