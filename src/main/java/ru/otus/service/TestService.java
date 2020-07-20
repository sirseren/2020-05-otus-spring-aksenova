package ru.otus.service;

import java.util.List;
import ru.otus.domain.Task;
import ru.otus.exception.DataSourceReadingException;

public interface TestService {

    List<Task> getTasksFromDataSource() throws DataSourceReadingException;
    void startTest();
}
