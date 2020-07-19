package ru.otus.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.otus.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {this.bookRepository = bookRepository;}

    @Override
    public void delete(List<String> id) {
        bookRepository.deleteAll(id);
    }
}
