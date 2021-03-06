package com.yavu.servidorcomposer.modelos;

import java.io.Serializable;

public class TipoModelo implements Serializable {
	private static final long serialVersionUID = -3161401212770175749L;

	private Long id;
	private String nombre;
	private String descripcion;
	private Boolean vigente;

	public TipoModelo() {}

	public TipoModelo(Long id, String nombre, String descripcion, Boolean vigente) {
		super();

		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.vigente = vigente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getVigente() {
		return vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
	}
}
