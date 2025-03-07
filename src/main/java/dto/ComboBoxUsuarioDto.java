package dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ComboBoxUsuarioDto {

	@NotBlank
	private String senha;
	
	@NotBlank
	private UUID id;
	
}
