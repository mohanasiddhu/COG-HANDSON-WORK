package com.library.repository;
import java.util.*;
public class BookRepository {
    public List<String> findAllBooks() {
        return Arrays.asList("Clean Code", "Effective Java", "Spring in Action");
    }
    public String findBookById(int id) { return "Book #" + id + ": Spring Boot Reference"; }
}
