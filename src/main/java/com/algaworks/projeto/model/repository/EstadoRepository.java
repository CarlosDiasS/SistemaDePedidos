package com.algaworks.projeto.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.projeto.model.entity.EstadoEntity;

public interface EstadoRepository extends JpaRepository<EstadoEntity, Long> {

}
