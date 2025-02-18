package com.algaworks.projeto.infra.spec;

import org.springframework.data.jpa.domain.Specification;

import com.algaworks.projeto.model.entity.RestauranteEntity;

public class RestauranteSpecs {

	public static Specification<RestauranteEntity> comNomeEqual(String nome){
		return (root, query, builder) -> 
		builder.like(root.get("nome"), "%" + nome + "%");
	}
	
}
