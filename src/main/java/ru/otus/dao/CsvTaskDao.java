package ru.otus.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ru.otus.domain.Task;

public class CsvTaskDao implements TaskDao{

    private final Resource testData;

    public CsvTaskDao(String testData) {this.testData = new ClassPathResource(testData);}

    public List<Task> getTasksFromDataSource() {
        if (testData.exists() && testData.isReadable()) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(testData.getInputStream()))) {
                return reader.lines()
                             .skip(1)
                             .map(x -> createTask(x))
                             .collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    public Task createTask(String row){
        return createTask(row.split(";"));
    }

    private Task createTask(String[] attributes){
        String question = attributes[0];
        String answer = attributes[1].trim();
        List<String> options = new ArrayList<>();
        for (int i = 2; i < 5; i++){
            options.add(attributes[i]);
        }
        return new Task(question, answer, options);
    }
}
