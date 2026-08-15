package com.example.Pratica2.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalException {

    // 1. Erro de Requisição (400 - Bad Request)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> illegalArgument(IllegalArgumentException e, HttpServletRequest request) {
        String error = "Atributo Inválido";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    // 2. Recurso não encontrado (404 - Not Found)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
        String error = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    // 3. Erro Genérico de Servidor (500 - Internal Server Error)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<StandardError> runtimeError(RuntimeException e, HttpServletRequest request) {
        String error = "Erro de Processamento Interno";
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    // 4. Erro de Validação de Bean Validation (@Valid)
    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationError(org.springframework.web.bind.MethodArgumentNotValidException e, HttpServletRequest request) {
        String error = "Erro de validação";
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY; // Código 422 é ideal para erros de validação

        // Pegando a mensagem específica do campo que falhou (ex: "O email é Obrigatório!")
        String message = e.getBindingResult().getFieldError().getDefaultMessage();

        StandardError err = new StandardError(Instant.now(), status.value(), error, message, request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}