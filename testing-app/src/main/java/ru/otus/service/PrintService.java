package ru.otus.service;

import java.io.PrintStream;
import java.util.List;

public interface PrintService<T> {

   void printAll(List<T> list, PrintStream out);
}
