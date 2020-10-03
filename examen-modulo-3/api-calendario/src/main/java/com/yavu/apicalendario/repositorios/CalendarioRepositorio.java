package com.yavu.apicalendario.repositorios;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yavu.apicalendario.modelos.CalendarioModelo;

@Repository
public interface CalendarioRepositorio extends JpaRepository< CalendarioModelo, Long >, JpaSpecificationExecutor< CalendarioModelo > {
	@Query( value = "SELECT * FROM apicalendario.calendario c WHERE c.fecha = ? AND c.hora = ?", nativeQuery = true )
	public Optional< CalendarioModelo > obtenerCalendarioPorFechaHora( @Param("fecha") LocalDate fecha, @Param("hora") Integer hora );
}
