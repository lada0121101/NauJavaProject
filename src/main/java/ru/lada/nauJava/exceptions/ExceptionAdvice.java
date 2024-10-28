package ru.lada.nauJava.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.Exception;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ru.lada.nauJava.exceptions.Exception exception (Exception e){
        return ru.lada.nauJava.exceptions.Exception.create(e);
    }
}
