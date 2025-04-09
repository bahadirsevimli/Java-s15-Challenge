package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reader extends Person {
    private List<Book> books;

    public Reader(String name) {
        super(name);
        this.books = new ArrayList<>();
    }
    public List<Book> getBooks() {
        return books;
    }
}
