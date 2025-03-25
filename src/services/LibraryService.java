package services;

import models.Author;
import models.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Book> books;

    public LibraryService() {
        this.books = new ArrayList<>();
    }

    public void addNewBook(Book book) {
        books.add(book);
        book.getAuthor().addBook(book);
        System.out.println("Book added successfully: " + book.getTitle());
    }

    public List<Book> getBooks() {
        return books;
    }

    public void deleteBook(Book book) {
        books.remove(book);
        System.out.println("Book deleted successfully: " + book.getTitle());
    }

    public Book findBookById(long bookId){
        for (Book book : books) {
            if(book.getBookId() == bookId){
                return book;
            }
        }
        return null;
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if(book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }

    public Author createAuthor(String authorName) {
       Author author = new Author(authorName);
       return author;
    }

    public Book findBookByAuthor(String authorName) {
        for (Book book : books) {
            if(book.getAuthor().getName().equals(authorName)){
              for(Book authorBook : book.getAuthor().getBooks())  {
                  System.out.println(authorBook.getTitle());
              }
            }else{
                System.out.println(authorName + " not found");
            }
        }
        return null;
    }

}
