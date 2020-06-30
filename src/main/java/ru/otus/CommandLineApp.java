package ru.otus;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.service.TestServiceImpl;

@Slf4j
@SpringBootApplication
class CommandLineApp {
    public static void main ( String[] args){
        ApplicationContext context = SpringApplication.run(CommandLineApp.class, args);
        TestServiceImpl testService = context.getBean(TestServiceImpl.class);
        testService.run();
    }

}
