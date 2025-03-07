package dto;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProdutoInputDto {

	@NotBlank
	private String nome;

	@NotNull
	private BigDecimal preco;
	
	@NotBlank
	private UUID restauranteId;

	
}
