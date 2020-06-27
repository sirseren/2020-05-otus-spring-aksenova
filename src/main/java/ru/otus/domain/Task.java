package ru.otus.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private String question;
    private String answer;
    private List<String> options;
}
