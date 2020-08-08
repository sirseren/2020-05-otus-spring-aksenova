package ru.otus.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Book extends Object {
    private long id;
    private long genreId;
    private long author_id;
    private String name;
    private String isbn;
}
