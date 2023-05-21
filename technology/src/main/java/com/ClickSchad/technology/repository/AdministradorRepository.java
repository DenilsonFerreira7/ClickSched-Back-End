package com.ClickSchad.technology.repository;
import com.ClickSchad.technology.models.Administrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AdministradorRepository extends CrudRepository<Administrador, Long> {
    Optional<Administrador> findTopByOrderByAdminIdDesc();

}
