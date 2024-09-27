package com.springboot.exeption;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member not found"),
    ;
    private int status;
    private String message;
}
