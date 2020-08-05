package ru.otus.service;

import ru.otus.exception.DataSourceReadingException;

public interface TestService {

    void startTest() throws DataSourceReadingException;
}
