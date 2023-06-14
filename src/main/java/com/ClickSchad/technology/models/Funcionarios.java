package com.ClickSchad.technology.models;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name = "funcionarios")
public class Funcionarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionario_id")
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
    private Loja loja;


}
