package com.mrdfood.demo.boot.util;

public class SystemException extends RuntimeException {

    private int code;

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getCode() { return code; }

    public void setCode(int code) { this.code = code; }
}
