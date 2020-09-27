package com.yavu.apiprofesional.modelos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.annotation.Transient;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "profesional", schema = "apiprofesional")
public class ProfesionalModelo implements Serializable {
	private static final long serialVersionUID = -224599881912266300L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="nombres", nullable = false)
	private String nombres;
	
	@Column(name="apellido_paterno", nullable = false)
	private String apellidoPaterno;
	
	@Column(name="apellido_materno", nullable = false)
	private String apellidoMaterno;
	
	@Column(name="experiencia")
	private Integer experiencia;
	
	@Column(name="vigente", nullable = false)
	private Boolean vigente;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo", insertable = true, updatable = true)
	private TipoModelo idTipo;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="fecha_nacimiento", nullable = false)
	private LocalDate fechaNacimiento;

	@Transient
	private String puerto;

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
