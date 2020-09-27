package com.yavu.apiprofesional.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yavu.apiprofesional.modelos.TipoModelo;

public interface TipoRepositorio extends JpaRepository<TipoModelo, Long>, JpaSpecificationExecutor<TipoModelo> {

}
