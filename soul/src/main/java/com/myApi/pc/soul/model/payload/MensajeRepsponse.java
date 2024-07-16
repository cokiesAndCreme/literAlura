package com.myApi.pc.soul.model.payload;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data 
@ToString
@Builder
public class MensajeRepsponse implements Serializable{
    private String mensaje;
    private Object objeto;

}
