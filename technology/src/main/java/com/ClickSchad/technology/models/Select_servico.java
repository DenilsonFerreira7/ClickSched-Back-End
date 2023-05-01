package com.ClickSchad.technology.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name = "select_servico")
public class Select_servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long selectServicoId;
    @CreationTimestamp
    @Column(name = "select_servico_data_criacao", nullable = false, updatable = false)
    private Timestamp selectServicoDataCriacao;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionarios funcionarios;
    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico  servico;

}
