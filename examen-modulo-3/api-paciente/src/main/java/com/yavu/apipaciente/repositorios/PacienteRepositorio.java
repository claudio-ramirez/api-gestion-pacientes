package com.yavu.apipaciente.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.yavu.apipaciente.modelos.PacienteModelo;

@Repository
public interface PacienteRepositorio extends JpaRepository<PacienteModelo, Long>, JpaSpecificationExecutor<PacienteModelo> {
	
}
