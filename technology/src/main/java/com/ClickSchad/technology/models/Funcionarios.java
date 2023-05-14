package com.ClickSchad.technology.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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


    @NotEmpty(message = "CPF é obrigatório")
    @CPF(message = "CPF inválido")
    @Column(name = "funcionario_cpf", unique = true)
    private String funcionarioCpf;


    @ManyToOne
    @JoinColumn(name = "loja_id")
    @JsonIgnore
    private Loja loja;


}
