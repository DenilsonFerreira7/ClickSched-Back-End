package com.ClickSchad.technology.controller;
import com.ClickSchad.technology.Service.AdministradorService;
import com.ClickSchad.technology.Service.LojaService;
import com.ClickSchad.technology.dto.AdministradorDTO;
import com.ClickSchad.technology.dto.FuncionariosDTO;
import com.ClickSchad.technology.models.Administrador;
import com.ClickSchad.technology.models.Funcionarios;
import com.ClickSchad.technology.models.Loja;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping(value = "/admin")
public class AdministradorController {

    private final AdministradorService administradorService;
    private final LojaService lojaService;


    public AdministradorController(AdministradorService administradorService, LojaService lojaService) {
        this.administradorService = administradorService;
        this.lojaService = lojaService;
    }

    // CONSULTAR CADASTRO DO ADMIN
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<AdministradorDTO> consultarProfileAdmin(@PathVariable(value = "id") Long id) {
        AdministradorDTO administradorDTO = administradorService.consultarProfileAdmin(id);
        return administradorDTO != null
                ? new ResponseEntity<>(administradorDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
    public ResponseEntity<Loja> criarLoja(@Valid @RequestBody Loja loja) {
        Loja criarLoja = lojaService.criarLoja(loja.getLojaNome(), loja.getLojaEndereco(), loja.getLojaTel());
        return loja != null
                ? ResponseEntity.ok(loja)
                : ResponseEntity.badRequest().build();

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
        if (cadastrarFuncionario != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Funcionário cadastrado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar funcionário");
        }
    }

    // EDITAR FUNCIONARIO
    @PutMapping("/funcionarios/editar/{id}")
    public ResponseEntity<String> editarFuncionario(
            @PathVariable(value = "id") Long funcionarioId,
            @Valid @RequestBody FuncionariosDTO funcionariosDTO) {
        Funcionarios funcionarios = administradorService.editarFuncionario(funcionarioId, funcionariosDTO);
        if (funcionarios != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario foi editado com sucesso !!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erro");
        }
    }

    // DELETA FUNCIONARIO
    @DeleteMapping("/funcionarios/deletar/{id}")
    public ResponseEntity<?> deletarFuncionario(@PathVariable(value = "id") Long id) {
        administradorService.deletarFuncionario(id);
        return ResponseEntity.ok().build();
    }

}