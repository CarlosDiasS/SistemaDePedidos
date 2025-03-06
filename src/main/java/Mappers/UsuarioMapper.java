package Mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.projeto.model.entity.UsuarioEntity;

import lombok.AllArgsConstructor;
import model.dto.UsuarioInputDto;

@Component
@AllArgsConstructor
public class UsuarioMapper {

	private final ModelMapper mapper;
	
	public UsuarioInputDto toDto(UsuarioEntity entity) {
		UsuarioInputDto dto = mapper.map(entity, UsuarioInputDto.class);
		return dto;
	}
	
	public UsuarioEntity toEntity(UsuarioInputDto dto) {
		return mapper.map(dto, UsuarioEntity.class);
	}
	
}
