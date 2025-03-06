package Mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.projeto.model.entity.CozinhaEntity;

import dto.CozinhaInputDto;
import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor
public class CozinhaMapper {

	private final  ModelMapper modelMapper;
	
	//mapper de entity para dto
	public CozinhaInputDto toDto(CozinhaEntity entity) {
		CozinhaInputDto dto = modelMapper.map(entity, CozinhaInputDto.class);
		return dto;
	}
	
	//mapper de dto para entity
	public CozinhaEntity toEntity(CozinhaInputDto dto) {
		return modelMapper.map(dto, CozinhaEntity.class);
	}
	
	
	
}
