package com.yavu.apiagenda.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.yavu.apiagenda.modelos.AgendaModelo;
import com.yavu.apiagenda.modelos.AgendaPrimaryKey;

public interface AgendaRepositorio extends JpaRepository< AgendaModelo, AgendaPrimaryKey > {
	@Query( value = "SELECT * FROM agenda a WHERE a.id_paciente = ?", nativeQuery = true )
	public List< AgendaModelo > obtenerAgendaPorPaciente( Long idUser );
}
