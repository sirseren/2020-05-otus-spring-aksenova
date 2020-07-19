package ru.otus.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ru.otus.domain.Task;
import ru.otus.util.CsvFileReader;

public class TestServiceImpl implements TestService {

    private final TaskServiceImpl taskService;
    private final CsvFileReader csvFileReader;
    private final Resource testData;

    public TestServiceImpl(TaskServiceImpl taskService, CsvFileReader csvFileReader, String testData) {
        this.taskService = taskService;
        this.csvFileReader = csvFileReader;
        this.testData = new ClassPathResource(testData);;
    }

    public List<Task> getTasksFromCsv() {
        if (testData.exists() && testData.isReadable()) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(testData.getInputStream()))) {
                return reader.lines()
                             .skip(1)
                             .map(x -> taskService.createTask(x))
                             .collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

}
