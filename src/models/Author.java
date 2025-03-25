package models;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {
    private List<Book> books;



    public Author(String name) {
        super(name);
        this.books = new ArrayList<>();
    }

    @Override
    public String whoYouAre() {
        return "I am author, My name is " + getName();
    }

    public List<Book> getBooks() {
        return books;
    }
}
