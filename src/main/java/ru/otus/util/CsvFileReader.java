package ru.otus.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import ru.otus.domain.Task;
import ru.otus.service.TaskService;

public class CsvFileReader {

    private String DELIMITER = ";";
    private TaskService taskService;

    public List<String[]> readFromFile(String path) {
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(DELIMITER);
                rows.add(columns);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return rows;
    }



}
