package com.ClickSchad.technology.dto;
import com.ClickSchad.technology.models.Funcionarios;
import com.ClickSchad.technology.models.Servico;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class LojaDTO implements Serializable {

    private long lojaId;
    private String lojaNome;
    private String lojaEndereco;
    private String lojaTel;

    private List<Funcionarios> funcionarios;

    private List<Servico> servicos;

    }

