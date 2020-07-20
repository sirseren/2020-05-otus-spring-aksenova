package ru.otus.exception;

import java.io.IOException;

public class DataSourceReadingException extends IOException {
    public DataSourceReadingException(String message) {
        super(message);
    }
}
