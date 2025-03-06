package Mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.projeto.model.entity.RestauranteEntity;

import dto.RestauranteInputDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class RestauranteMapper {

	private final ModelMapper mapper;
	
	public RestauranteInputDto toDto(RestauranteEntity entity) {
		RestauranteInputDto object = mapper.map(entity, RestauranteInputDto.class);
		return object;
	}
	
	public RestauranteEntity toEntity(RestauranteInputDto dto) {
		return mapper.map(dto, RestauranteEntity.class);
	}
	
}
