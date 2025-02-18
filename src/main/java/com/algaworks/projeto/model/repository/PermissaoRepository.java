package com.algaworks.projeto.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.projeto.model.entity.PermissaoEntity;

public interface PermissaoRepository extends JpaRepository<PermissaoEntity, Long> {

}
