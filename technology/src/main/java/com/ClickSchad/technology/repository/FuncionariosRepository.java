package com.ClickSchad.technology.repository;
import com.ClickSchad.technology.models.Funcionarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FuncionariosRepository extends CrudRepository<Funcionarios,Long > {
   List<Funcionarios> findByLojaLojaId(Long lojaId);

}
