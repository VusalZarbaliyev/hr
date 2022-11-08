package com.avinty.hr.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {
    private Object data;
    private String error;


    public static ResponseDTO data(Object data){
        return new ResponseDTO(data,null);
    }

    public static ResponseDTO error(String error){
        return new ResponseDTO(null,error);
    }
}
