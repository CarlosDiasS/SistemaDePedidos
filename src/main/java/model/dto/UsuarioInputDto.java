package model.dto;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.algaworks.projeto.model.entity.GrupoEntity;

import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UsuarioInputDto {

	
	@NotBlank
	private String nome;
	
	@NotBlank 
	@Email
	private String email;
	
	@NotBlank
	private String senha;
	
	@NotBlank
	private LocalDateTime dataCadastro;
	
	@ManyToMany
	private Set<GrupoEntity> grupo;
	
}
