package ru.otus.service;

import java.io.PrintStream;
import java.util.Scanner;
import org.springframework.stereotype.Service;

@Service
public class IOServiceImpl implements IOService{

    private final PrintStream out;
    private final Scanner scanner;

    public IOServiceImpl() {
        this.out = new PrintStream(System.out);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public void print(String text) {
        out.println(text);
    }
}
