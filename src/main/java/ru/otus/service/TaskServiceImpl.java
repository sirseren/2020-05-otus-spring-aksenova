package ru.otus.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import ru.otus.domain.Task;

@Service
public class TaskServiceImpl implements TaskService {

    public Task createTask(String row){
        return createTask(row.split(";"));
    }

    public Task createTask(String[] attributes){
        String question = attributes[0];
        String answer = attributes[1].trim();
        List<String> options = new ArrayList<>();
        for (int i = 2; i < 5; i++){
            options.add(attributes[i]);
        }
        return new Task(question, answer, options);

    }
}
