package ru.otus.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import ru.otus.domain.Task;

class TestServiceImplTest {

    private TaskServiceImpl taskService = new TaskServiceImpl();
    private IOService ioService = new IOServiceImpl();
    private TestService testService = new TestServiceImpl(taskService, ioService, "questions.csv");

    @Test
    void getTasksFromCsv() throws IOException {
        List<Task> tasksFromCsv = testService.getTasksFromCsv();
        assertThat(tasksFromCsv).isNotNull();
        assertEquals(tasksFromCsv.size(), 5);
    }

}