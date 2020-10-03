package com.yavu.apiagenda.modelos;

import java.io.Serializable;
import java.time.LocalDate;

public class CalendarioModelo implements Serializable {
	private static final long serialVersionUID = 3988763878294433142L;

	private Long id;
	private LocalDate fecha;
	private Integer hora;
	private boolean disponible;

	public CalendarioModelo() {}

	public CalendarioModelo( Long id, LocalDate fecha, Integer hora, boolean disponible ) {
		super();

		this.id = id;
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
