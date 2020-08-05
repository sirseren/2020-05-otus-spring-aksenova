package ru.otus.dao;

import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import ru.otus.config.TestConfig;
import ru.otus.domain.Task;

@ContextConfiguration(classes = TestConfig.class)
@SpringBootTest
class CsvTaskDaoTest {

    @Autowired
    private CsvTaskDao csvTaskDao;

    @Test
    void getTasksFromDataSourceTest(){
        List<Task> tasksFromDataSource = csvTaskDao.getTasksFromDataSource();
        Assert.assertEquals(1, tasksFromDataSource.size());
    }
}