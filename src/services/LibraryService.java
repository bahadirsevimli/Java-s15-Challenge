package services;

import models.Author;
import models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryService {
    private List<Book> books;

    public LibraryService() {
        this.books = new ArrayList<>();
    }

    public void newBook(Scanner scanner) {

        System.out.print("Book ID: ");
        long id = Long.parseLong(scanner.nextLine());

        if(findBookById(id) == null){

            System.out.print("Author: ");
            String authorName = scanner.nextLine();
            Author author = createAuthor(authorName);

            System.out.print("Book name: ");
            String title = scanner.nextLine();

            System.out.print("price: ");
            int price = Integer.parseInt(scanner.nextLine());

            System.out.print("Edition: ");
            int edition = Integer.parseInt(scanner.nextLine());

            System.out.print("Date of purchase: ");
            String dateOfPurchase = scanner.nextLine();

            Book newBook = new Book(id, author, title, price, edition, dateOfPurchase);
            books.add(newBook);
            newBook.getAuthor().addBook(newBook);
            System.out.println("Book added successfully: " + newBook.getTitle());

            return;
        }
        System.out.println("There is already a book for the id you entered!");


    }

    public List<Book> getBooks() {
        return books;
    }

    public void deleteBook(String deleteBookName) {
        Book bookToDelete = findBookByTitle(deleteBookName);

        if (bookToDelete == null) {
            System.out.println("Book not found");
            return;
        }

        books.remove(bookToDelete);
        bookToDelete.getAuthor().getBooks().remove(bookToDelete);

        System.out.println("Book deleted successfully: " + deleteBookName);
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
        for(Book book : books){
            if(book.getAuthor().getName().equals(authorName)){
                return book.getAuthor();
            }
        }
       return new Author(authorName);
    }

    public List<Book> findBookByAuthor(String authorName) {

        for (Book book : books) {
            if(book.getAuthor().getName().equals(authorName)){
              return book.getAuthor().getBooks();
            }
        }
        return new ArrayList<>();
    }

    public void writeBooks(List<Book> books) {
        for(Book book : books){
            System.out.println(book.getTitle());
        }
    }

    public void updateBook(long bookId, Scanner scanner) {
        Book bookToUpdate = findBookById(bookId);

        if(bookToUpdate == null){
            System.out.println("No book with this ID found in the library: " + bookId);
            return;
        }
        System.out.println("Updating book: " + bookToUpdate.getTitle());

        System.out.println("New title (leave empty to keep current): ");
        String newTitle = scanner.nextLine();
        if(!newTitle.isEmpty()) {
            bookToUpdate.setTitle(newTitle);
        }

        System.out.println("New Price (leave empty to keep current): ");
        String newPrice = scanner.nextLine();
        if(!newPrice.isEmpty()) {
            bookToUpdate.setPrice(Integer.parseInt(newPrice));
        }

        System.out.println("New Edition (leave empty to keep current): ");
        String newEdition = scanner.nextLine();
        if(!newEdition.isEmpty()) {
            bookToUpdate.setEdition(Integer.parseInt(newEdition));
        }

        System.out.println("New date of purchase (leave empty to keep current): ");
        String newDate = scanner.nextLine();
        if(!newDate.isEmpty()) {
            bookToUpdate.setDateOfPurchase(newDate);
        }
        System.out.println("Book updated successfully: " + bookToUpdate.getTitle());
    }

}
