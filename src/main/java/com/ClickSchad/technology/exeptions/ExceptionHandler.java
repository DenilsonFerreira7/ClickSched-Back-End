package com.ClickSchad.technology.exeptions;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import java.time.Instant;

@ControllerAdvice
public class ExceptionHandler {

@org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)


    public ResponseEntity<StandardError> entityNotFound (NotFoundExeption e, HttpServletRequest request) {
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Nao foi encontrado");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }
    @org.springframework.web.bind.annotation.ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String errorMessage = "Ocorreu um erro de integridade de dados. Verifique se os dados existem ou estão duplicados.";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

}