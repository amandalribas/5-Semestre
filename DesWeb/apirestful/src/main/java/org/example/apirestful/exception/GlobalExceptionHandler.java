package org.example.apirestful.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


//Nessa classe ficam as exceções genéricas do projeto
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntidadeNaoEncontradaException.class)//quando acontecer essa exceção o método será executado em qualquer lugar do projeto
    public ResponseEntity<ErrorResponse> handleEntidadeNaoEncontrada(EntidadeNaoEncontradaException e, HttpServletRequest request){
        return new ResponseEntity<>(
                new ErrorResponse (LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                request.getMethod(),
                request.getRequestURI(), //endereço dentro do servidor (/produtos)
                null,
                e.getMessage()),
                HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgument(MethodArgumentNotValidException e, HttpServletRequest request){
        Map<String, String> map = new HashMap<>();
        for (FieldError fe : e.getBindingResult().getFieldErrors()){
            map.put(fe.getField(), fe.getDefaultMessage());
        }

        return new ResponseEntity<>(
                new ErrorResponse (
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.name(),
                        request.getMethod(),
                        request.getRequestURI(), //endereço dentro do servidor (/produtos)
                        null,
                        e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
}
