package com.springboot.exeption;

import lombok.AllArgsConstructor;

public class BusinessLoginException extends RuntimeException{
    private ExceptionCode exceptionCode;
    public BusinessLoginException(ExceptionCode exceptionCode){
        super();
        this.exceptionCode = exceptionCode;
    }
}
