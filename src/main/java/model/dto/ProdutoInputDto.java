package model.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProdutoInputDto {

	@NotBlank
	private String nome;

	@NotNull
	private BigDecimal preco;

	
}
