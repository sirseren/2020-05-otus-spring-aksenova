package ru.otus.dao;

import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.otus.domain.Task;

class CsvTaskDaoTest {

    @Test
    void getTasksFromDataSourceTest(){
        CsvTaskDao csvTaskDao = new CsvTaskDao("questions-for-test.csv");
        List<Task> tasksFromDataSource = csvTaskDao.getTasksFromDataSource();
        Assert.assertEquals(1, tasksFromDataSource.size());
    }
}