package com.ClickSchad.technology.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
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
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private long adminId;
    @Column(name = "admin_login", unique = true)
    private String adminLogin;
    @Column(name = "admin_senha")
    private String adminSenha;
    @Column(name = "admin_nome")
    private String adminNome;
    @Column(name = "admin_email", unique = true)
    private String adminEmail;
    @CPF
    @Column(name = "admin_cpf", unique = true)
    private String adminCpf;
    @Column(name = "admin_telefone", unique = true)
    private String adminTelefone;
    @CreationTimestamp
    @Column(name = "admin_data_criacao", nullable = false, updatable = false)
    private Timestamp adminDataCriacao;


    @OneToMany(mappedBy = "administrador")
    @JsonIgnore
    private List<Loja> lojas;


    }





