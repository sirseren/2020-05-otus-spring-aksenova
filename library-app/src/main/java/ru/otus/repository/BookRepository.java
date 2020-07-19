package ru.otus.repository;

import java.awt.print.Book;
import java.util.Collection;
import java.util.List;

public interface BookRepository {

    List<Book> findAll();

    Book findOne(String id);

    Book save(Book person);

    int delete(String id);

    int deleteAll(Collection<String> ids);
}
