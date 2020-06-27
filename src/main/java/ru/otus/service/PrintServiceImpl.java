package ru.otus.service;

import java.io.PrintStream;
import java.util.List;
import ru.otus.domain.Task;

public class PrintServiceImpl implements PrintService<Task> {

    @Override
    public void printAll(List<Task> list, PrintStream out) {
        list.forEach(s -> out.println(s.getQuestion() + '\n'));
    }
}
