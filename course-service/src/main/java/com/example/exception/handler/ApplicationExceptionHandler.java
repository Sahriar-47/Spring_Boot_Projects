package com.example.exception.handler;

import com.example.exception.BackendException;
import com.example.exception.ClientException;
import com.example.payload.response.ErrorDto;
import com.example.payload.response.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ServiceResponse<?> handlerException(MethodArgumentNotValidException exception) {
        ServiceResponse<?> serviceResponse = new ServiceResponse<>();
        List<ErrorDto> erros = new ArrayList<>();
        exception.getBindingResult().getAllErrors().forEach(
                error -> {

                    ErrorDto errorDto = new ErrorDto();
                    errorDto.setMessage(error.getDefaultMessage());
                    erros.add(errorDto);
                }
        );
        serviceResponse.setErros(erros);
        serviceResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return serviceResponse;
    }

    @ExceptionHandler(BackendException.class)
    public ServiceResponse<?> handlerException(BackendException exception) {
        ServiceResponse<?> serviceResponse = new ServiceResponse<>();
        List<ErrorDto> erros = new ArrayList<>();
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(exception.getMessage());
        erros.add(errorDto);
        serviceResponse.setErros(erros);
        serviceResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return serviceResponse;
    }

    @ExceptionHandler(ClientException.class)
    public ServiceResponse<?> handlerException(ClientException exception) {
        ServiceResponse<?> serviceResponse = new ServiceResponse<>();
        List<ErrorDto> erros = new ArrayList<>();
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(exception.getMessage());
        erros.add(errorDto);
        serviceResponse.setErros(erros);
        serviceResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return serviceResponse;
    }

    @ExceptionHandler(Exception.class)
    public ServiceResponse<?> handlerException(Exception exception) {
        ServiceResponse<?> serviceResponse = new ServiceResponse<>();
        List<ErrorDto> erros = new ArrayList<>();
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(exception.getMessage());
        erros.add(errorDto);
        serviceResponse.setErros(erros);
        serviceResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return serviceResponse;
    }

}
