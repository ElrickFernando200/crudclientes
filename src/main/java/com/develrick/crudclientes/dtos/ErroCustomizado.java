package com.develrick.crudclientes.dtos;

import java.time.Instant;

public class ErroCustomizado {

    private Instant timeStamp;
    private Integer status;
    private String error;
    private String path;


    public ErroCustomizado(Instant timeStamp, Integer status, String error, String path){
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimeStamp(){
        return timeStamp;
    }


    public Integer getStatus(){
        return status;
    }

    public String getError(){
        return error;
    }

    public String getPath(){
        return path;
    }

}
