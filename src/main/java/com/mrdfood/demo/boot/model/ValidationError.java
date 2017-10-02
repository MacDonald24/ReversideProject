package com.mrdfood.demo.boot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

public class ValidationError {
    @JsonProperty("Errors")
    private final ImmutableList<String> errors;
    @JsonProperty("Field")
    private final String field;

    private ValidationError(String field, String... errors) {
        this.field = checkNotNull(field);
        this.errors = ImmutableList.copyOf(errors);
    }

    public static List<ValidationError> of(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream().map(f -> new
                ValidationError(f.getField(), f.getDefaultMessage())).collect(Collectors.toList());
    }

    public String getField() {
        return field;
    }

    public ImmutableList<String> getErrors() {
        return errors;
    }
}
