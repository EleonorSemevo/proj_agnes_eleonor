package com.corebank.corebank.exceptions;

public class CustomEntityNotFoundException extends RuntimeException {
    public CustomEntityNotFoundException(String entity) {
        super(entity + " not found");
    }
}
