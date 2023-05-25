package com.ClickSchad.technology.repository;
import com.ClickSchad.technology.models.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface FuncionariosRepository extends JpaRepository <Funcionarios,Long > {
   List<Funcionarios> findByLojaLojaId(Long lojaId);



}
