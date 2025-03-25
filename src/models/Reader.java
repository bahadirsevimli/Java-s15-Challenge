package models;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {
    private List<Book> books;

    public Reader(String name) {
        super(name);
        this.books = new ArrayList<>();
    }

    @Override
    public String whoYouAre() {
        return "I am Reader, My name is " + getName();
    }

    public List<Book> getBooks() {
        return books;
    }
}
