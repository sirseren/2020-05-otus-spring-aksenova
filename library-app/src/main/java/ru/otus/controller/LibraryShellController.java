package ru.otus.controller;

import java.util.List;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.service.BookService;
import ru.otus.service.IOService;

@ShellComponent
public class LibraryShellController {

    private String WELCOME_MESSAGE = "Welcome to the Library App!";

    private final IOService ioService;
    private final BookService bookService;

    public LibraryShellController(IOService ioService, BookService bookService) {
        this.ioService = ioService;
        this.bookService = bookService;
    }

    private void welcome(String username) {
        ioService.print(WELCOME_MESSAGE);
    }

    @ShellMethod(key = "delete-all", value = "Delete all books by IDs")
    public void deleteAll(@ShellOption(value = {"--id", "-id"}) List<String> id) {
        bookService.delete(id);
    }

}