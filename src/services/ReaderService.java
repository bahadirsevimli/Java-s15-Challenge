package services;

import models.Book;

import models.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderService {
    private List<Reader> readers = new ArrayList<>();

    public Reader findReaderByName(String name) {
        for (Reader reader : readers) {
            if(reader.getName().equals(name)){
                return reader;
            }
        }
        return null;
    }

    public void createReader(String readerName) {

        for (Reader reader : readers) {
            if (reader.getName().equals(readerName)) {
                System.out.println("Welcome " + readerName + " :)");
                return;
            }
        }
        readers.add(new Reader(readerName));
        System.out.println("Reader " + readerName + " created successfully, Welcome.");
    }



    public void addBookToReader(String readerName, Book book) {
        for (Reader reader : readers) {
            if (!reader.getBooks().contains(book)) {
                findReaderByName(readerName).getBooks().add(book);
                getBill(book);
            }else{
                System.out.println("Reader " + reader.getName() + " has already borrowed this book.");
            }
        }
    }

    public void returnBook(Scanner scanner, String readerName) {
        System.out.println("Enter Book Name: ");
        String bookName = scanner.nextLine();

        Reader reader = findReaderByName(readerName);
        if (reader == null) {
            System.out.println("Reader not found.");
            return;
        }

        Book bookToReturn = null;
        for (Book borrowedBook : reader.getBooks()) {
            if (borrowedBook.getTitle().equalsIgnoreCase(bookName)) {
                bookToReturn = borrowedBook;
                break;
            }
        }

        if (bookToReturn == null) {
            System.out.println("Book not found in your borrowed books, please check the book name.");
            return;
        }

        removeBookFromReader(readerName, bookToReturn);
    }

    public void removeBookFromReader(String readerName, Book book) {
        Reader reader = findReaderByName(readerName);

        if (reader == null) {
            System.out.println("Reader not found.");
            return;
        }

        if (!reader.getBooks().contains(book)) {
            System.out.println("You haven't borrowed this book.");
            return;
        }

        reader.getBooks().remove(book);
        System.out.println("Book '" + book.getTitle() + "' returned successfully. Thank you.");
    }

    public void getBill (Book book) {
        System.out.println(" ********** BILL ********** ");
        System.out.println("Book id: " + book.getBookId());
        System.out.println("Book name: " + book.getTitle());
        System.out.println("Author Name: " + book.getAuthor().getName());
        System.out.println("Edition: " + book.getEdition());
        System.out.println("***** Price: " + book.getPrice() + "$ *****");
        System.out.println("When you return the book, the fee will be refunded. Have a nice day.");
    }


}
