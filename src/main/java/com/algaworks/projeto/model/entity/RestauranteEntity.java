package com.algaworks.projeto.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "restaurante")
public class RestauranteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @NotBlank
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private BigDecimal taxaFrete;
    
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime dataCadastro;
    
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime dataUpdate;
    
    @OneToMany(mappedBy = "restaurante")
    private List<ProdutoEntity> produtos;
    
    @ManyToOne
    @JoinColumn(name = "cozinha_id", nullable= false)
    private CozinhaEntity cozinha;
    
    @ManyToOne
    @JoinColumn(name = "forma_pagamento_id", nullable = false)
    private FormaPagamentoEntity formaPagamento;
}
