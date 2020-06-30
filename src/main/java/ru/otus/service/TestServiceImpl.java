package ru.otus.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.otus.domain.Task;
import ru.otus.util.CsvFileReader;

@Service
public class TestServiceImpl implements TestService {

    private String ASK_NAME_MSG = "Hello, print your name";

    private final TaskServiceImpl taskService;
    private final CsvFileReader csvFileReader;
    private final Resource testData;
    private final IOService ioService;

    public TestServiceImpl(TaskServiceImpl taskService, CsvFileReader csvFileReader, IOService ioService, @Value("${questions.filename}") String testData) {
        this.taskService = taskService;
        this.csvFileReader = csvFileReader;
        this.ioService = ioService;
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

    @Override
    public void run() {
        ioService.print(ASK_NAME_MSG);
        String name = ioService.read();
        ioService.print(name + '?');
    }
}
