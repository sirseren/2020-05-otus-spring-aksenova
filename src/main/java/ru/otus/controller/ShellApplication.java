package ru.otus.controller;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.service.IOService;
import ru.otus.service.TestService;

@ShellComponent
public class ShellApplication {

    private static final String ASK_NAME_MSG = "Hello, print your name";

    private final TestService testService;
    private final IOService ioService;

    public ShellApplication(TestService testService, IOService ioService) {
        this.testService = testService;
        this.ioService = ioService;
    }

    @ShellMethod(key = "start", value = "Start test")
    public void start(@ShellOption(defaultValue = ShellOption.NULL, value = {"--username", "-u"}) String username) {
        greet(username);
        testService.startTest();
    }

    private void greet(String username) {
        if (username == null) {
            ioService.print(ASK_NAME_MSG);
            username = ioService.read();
        }
        ioService.print(username + ", welcome!");
    }
}
