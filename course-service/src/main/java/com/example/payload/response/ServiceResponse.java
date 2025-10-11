package com.example.payload.response;

import java.util.List;

public class ServiceResponse <T>{

    private T data;
    private Integer statusCode;
    List<ErrorDto> erros;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public List<ErrorDto> getErros() {
        return erros;
    }

    public void setErros(List<ErrorDto> erros) {
        this.erros = erros;
    }

}
