package ru.otus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.dao.CsvTaskDao;

@Configuration
public class TestConfig {

    @Bean
    public CsvTaskDao csvTaskDao(){
        return new CsvTaskDao();
    }
}
