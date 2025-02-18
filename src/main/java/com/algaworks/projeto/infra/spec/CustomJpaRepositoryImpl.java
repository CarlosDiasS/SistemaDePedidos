package com.algaworks.projeto.infra.spec;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.algaworks.projeto.model.repository.CustomRepository;

import jakarta.persistence.EntityManager;

public class CustomJpaRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements CustomRepository<T, ID> {

	private EntityManager manager;

	public CustomJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager); // construtor

		this.manager = entityManager;
	}

	@Override
	public Optional<T> buscar() {
		var jpql = "from" + getDomainClass().getName();
		T entity = manager.createQuery(jpql, getDomainClass()).setMaxResults(1).getSingleResult();
		return Optional.ofNullable(entity);

		// consulta sql para buscar uma tupla de de uma tabela
	}

}
