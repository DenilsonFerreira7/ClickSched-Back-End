package com.ClickSchad.technology.Controller;
import com.ClickSchad.technology.models.Administrador;
import com.ClickSchad.technology.models.Funcionarios;
import com.ClickSchad.technology.repository.AdministradorRepository;
import com.ClickSchad.technology.repository.FuncionariosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "/admin")
public class AdministradorController {
    @Autowired
    private AdministradorRepository administradorRepository;
    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Administrador> init(@PathVariable(value = "id") Long id) {
        Optional<Administrador> administrador = administradorRepository.findById(id);
        return new ResponseEntity<>(administrador.get(), HttpStatus.OK);

    }

    @GetMapping(value = "/funcionarios/{loja_id}", produces = "application/json")
    public List<Funcionarios> initd(@PathVariable(value = "loja_id") Long lojaId) {
        return funcionariosRepository.findByLojaLojaId(lojaId);
    }
    @PostMapping (value = "/funcionarios/cadastrar", produces = "application/json")
    public ResponseEntity<Funcionarios> cadastrarFuncionario (@RequestBody Funcionarios funcionarios){
        Funcionarios funcionariosave = funcionariosRepository.save(funcionarios);
        return new ResponseEntity<Funcionarios>(funcionariosave, HttpStatus.CREATED);
    }

    @PutMapping("/funcionarios/editar/{id}")
    public ResponseEntity<Funcionarios> updateFuncionario(@PathVariable(value = "id") Long funcionarioId,
                                                          @Valid @RequestBody Funcionarios funcionarioDetails) {
        Optional<Funcionarios> funcionarioOptional = funcionariosRepository.findById(funcionarioId);
        if (funcionarioOptional.isPresent()) {

            Funcionarios funcionario = funcionarioOptional.get();
            funcionario.setFuncionarioNome(funcionarioDetails.getFuncionarioNome());
            funcionario.setFuncionarioCpf(funcionarioDetails.getFuncionarioCpf());

            Funcionarios updatedFuncionario = funcionariosRepository.save(funcionario);
            return ResponseEntity.ok(updatedFuncionario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
