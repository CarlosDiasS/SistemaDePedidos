package com.algaworks.projeto.infra.spec;

import org.springframework.data.jpa.domain.Specification;
import com.algaworks.projeto.model.entity.RestauranteEntity;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RestauranteComNomeEqual implements Specification<RestauranteEntity> {

	private static final long serialVersion = 1L;

	private String nome;

	@Override
	public Predicate toPredicate(Root<RestauranteEntity> root, CriteriaQuery<?> query,
			CriteriaBuilder criteriaBuilder) {
		return criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
	}

}
