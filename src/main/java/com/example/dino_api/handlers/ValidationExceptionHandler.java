package com.example.dino_api.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler{
    // Caundo hagas este herencia ahi muchos metordos que puedes sobreescribir
    // para manejar las excepciones de validacion
    //En este caso sobre escribimos el metodo handleMethodArgumentNotValid
    //este metodo se llama cuando una validacion falla en un controlador
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(
                (error) -> {
                    String field = ((FieldError)error).getField();
                    String message = error.getDefaultMessage();
                    errors.put(field, message);
                }

        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
