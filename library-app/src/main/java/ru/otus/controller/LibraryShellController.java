package ru.otus.controller;

import java.util.List;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.service.BookService;
import ru.otus.service.IOService;

@ShellComponent
public class LibraryShellController {

    private final IOService ioService;
    private final BookService bookService;

    public LibraryShellController(IOService ioService, BookService bookService) {
        this.ioService = ioService;
        this.bookService = bookService;
    }

    @ShellMethod(key = "delete", value = "Delete all books by IDs")
    public void deleteAll(@ShellOption(value = {"--id", "-id"}) List<String> id) {
        ioService.print("Deleting records ...");
        bookService.delete(id);
        ioService.print("Done!");
    }

}