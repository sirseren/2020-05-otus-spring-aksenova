package ru.otus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.service.PrintServiceImpl;
import ru.otus.service.TestServiceImpl;

class CommandLineApp
{
    public static void main ( String []arguments) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        TestServiceImpl testService = context.getBean(TestServiceImpl.class);
        PrintServiceImpl printService = context.getBean(PrintServiceImpl.class);
        printService.printAll(testService.getTasksFromCsv(), System.out);
    }
}
