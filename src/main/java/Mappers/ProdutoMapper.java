package Mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.projeto.model.entity.ProdutoEntity;

import dto.ProdutoInputDto;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProdutoMapper {

	private final ModelMapper mapper;
	
	public ProdutoInputDto toDto(ProdutoEntity entity) {
		ProdutoInputDto aux = mapper.map(entity, ProdutoInputDto.class);
		return aux;
	}
	
	public ProdutoEntity toEntity(ProdutoInputDto dto) {
		return mapper.map(dto, ProdutoEntity.class);
	}
	
	
}
