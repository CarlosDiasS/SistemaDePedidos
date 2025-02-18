package com.algaworks.projeto.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.projeto.model.entity.CidadeEntity;

public interface CidadeRepository extends JpaRepository<CidadeEntity, Long>{

}
