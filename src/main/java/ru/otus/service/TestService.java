package ru.otus.service;

import java.util.List;
import java.util.stream.Collectors;
import ru.otus.domain.Task;
import ru.otus.util.CsvFileReader;

public class TestService {

    private TaskService taskService;
    private String dataFilePath;

    public TestService(TaskService taskService) {
        this.taskService = taskService;
    }

    public void setDataFilePath(String dataFilePath) {
        this.dataFilePath = dataFilePath;
    }

    public void printAllQuestions() {
        List<Task> test = createTestFromCsv();
        test.forEach(s -> System.out.println(s.getQuestion() + '\n'));
    }

    private List<Task> createTestFromCsv() {
        CsvFileReader csvFileReader = new CsvFileReader();
        List<String[]> rows = csvFileReader.readFromFile(dataFilePath);
        return rows.stream().map(x -> taskService.createTask(x)).collect(Collectors.toList());
    }

}
