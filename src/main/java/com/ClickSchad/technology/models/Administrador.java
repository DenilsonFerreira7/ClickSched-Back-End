package com.ClickSchad.technology.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name = "administrador")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private long adminId;

    @NotEmpty(message = "Nome de usuario é obrigatório")
    @Column(name = "admin_login", unique = true)
    private String adminLogin;

    @NotEmpty(message = "Senha de usuario é obrigatório")
    @Column(name = "admin_senha")
    private String adminSenha;

    @NotEmpty(message = "Nome é obrigatório")
    @Column(name = "admin_nome")
    private String adminNome;
    @NotEmpty(message = "Email é obrigatorio é obrigatório")
    @Column(name = "admin_email", unique = true)
    private String adminEmail;

    @NotEmpty(message = "CPF é obrigatório")
    @CPF
    @Column(name = "admin_cpf", unique = true)
    private String adminCpf;

    @NotEmpty(message = "Telefone é obrigatório")
    @Column(name = "admin_telefone", unique = true)
    private String adminTelefone;

    @Column(name = "admin_data_criacao", updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp adminDataCriacao;

    @OneToMany(mappedBy = "administrador")
    private List<Loja> lojas;


    }