package com.yavu.apiagenda.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yavu.apiagenda.modelos.AgendaModelo;

@Repository
public interface AgendaRepositorio extends JpaRepository< AgendaModelo, Long >, JpaSpecificationExecutor< AgendaModelo > {
	@Query( value = "SELECT * FROM agenda a WHERE a.id_paciente = ?", nativeQuery = true )
	public List< AgendaModelo > obtenerAgendaPorPaciente( Long idPaciente );

	@Query( value = "SELECT * FROM agenda a WHERE a.id_profesional = ?", nativeQuery = true )
	public List< AgendaModelo > obtenerAgendaPorProfesional( Long idProfesional );
}
