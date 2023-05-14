package com.ClickSchad.technology.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name = "agendamento")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agendamento_id")
    private long agendamentoId;



    @Column(name = "agendamentoStatus")
    private String agendamentoStatus;

    @Column(name = "agendamento_data_criacao")
    private Timestamp agendamentoDataCriacao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "select_servico_id")
    private Select_servico selectServico;


    @ManyToOne
    @JoinColumn(name = "loja_id")
    private Loja loja;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionarios funcionarios;
}