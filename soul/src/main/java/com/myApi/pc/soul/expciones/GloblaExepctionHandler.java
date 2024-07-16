package com.myApi.pc.soul.expciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GloblaExepctionHandler {
 
    @ExceptionHandler(ExepcionesNotFoundXD.class)
    public ResponseEntity<String> handlerExepcionesNotFoundXD(ExepcionesNotFoundXD exp, WebRequest webRequest){
        return new ResponseEntity<>(exp.getMessage(),HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(StudentAlreadyExistsException.class)
    public ResponseEntity<String> hadlerStudentAlreadyExistsException(StudentAlreadyExistsException exp, WebRequest webRequest){
        return new ResponseEntity<>(exp.getMessage(),HttpStatus.NO_CONTENT);
    }

}
