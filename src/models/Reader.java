package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reader extends Person {
    private Map<Integer, Book> books;

    public Reader(String name) {
        super(name);
        this.books = new HashMap();
    }

    @Override
    public String whoYouAre() {
        return "I am Reader, My name is " + getName();
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }
}
