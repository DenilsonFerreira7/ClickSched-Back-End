package com.ClickSchad.technology.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.CreatedDate;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name = "funcionarios")
public class Funcionarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long funcionarioId;
    @Column(name = "funcionario_nome")
    private String funcionarioNome;
    @CPF
    @Column(name = "funcionario_cpf", unique = true)
    private String funcionarioCpf;
    @CreationTimestamp
    @Column(name = "funcionario_data_criacao", nullable = false, updatable = false)
    private Timestamp funcionarioDataCriacao;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "loja_id")
    private Loja loja;


}
