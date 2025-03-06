package model.dto;

import Utils.EnumCategoria;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CozinhaInputDto {

	public static interface CozinhaInputPostDto{
	}
	
	public static interface CozinhaInputPutDto{
	}
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private EnumCategoria categoria;
}
