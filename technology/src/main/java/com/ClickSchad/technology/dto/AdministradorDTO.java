package com.ClickSchad.technology.dto;
import jakarta.persistence.*;
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
public class AdministradorDTO implements Serializable {


    private String adminLogin;
    private String adminSenha;
    private String adminNome;
    private String adminEmail;
    private String adminTelefone;

}
