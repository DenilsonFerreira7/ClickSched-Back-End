package com.ClickSchad.technology.service;
import com.ClickSchad.technology.dto.AdministradorDTO;
import com.ClickSchad.technology.dto.FuncionariosDTO;
import com.ClickSchad.technology.exeptions.NotFoundExeption;
import com.ClickSchad.technology.models.Administrador;
import com.ClickSchad.technology.models.Funcionarios;
import com.ClickSchad.technology.repository.AdministradorRepository;
import com.ClickSchad.technology.repository.FuncionariosRepository;
import com.ClickSchad.technology.repository.LojaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public
class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;
    private final FuncionariosRepository funcionariosRepository;
    private final LojaRepository lojaRepository;
    private final ModelMapper modelMapper;


    public AdministradorService(AdministradorRepository administradorRepository,
                                FuncionariosRepository funcionariosRepository,
                                LojaRepository lojaRepository,
                                ModelMapper modelMapper) {
        this.administradorRepository = administradorRepository;
        this.funcionariosRepository = funcionariosRepository;
        this.lojaRepository = lojaRepository;
        this.modelMapper = modelMapper;
    }

    public AdministradorDTO consultarProfileAdmin(Long id) {
        Optional<Administrador> administrador = administradorRepository.findById(id);
        return administrador.map(adm -> modelMapper.map(adm, AdministradorDTO.class)).orElse(null);
    }

    public Administrador editarAdministrador(long adminId, AdministradorDTO administradorDto) {
        Administrador administrador = administradorRepository.findById(adminId)
                .orElseThrow(() -> new NotFoundExeption ("Administrador não encontrado"+ adminId));

        administrador.setAdminLogin(administradorDto.getAdminLogin());
        administrador.setAdminSenha(administradorDto.getAdminSenha());
        administrador.setAdminNome(administradorDto.getAdminNome());
        administrador.setAdminEmail(administradorDto.getAdminEmail());
        administrador.setAdminCpf(administradorDto.getAdminCpf());
        administrador.setAdminTelefone(administradorDto.getAdminTelefone());

        return administradorRepository.save(administrador);
    }


    public List<FuncionariosDTO> consultarFuncionariosDaLoja(Long lojaId) {
        List<Funcionarios> funcionariosList = funcionariosRepository.findByLojaLojaId(lojaId);
        return funcionariosList.stream()
                .map(funcionarios -> modelMapper.map(funcionarios, FuncionariosDTO.class))
                .collect(Collectors.toList());
    }


    public Funcionarios cadastrarFuncionario(Funcionarios funcionariosDTO) {
        Funcionarios funcionarios = modelMapper.map(funcionariosDTO, Funcionarios.class);
        if(funcionarios == null)
            throw  new NotFoundExeption("Erro ao cadastrar");
        return funcionariosRepository.save(funcionarios);

    }


    public Funcionarios editarFuncionario(Long funcionarioId, FuncionariosDTO funcionariosDTO) {
        Optional<Funcionarios> funcionarioOptional = funcionariosRepository.findById(funcionarioId);
        return funcionarioOptional.map(funcionarios -> {
            funcionarios.setFuncionarioNome(funcionariosDTO.getFuncionarioNome());
            funcionarios.setFuncionarioCpf(funcionariosDTO.getFuncionarioCpf());
            return funcionariosRepository.save(funcionarios);
        }).orElseThrow(() -> new NotFoundExeption ("Funcionario não encontrado"));
    }


    public Funcionarios deletarFuncionario(Long funcionarioId) {
        Funcionarios funcionarioDeletado = funcionariosRepository.findById(funcionarioId).orElse(null);
        if (funcionarioDeletado != null) {
            throw new NotFoundExeption("Esse funcionário não existe: " + funcionarioId);
        }
        funcionariosRepository.delete(funcionarioDeletado);
        return funcionarioDeletado;
    }
}