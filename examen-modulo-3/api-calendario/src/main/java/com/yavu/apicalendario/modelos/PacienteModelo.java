package com.yavu.apicalendario.modelos;

import java.io.Serializable;
import java.time.LocalDate;

public class PacienteModelo implements Serializable {
	private static final long serialVersionUID = -7529154300485214024L;

	private Long id;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String numeroIdentificacion;
	private Boolean vigente;
	private LocalDate fechaNacimiento;

	public PacienteModelo() {}

	public PacienteModelo( Long id, String nombres, String apellidoPaterno, String apellidoMaterno, String numeroIdentificacion, Boolean vigente, LocalDate fechaNacimiento ) {
		super();

		this.id = id;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.numeroIdentificacion = numeroIdentificacion;
		this.vigente = vigente;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres( String nombres ) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno( String apellidoPaterno ) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno( String apellidoMaterno ) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion( String numeroIdentificacion ) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public Boolean getVigente() {
		return vigente;
	}

	public void setVigente( Boolean vigente ) {
		this.vigente = vigente;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento( LocalDate fechaNacimiento ) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
