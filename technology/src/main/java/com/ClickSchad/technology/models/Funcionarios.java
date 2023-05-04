package com.ClickSchad.technology.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;
import java.sql.Timestamp;


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
    @NotEmpty(message = "nome é obrigatorio")
    @Column(name = "funcionario_nome")
    private String funcionarioNome;
    @CPF
    @NotEmpty(message = "numero do cpf é obrigatorio")
    @Column(name = "funcionario_cpf", unique = true)
    private String funcionarioCpf;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "loja_id")
    private Loja loja;


}
