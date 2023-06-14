package com.ClickSchad.technology.controller;
import com.ClickSchad.technology.service.AdministradorService;
import com.ClickSchad.technology.service.LojaService;
import com.ClickSchad.technology.dto.AdministradorDTO;
import com.ClickSchad.technology.dto.FuncionariosDTO;
import com.ClickSchad.technology.models.Administrador;
import com.ClickSchad.technology.models.Funcionarios;
import com.ClickSchad.technology.models.Loja;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/admin")
public class AdministradorController {


    @Autowired
    private final AdministradorService administradorService;
    @Autowired
    private final LojaService lojaService;




    public AdministradorController(AdministradorService administradorService, LojaService lojaService) {
        this.administradorService = administradorService;
        this.lojaService = lojaService;

    }

    // CONSULTAR CADASTRO DO ADMIN
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<AdministradorDTO> consultarProfileAdmin(@PathVariable(value = "id") Long id) {
        AdministradorDTO administradorDTO = administradorService.consultarProfileAdmin(id);
        return new ResponseEntity<>(administradorDTO, HttpStatus.OK);

    }


//EDITAR ADM
    @PutMapping("/editar/{adminId}")
    public ResponseEntity<String> editarAdministrador(
            @PathVariable long adminId, @RequestBody AdministradorDTO administradorDTO) {
        Administrador administrador = administradorService.editarAdministrador(adminId, administradorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("ADMINISTRADOR EDITADO COM SUCESSO");
    }


// LOJA
    @PostMapping("/criarloja")
    public ResponseEntity<String> criarLoja(@Valid @RequestBody Loja loja) {
        Loja criarLoja = lojaService.criarLoja(loja.getLojaNome(), loja.getLojaEndereco(), loja.getLojaTel());
        return ResponseEntity.status(HttpStatus.CREATED).body("LOJA CRIADA COM SUCESSO");

    }


    // CONSULTAR FUNCIONARIOS DA LOJA
    @GetMapping(value = "/funcionarios/{loja_id}", produces = "application/json")
    public ResponseEntity<List<FuncionariosDTO>> consultarFuncionarios(@PathVariable(value = "loja_id") Long lojaId) {
        List<FuncionariosDTO> funcionariosDTOList = administradorService.consultarFuncionariosDaLoja(lojaId);
        return new ResponseEntity<>(funcionariosDTOList, HttpStatus.OK);
    }


    // CADASTRAR FUNCIONARIOS
    @PostMapping(value = "/funcionarios/cadastrar", produces = "application/json")
    public ResponseEntity<String> cadastrarFuncionario(@RequestBody Funcionarios funcionarios) {
        Funcionarios cadastrarFuncionario = administradorService.cadastrarFuncionario(funcionarios);
            return ResponseEntity.status(HttpStatus.CREATED).body("Funcionário cadastrado com sucesso");
        }


    // EDITAR FUNCIONARIO
    @PutMapping("/funcionarios/editar/{id}")
    public ResponseEntity<String> editarFuncionario(
            @PathVariable(value = "id") Long funcionarioId,
            @Valid @RequestBody FuncionariosDTO funcionariosDTO) {
        Funcionarios funcionario = administradorService.editarFuncionario(funcionarioId, funcionariosDTO);
        String nomeFuncionarioEditado = funcionario.getFuncionarioNome();
            return ResponseEntity.status(HttpStatus.CREATED).body("O funcionario " +nomeFuncionarioEditado+ " foi editado com sucesso !!");

    }


    // DELETA FUNCIONARIO
    @DeleteMapping("/funcionarios/deletar/{funcionario_id}")
    public ResponseEntity<?> deletarFuncionario(@PathVariable(value = "funcionario_id") Long funcionarioId) {
        Funcionarios funcionarioDeletado = administradorService.deletarFuncionario(funcionarioId);
        String nomeFuncionario = funcionarioDeletado.getFuncionarioNome();
        return ResponseEntity.status(HttpStatus.OK).body("Funcionario " + nomeFuncionario + " deletado");
    }
}