package com.mrdfood.demo.boot.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private final Object resource;


    public ResourceNotFoundException(Object resource) {
        super("resource not found: " + resource);
        this.resource = resource;
    }

    public Object getResource() {
        return resource;
    }
}
