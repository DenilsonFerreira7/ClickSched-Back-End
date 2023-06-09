package com.ClickSchad.technology.service;
import com.ClickSchad.technology.models.Administrador;
import com.ClickSchad.technology.models.Loja;
import com.ClickSchad.technology.repository.AdministradorRepository;
import com.ClickSchad.technology.repository.FuncionariosRepository;
import com.ClickSchad.technology.repository.LojaRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LojaService {
    private final LojaRepository lojaRepository;
    private final AdministradorRepository administradorRepository;
    private final FuncionariosRepository funcionariosRepository;

    public LojaService(LojaRepository lojaRepository, AdministradorRepository administradorRepository, FuncionariosRepository funcionariosRepository) {
        this.lojaRepository = lojaRepository;
        this.administradorRepository = administradorRepository;
        this.funcionariosRepository = funcionariosRepository;
    }

    public Loja criarLoja (String lojaNome, String lojaEndereco, String lojaTel) {
        Optional<Administrador> administradorOptional = administradorRepository.findTopByOrderByAdminIdDesc();
        if (administradorOptional.isEmpty()) {
            // Não foi encontrado nenhum administrador
            return null;
        }

        Administrador administrador = administradorOptional.get();

        Loja loja = new Loja();
        loja.setLojaNome(lojaNome);
        loja.setLojaEndereco(lojaEndereco);
        loja.setLojaTel(lojaTel);
        loja.setAdministrador(administrador);
        return lojaRepository.save(loja);
    }
}








