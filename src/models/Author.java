package models;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {
    private List<Book> books;



    public Author(String name) {
        super(name);
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }
    public void addBook(Book book) {
        this.books.add(book);
    }
}
