package ru.otus.exception;

public class DataSourceReadingException extends Exception {
    public DataSourceReadingException(String message, Throwable cause) {
        super(message, cause);
    }
}