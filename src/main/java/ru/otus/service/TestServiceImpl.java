package ru.otus.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.dao.CsvTaskDao;
import ru.otus.domain.Task;

@Service
public class TestServiceImpl implements TestService {

    private final IOService ioService;
    @Value("${questions.filename}")
    private String testData;

    public TestServiceImpl(IOService ioService) {
        this.ioService = ioService;
    }

    public void startTest() {
        CsvTaskDao csvTaskDao = new CsvTaskDao(testData);
        List<Task> tasks = csvTaskDao.getTasksFromDataSource();
        int score = 0;
        for (Task task : tasks){
            ioService.print("\n" + task.getQuestionWithOptions());
            String correctAnswer = task.getAnswer();
            String userAnswer = ioService.read();
            if(!correctAnswer.isBlank() && correctAnswer.equals(userAnswer))
            {
                ioService.print("Great!");
                score++;
            } else {
                ioService.print("Wrong :(");
            }
        }

        ioService.print("Score = " + score + " from " + tasks.size());
    }
}
