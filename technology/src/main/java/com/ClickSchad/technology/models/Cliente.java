package com.ClickSchad.technology.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "cliente_id")
    private long clienteId;
    @Column(name = "cliente_login", unique = true)
    private String clienteLogin;
    @Column(name = "cliente_senha")
    private String clienteSenha;
    @Column(name = "cliente_email", unique = true)
    private String clienteEmail;
    @Column(name = "cliente_nome")
    private String clienteNome;
    @Column(name = "cliente_telefone", unique = true)
    private String clienteTelefone;
    @Column(name = "cliente_cpf", unique = true)
    private String clienteCpf;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "cliente_data_nascimento")
    private Date clienteDataNascimento;
    @CreationTimestamp
    @Column(name = "cliente_data_criacao", nullable = false, updatable = false)
    private Timestamp clienteDataCriacao;

    @OneToMany(mappedBy = "cliente")
    private List<Agendamento> agendamento;
}
