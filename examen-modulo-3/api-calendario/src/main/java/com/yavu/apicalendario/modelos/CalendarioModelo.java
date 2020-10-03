package com.yavu.apicalendario.modelos;

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
@Table( name = "calendario", schema = "apicalendario" )
public class CalendarioModelo implements Serializable {
	private static final long serialVersionUID = -7614562439175926554L;

	@Id
	@Column( name = "id", unique = true, nullable = false )
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;

	@JsonFormat( pattern = "yyyy-MM-dd" )
	@Column( name = "fecha", nullable = false )
	private LocalDate fecha;

	@Column( name = "hora", nullable = false )
	private Integer hora;

	@Column( name = "disponible" )
	private boolean disponible;

	public CalendarioModelo() {}

	public CalendarioModelo( LocalDate fecha, Integer hora, boolean disponible ) {
		super();

		this.fecha = fecha;
		this.hora = hora;
		this.disponible = disponible;
	}

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
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
