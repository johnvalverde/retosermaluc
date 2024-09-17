package com.sermaluc.reto.utils.controllers;


import com.sermaluc.reto.utils.exceptions.BusinessException;
import com.sermaluc.reto.utils.model.ResponseApi;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(BusinessException.class)
    public ResponseApi<?> businessError(BusinessException be) {

        ResponseApi<?> responseApi = new ResponseApi<>();
        responseApi.setStatus(500);
        responseApi.setMessage(be.getMessage());

        return responseApi;
    }

    @ExceptionHandler(Exception.class)
    public ResponseApi<?> exceptionError(Exception e) {
        return (new ResponseApi<>()).responseError(e.getMessage());
    }
}
