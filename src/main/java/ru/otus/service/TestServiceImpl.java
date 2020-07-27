package ru.otus.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.dao.CsvTaskDao;
import ru.otus.domain.Task;

@Service
public class TestServiceImpl implements TestService {

    private final IOService ioService;
    private final String testData;

    public TestServiceImpl(IOService ioService, @Value("${questions.filename}") String testData) {
        this.ioService = ioService;
        this.testData = testData;
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
        CsvTaskDao csvTaskDao = new CsvTaskDao(testData);
        return csvTaskDao.getTasksFromDataSource();
    }
}
