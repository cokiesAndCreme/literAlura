package com.myApi.pc.soul.expciones;

public class ExepcionesNotFoundXD extends RuntimeException{
    private String id;
    private String resurceName;
    private Object fieldvalue;

    public ExepcionesNotFoundXD(String id, String resurceName, Object fieldvalue) {
        super(String.format("%s no fue encontrado con:%s = '%s'",  resurceName, id, fieldvalue));
        this.id = id;
        this.resurceName = resurceName;
        this.fieldvalue = fieldvalue;
    }


}


// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;
// import org.springframework.web.context.request.WebRequest;

// @RestControllerAdvice
// public class GloblaExepctionHandler {
 
//     @ExceptionHandler(ExepcionesNotFoundXD.class)
//     public ResponseEntity<String> handlerExepcionesNotFoundXD(ExepcionesNotFoundXD exp, WebRequest webRequest){
//         return new ResponseEntity<>(exp.getMessage(),HttpStatus.NOT_FOUND);

//     }

//     @ExceptionHandler(StudentAlreadyExistsException.class)
//     public ResponseEntity<String> hadlerStudentAlreadyExistsException(StudentAlreadyExistsException exp, WebRequest webRequest){
//         return new ResponseEntity<>(exp.getMessage(),HttpStatus.NO_CONTENT);
//     }

// }

