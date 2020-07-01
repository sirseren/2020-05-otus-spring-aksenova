package ru.otus.service;

import java.io.IOException;
import java.util.List;
import ru.otus.domain.Task;

public interface TestService {

    List<Task> getTasksFromCsv() throws IOException;
    void startTest();
}
