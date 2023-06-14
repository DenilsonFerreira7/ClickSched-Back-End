package com.ClickSchad.technology.repository;
import com.ClickSchad.technology.models.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AdministradorRepository extends JpaRepository <Administrador, Long> {
    Optional<Administrador> findTopByOrderByAdminIdDesc();
    Administrador findByAdminLogin(String adminLogin);


}