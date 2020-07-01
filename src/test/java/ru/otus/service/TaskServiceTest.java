package ru.otus.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import ru.otus.domain.Task;

//@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
public class TaskServiceTest {

    TaskServiceImpl taskService = new TaskServiceImpl();

    @Test
    public void test(){
        String question = "Question?";
        String[] row = {question, "Answer", "Opt A", "Opt B", "Opt C", "Opt D"};
        Task task = taskService.createTask(row);
        Assertions.assertEquals(task.getQuestion(), question);
    }
}