package com.yavu.apiprofesional.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.yavu.apiprofesional.modelos.ProfesionalModelo;

@Repository
public interface ProfesionalRepositorio extends JpaRepository<ProfesionalModelo, Long>, JpaSpecificationExecutor<ProfesionalModelo> {

}
