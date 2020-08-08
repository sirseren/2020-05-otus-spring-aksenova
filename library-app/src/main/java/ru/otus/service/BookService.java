package ru.otus.service;

import ru.otus.entity.Book;
import java.util.List;

public interface BookService {
    void delete(List<String> id);
    List<Book> findAll(List<String> id);

}
