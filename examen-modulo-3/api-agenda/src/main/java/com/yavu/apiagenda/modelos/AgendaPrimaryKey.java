package com.yavu.apiagenda.modelos;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AgendaPrimaryKey implements Serializable {
	private static final long serialVersionUID = -5709417582304755438L;

	private Long idPaciente;
	private Long idProfesional;

	public AgendaPrimaryKey() {}

	public AgendaPrimaryKey(Long idPaciente, Long idProfesional) {
		super();

		this.idPaciente = idPaciente;
		this.idProfesional = idProfesional;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( idPaciente == null ) ? 0 : idPaciente.hashCode() );
		result = prime * result + ( ( idProfesional == null ) ? 0 : idProfesional.hashCode() );
		return result;
	}

	@Override
	public boolean equals( Object obj ) {
		if ( this == obj )
			return true;
		if ( obj == null )
			return false;
		if ( getClass() != obj.getClass() )
			return false;
		AgendaPrimaryKey other = ( AgendaPrimaryKey ) obj;

		if ( idPaciente == null ) {
			if ( other.idPaciente != null )
				return false;
		} else if ( !idPaciente.equals( other.idPaciente ) )
			return false;

		if ( idProfesional == null ) {
			if ( other.idProfesional != null )
				return false;
		} else if ( !idProfesional.equals( other.idProfesional ) )
			return false;
		return true;
	}
}
