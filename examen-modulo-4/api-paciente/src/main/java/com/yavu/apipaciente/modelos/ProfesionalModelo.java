package com.yavu.apipaciente.modelos;

import java.io.Serializable;
import java.time.LocalDate;

public class ProfesionalModelo implements Serializable {
	private static final long serialVersionUID = -224599881912266300L;

	private Long id;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Integer experiencia;
	private Boolean vigente;
	private TipoModelo idTipo;
	private LocalDate fechaNacimiento;
	private String puerto;

	public ProfesionalModelo() {}

	public ProfesionalModelo(Long id, String nombres, String apellidoPaterno, String apellidoMaterno, Integer experiencia, Boolean vigente, TipoModelo idTipo, LocalDate fechaNacimiento) {
		super();

		this.id = id;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.experiencia = experiencia;
		this.vigente = vigente;
		this.idTipo = idTipo;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Integer getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Integer experiencia) {
		this.experiencia = experiencia;
	}

	public Boolean getVigente() {
		return vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
	}

	public TipoModelo getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(TipoModelo idTipo) {
		this.idTipo = idTipo;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto( String puerto ) {
		this.puerto = puerto;
	}
}
