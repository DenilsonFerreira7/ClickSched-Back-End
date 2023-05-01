package com.ClickSchad.technology.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servico_id")
    private long servicoId;
    @Column(name = "servico_nome")
    private String servicoNome;
    @Column(name = "servico_preco",precision = 10, scale = 2)
    private BigDecimal servicoPreco;
    @Column(name = "servico_descricao")
    private String servicoDescricao;


    @ManyToOne
    @JoinColumn(name = "loja_id")
    private Loja loja;




}
