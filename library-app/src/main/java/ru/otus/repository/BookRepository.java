package ru.otus.repository;

import ru.otus.entity.Book;
import java.util.Collection;
import java.util.List;

public interface BookRepository {

    List<Book> findAll(Collection<String> ids);

    Book findOne(String id);

    Book save(Book person);

    int delete(String id);

    int deleteAll(Collection<String> ids);
}
