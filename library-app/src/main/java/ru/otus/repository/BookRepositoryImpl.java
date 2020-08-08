package ru.otus.repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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

    public List<Book> findAll(Collection<String> ids) {

        Map namedParameters = Collections.singletonMap("idvalues", ids);
        StringBuffer recordQueryString = new StringBuffer();
        recordQueryString.append("select * from BOOK where ID in (:ids)");
        BeanPropertyRowMapper rowMapper = BeanPropertyRowMapper.newInstance(Book.class);
        namedParameterJdbcTemplate.query(recordQueryString.toString(), namedParameters, rowMapper);

        return namedParameterJdbcTemplate.query("select * from BOOK where ID in (:id)", rowMapper);
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
