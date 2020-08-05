package ru.otus.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import ru.otus.domain.Task;

@Repository
public class CsvTaskDao implements TaskDao{

    @Value("classpath:questions.csv")
    private Resource testData;

    public List<Task> getTasksFromDataSource() {
        if (testData.exists() && testData.isReadable()) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(testData.getInputStream()))) {
                return reader.lines()
                             .skip(1)
                             .map(this::createTask)
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
