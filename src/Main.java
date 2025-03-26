import models.Author;
import models.Book;
import models.Person;
import services.LibraryService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Library System, please select an option: ");
            System.out.println("\n1- I am Librarian\n2- I am Reader\n3- Exit");
            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                while (true){
                    System.out.println("\n1- Add new book\n2- List the books \n3- Delete book \n4- Update book \n5- Back to the main menu");
                    System.out.print("Your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 1) {
                        System.out.print("Book ID: ");
                        long id = Long.parseLong(scanner.nextLine());

                        System.out.print("Author: ");
                        String authorName = scanner.nextLine();
                        Author author = library.createAuthor(authorName);

                        System.out.print("Book name: ");
                        String title = scanner.nextLine();

                        System.out.print("price: ");
                        int price = Integer.parseInt(scanner.nextLine());

                        System.out.print("Edition: ");
                        int edition = Integer.parseInt(scanner.nextLine());

                        System.out.print("Date of purchase: ");
                        String dateOfPurchase = scanner.nextLine();

                        Book newBook = new Book(id, author, title, price, edition, dateOfPurchase);
                        library.addNewBook(newBook);

                    } else if (choice == 2) {
                        for (Book book : library.getBooks()) {
                            System.out.println(book.getTitle() + " - " + book.getAuthor().getName());
                        }
                    }else if (choice == 3) {
                        System.out.println("the name of the book you want to delete: ");
                        String deleteName = scanner.nextLine();
                       library.deleteBook(deleteName);
                    } else if (choice == 4) {
                        System.out.println("the ID of the book you want to update: ");
                        long id = Long.parseLong(scanner.nextLine());
                        library.updateBook(id, scanner);

                    } else if (choice == 5) {
                        break;
                    }
                }

            }else if (option == 2) {
                while (true){
                    System.out.println( "Please choose what you want to do");
                    System.out.println("\n1- Find book by id \n2- Find book by name \n3- Find book by Author \n5- Back to the main menu");
                    System.out.print("Your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) {
                        System.out.println("Book ID: ");
                        long id = Long.parseLong(scanner.nextLine());
                        if(library.findBookById(id) == null){
                            System.out.println("Book not found");
                        }else {
                           Book foundBook = library.findBookById(id);
                           System.out.println(foundBook.getTitle() + " - " + foundBook.getAuthor().getName());
                        }
                    }else if(choice == 2){
                        System.out.println("Book name: ");
                        String bookName = scanner.nextLine();
                        if(library.findBookByTitle(bookName) == null){
                            System.out.println("Book not found");
                        }else{
                            Book foundBook = library.findBookByTitle(bookName);
                            System.out.println(foundBook.getTitle() + " - " + foundBook.getAuthor().getName());
                        }
                    }else if(choice == 3){
                        System.out.println("Author Name: ");
                        String authorName = scanner.nextLine();
                        List<Book> foundBooks = library.findBookByAuthor(authorName);
                        if(foundBooks.isEmpty()){
                            System.out.println("Book not found");
                        }else{
                            library.writeBooks(foundBooks);
                        }
                    }
                    else if (choice == 5) {
                        break;
                    }
                }


            }  else if (option == 3) {
                System.out.println("Exiting...");
                System.out.println("Thank you for using Library System");
                break;
            }


        }
        scanner.close();
    }
}