package com.ClickSchad.technology.dto;
import jakarta.persistence.Entity;
import lombok.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class FuncionariosDTO implements Serializable {

    private String funcionarioNome;
    private String funcionarioCpf;

}


