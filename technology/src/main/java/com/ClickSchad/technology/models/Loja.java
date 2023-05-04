package com.ClickSchad.technology.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name = "loja")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loja_id")
    private long lojaId;
    @Column(name = "loja_nome", unique = true)
    private String lojaNome;
    @Column(name = "loja_endereco", unique = true)
    private String lojaEndereco;
    @Column(name = "loja_tel", unique = true)
    private  String lojaTel;


    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Administrador administrador;

    @OneToMany(mappedBy = "loja")
    @JsonIgnore
    private List<Funcionarios> funcionarios;
    @OneToMany(mappedBy = "loja")
    @JsonIgnore
    private List<Servico> servicos;

}
