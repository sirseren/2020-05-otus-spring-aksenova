package ru.otus.repository;

import java.awt.print.Book;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public BookRepositoryImpl(JdbcTemplate jdbcTemplate,
                              NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Book findOne(String id) {
        return null;
    }

    @Override
    public Book save(Book person) {
        return null;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public int deleteAll(Collection<String> ids) {
        return namedParameterJdbcTemplate.update("delete from BOOK where ID in (:ids)", Collections.singletonMap("ids", ids));
    }
}
