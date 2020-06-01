package ru.otus.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    String question;
    String answer;
    List<String> options;
}
