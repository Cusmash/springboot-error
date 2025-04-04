package com.cush.curso.springboot.error.springbooterror.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.cush.curso.springboot.error.springbooterror.exceptions.UserNotFoundException;
import com.cush.curso.springboot.error.springbooterror.models.Error;

@ControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<Error> divisionByZero(Exception e) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error division por cero");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception e){
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "numero invalido o incorrecto, no tiene formato de digito!");
        error.put("message", e.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }

    @ExceptionHandler({
        NullPointerException.class, 
        HttpMessageNotWritableException.class,
        UserNotFoundException.class
    })
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFoundException(Exception e){
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "el usuario o role no existen");
        error.put("message", e.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }


    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<Error> notFoundEx(NoHandlerFoundException e) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Api rest no encontrado");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }
}
