package ru.otus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.service.TaskService;
import ru.otus.service.TestService;

class CommandLineApp
{
    public static void main ( String [] arguments )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        TestService service = context.getBean(TestService.class);
        service.printAllQuestions();
    }
}
