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

    public String getQuestionWithOptions() {
        StringBuffer formedQuestion = new StringBuffer(question + "\n"); //stringbuffer
        int optNumber = 1;
        for (String opt : options){
            formedQuestion = formedQuestion.append(" " + optNumber++ + "." + opt + "\n");
        }
        return formedQuestion.toString();
    }
}