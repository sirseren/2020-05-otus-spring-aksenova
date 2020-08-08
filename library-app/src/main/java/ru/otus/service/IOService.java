package ru.otus.service;

import java.util.List;
import ru.otus.entity.Book;

public interface IOService {

    String read();
    void print(String text);
    void print(List<Book> objects);
}