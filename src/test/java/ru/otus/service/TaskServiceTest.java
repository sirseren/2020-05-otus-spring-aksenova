package ru.otus.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.otus.domain.Task;

public class TaskServiceTest {

    @Test
    public void test(){
        TaskService taskService = new TaskService();
        String question = "Question?";
        String[] row = {question, "Answer", "Opt A", "Opt B", "Opt C", "Opt D"};
        Task task = taskService.createTask(row);
        Assertions.assertEquals(task.getQuestion(), question);
    }
}