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
    public void delete(@ShellOption(value = {"--id", "-id"}) List<String> id) {
        ioService.print("Deleting records ...");
        bookService.delete(id);
        ioService.print("Done!");
    }

    //todo без опций показывает все
    @ShellMethod(key = "list", value = "List all books by IDs")
    public void list(@ShellOption(value = {"--id", "-id"}) List<String> id) {
        ioService.print("Fetching records ...");
        ioService.print(bookService.findAll(id));
        ioService.print("Done!");
    }

    //todo
    public void create(@ShellOption(value = {"--genre", "-g"}) String genre,
                       @ShellOption(value = {"--author", "-a"}) String author,
                       @ShellOption(value = {"--name", "-n"}) String name,
                       @ShellOption(value = {"--ibsn", "-i"}) String ibsn) {

    }

    //todo
    public void update(@ShellOption(value = {"--id", "-id"}) List<String> id,
                       @ShellOption(value = {"--genre", "-g"}) String genre,
                       @ShellOption(value = {"--author", "-a"}) String author,
                       @ShellOption(value = {"--name", "-n"}) String name,
                       @ShellOption(value = {"--ibsn", "-i"}) String ibsn) {

    }


}