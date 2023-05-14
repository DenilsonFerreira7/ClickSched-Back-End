package com.ClickSchad.technology.controller;
import com.ClickSchad.technology.dto.AdministradorDTO;
import com.ClickSchad.technology.dto.FuncionariosDTO;
import com.ClickSchad.technology.models.Administrador;
import com.ClickSchad.technology.models.Funcionarios;
import com.ClickSchad.technology.repository.AdministradorRepository;
import com.ClickSchad.technology.repository.FuncionariosRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping (value = "/admin")
public class AdministradorController {

    @Autowired
    private AdministradorRepository administradorRepository;
    @Autowired
    private FuncionariosRepository funcionariosRepository;
    @Autowired
    private ModelMapper modelMapper;


    public AdministradorController(FuncionariosRepository funcionariosRepository, ModelMapper modelMapper) {
        this.funcionariosRepository = funcionariosRepository;
        this.modelMapper = modelMapper;
    }


    //CONSULTAR CADASTRO DO ADMIN
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<AdministradorDTO> consultarProfileAdmin(@PathVariable(value = "id") Long id) {
        Optional<Administrador> administrador = administradorRepository.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        AdministradorDTO administradorDTO = modelMapper.map(administrador.get(), AdministradorDTO.class);
        return new ResponseEntity<>(administradorDTO, HttpStatus.OK);
    }


    // EDITAR ADM
    @PutMapping("/editar/{id}")
    public ResponseEntity<Administrador> editarAdministradorById (@PathVariable(value = "id") Long id,
                                                          @Valid @RequestBody AdministradorDTO administradorDTO) {
        Optional<Administrador> administradorOptional = administradorRepository.findById(id);

        if (administradorOptional.isPresent()) {
            ModelMapper modelMapperEditFunc = new ModelMapper();
            Administrador administrador = administradorOptional.get();
            modelMapper.map(administradorDTO,administrador);
            Administrador upfateAdm = administradorRepository.save(administrador);
            return ResponseEntity.ok(upfateAdm);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


// CONSULTAR FUNCIONARIOS DA LOJA
    @GetMapping(value = "/funcionarios/{loja_id}", produces = "application/json")
    public List<FuncionariosDTO> consultarFuncionario (@PathVariable(value = "loja_id") Long lojaId) {
        List<Funcionarios> funcionariosList = funcionariosRepository.findByLojaLojaId(lojaId);
        List<FuncionariosDTO> funcionariosDTOList = funcionariosList.stream()
                .map(funcionarios -> modelMapper.map(funcionarios, FuncionariosDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(funcionariosDTOList, HttpStatus.OK).getBody();

    }


// CADASTRAR FUNCIONARIOS
    @PostMapping (value = "/funcionarios/cadastrar", produces = "application/json")
    public ResponseEntity<Funcionarios> cadastrarFuncionario (@RequestBody FuncionariosDTO funcionariosDTO){
        ModelMapper modelMapperCadastrarFuncionario = new ModelMapper();
        Funcionarios funcionarios = modelMapper.map(funcionariosDTO, Funcionarios.class);
        Funcionarios funcionariosave = funcionariosRepository.save(funcionarios);
        return new ResponseEntity<>(funcionariosave, HttpStatus.CREATED);
    }


// EDITAR FUNCIONARIO
    @PutMapping("/funcionarios/editar/{id}")
    public ResponseEntity<Funcionarios> editarFuncionario(
        @PathVariable(value = "id") Long funcionarioId,
        @Valid @RequestBody FuncionariosDTO funcionariosDTO) {
    Optional<Funcionarios> funcionarioOptional = funcionariosRepository.findById(funcionarioId);

    if (funcionarioOptional.isPresent()) {
        Funcionarios funcionarios = funcionarioOptional.get();
        funcionarios.setFuncionarioNome(funcionariosDTO.getFuncionarioNome());
        funcionarios.setFuncionarioCpf(funcionariosDTO.getFuncionarioCpf());
        Funcionarios updatedFuncionario = funcionariosRepository.save(funcionarios);
        return ResponseEntity.ok(updatedFuncionario);
    } else {
        return ResponseEntity.notFound().build();
    }
}
}