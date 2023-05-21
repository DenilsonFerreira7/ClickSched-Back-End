package com.ClickSchad.technology.dto;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class FuncionariosDTO implements Serializable {

    private String funcionarioNome;
    private String funcionarioCpf;

}


