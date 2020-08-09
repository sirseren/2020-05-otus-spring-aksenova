package ru.otus.repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.entity.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public BookRepositoryImpl(JdbcTemplate jdbcTemplate,
                              NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Book> findAll(List<String> ids) {
        String SQL = "select * from BOOK where ID in (:ids)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("ids", ids);
        return namedParameterJdbcTemplate.query(SQL, parameterSource, new BeanPropertyRowMapper<>(Book.class));
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
