package ru.otus.dao;

import java.util.List;
import ru.otus.domain.Task;

public interface TaskDao {
    public List<Task> getTasksFromDataSource();


}
