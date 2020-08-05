package ru.otus.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.otus.dao.CsvTaskDao;
import ru.otus.domain.Task;

@Service
public class TestServiceImpl implements TestService {

    private final IOService ioService;
    private final CsvTaskDao csvTaskDao;

    public TestServiceImpl(IOService ioService, CsvTaskDao csvTaskDao) {
        this.ioService = ioService;
        this.csvTaskDao = csvTaskDao;
    }

    public void startTest() {
        List<Task> tasks = readTasksFromFile();
        int score = proceedTesting(tasks);
        ioService.print("Score = " + score + " from " + tasks.size());
    }

    private int proceedTesting(List<Task> tasks) {
        int score = 0;
        for (Task task : tasks) {
            ioService.print("\n" + task.getQuestionWithOptions());
            String correctAnswer = task.getAnswer();
            String userAnswer = ioService.read();
            if (!correctAnswer.isBlank() && correctAnswer.equals(userAnswer)) {
                ioService.print("Great!");
                score++;
            } else {
                ioService.print("Wrong :(");
            }
        }
        return score;
    }

    private List<Task> readTasksFromFile() {
        return csvTaskDao.getTasksFromDataSource();
    }
}
