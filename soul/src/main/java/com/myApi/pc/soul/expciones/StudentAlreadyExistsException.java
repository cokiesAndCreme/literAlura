package com.myApi.pc.soul.expciones;

public class StudentAlreadyExistsException extends RuntimeException{
    private Object id;
  

    public StudentAlreadyExistsException(String id ) {
        super(String.format("Usuario existente con id = '%s'",id));
        this.id = id;
        
    }
    

}
