package com.ClickSchad.technology.repository;
import com.ClickSchad.technology.models.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LojaRepository extends JpaRepository <Loja,Long> {

    @Query(value = "SELECT admin_id FROM administrador ORDER BY admin_id DESC LIMIT 1", nativeQuery = true)
    Long getLastAdminId();
}

