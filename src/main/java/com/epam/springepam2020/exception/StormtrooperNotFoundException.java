package com.epam.springepam2020.exception;

import java.util.function.Supplier;

public class StormtrooperNotFoundException extends RuntimeException {

    public StormtrooperNotFoundException(String message) {
        super(message);
    }

    public static Supplier<StormtrooperNotFoundException> stormtrooperNotFoundExceptionById(Integer id) {
        return () -> new StormtrooperNotFoundException("Stormtrooper not found with id: " + id);
    }
}
