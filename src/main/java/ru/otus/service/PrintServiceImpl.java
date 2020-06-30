package ru.otus.service;

import java.io.PrintStream;
import java.util.List;
import org.springframework.stereotype.Service;
import ru.otus.domain.Task;

@Service
public class PrintServiceImpl implements PrintService<Task> {

    @Override
    public void printAll(List<Task> list, PrintStream out) {
        list.forEach(s -> out.println(s.getQuestion() + '\n'));
    }
}
