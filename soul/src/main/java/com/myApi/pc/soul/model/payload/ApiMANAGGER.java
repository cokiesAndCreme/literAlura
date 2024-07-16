package com.myApi.pc.soul.model.payload;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiMANAGGER {
    private Date tiempo = new Date(1);
    private String mensage;
    private String url;

}
