package com.myApi.pc.soul.model.DTO;



import lombok.Builder;
import lombok.Data;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Data
@ToString
@Builder
public class ClienteDTO implements Serializable {

    // @NotNull
    private Integer idcliente;
    // @NotEmpty
    // @Length(min = 3, max = 15)
    private String nombre;
    // @NotEmpty
    // @Length(min = 3, max = 15)
    private String apellido; 
    
    private String correo;
   
    private Date fechaRegistro;

}
