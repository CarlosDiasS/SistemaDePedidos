package model.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.algaworks.projeto.model.entity.ProdutoEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RestauranteInputDto {

	@NotBlank
	private String nome;

	@NotNull
	private BigDecimal taxaFrete;

	private List<ProdutoEntity> produtos;

	@NotNull
	private UUID cozinhaId;

	@NotNull
	private UUID formaPagamentoId;

}
