import models.Author;
import models.Book;
import models.Person;
import services.LibraryService;
import services.ReaderService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();
        ReaderService reader = new ReaderService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Library System, please select an option: ");
            System.out.println("\n1- I am Librarian\n2- I am Reader\n3- Exit");
            System.out.print("Your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();
//Librarian
            if (option == 1) {
                while (true){
                    System.out.println("\n1- Add new book\n2- List the books \n3- Delete book \n4- Update book \n5- Back to the main menu");
                    System.out.print("Your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 1) {
                        library.newBook(scanner);
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
//Reader
            }else if (option == 2) {
                while(true){
                    System.out.println("\n1- Enter your name \n2- Back to the main menu ");
                    System.out.print("Your choice: ");
                    int o = scanner.nextInt();
                    if(o == 1){
                        while (true){

                            System.out.println("Please enter your name: ");
                            scanner.nextLine();
                            String name = scanner.nextLine();
                            reader.createReader(name);

                            System.out.println("Please choose what you want to do");
                            System.out.println("\n1- Borrow a book \n2- Return the book you borrowed \n3- Show all books by author \n4- Show me the books I have borrowed \n5- Back");
                            System.out.print("Your choice: ");
                            int c = scanner.nextInt();
                            scanner.nextLine();
                            if (c == 1) {
                                while (true){
                                    System.out.println("\n1- Find book by id \n2- Find book by name \n5- Back");
                                    System.out.print("Your choice: ");
                                    int choice = scanner.nextInt();
                                    scanner.nextLine();
                                    if (choice == 1) {
                                        System.out.println("Book ID: ");
                                        long id = scanner.nextLong();
                                        scanner.nextLine();
                                        if(library.findBookById(id) == null){
                                            System.out.println("Book not found");
                                        }else {
                                            Book foundBookById = library.findBookById(id);
                                            reader.addBookToReader(name, foundBookById);
                                        }
                                    }else if(choice == 2){
                                        System.out.println("Book name: ");
                                        String bookName = scanner.nextLine();
                                        if(library.findBookByTitle(bookName) == null){
                                            System.out.println("Book not found");
                                        }else{
                                            Book foundBookByTitle = library.findBookByTitle(bookName);
                                            reader.addBookToReader(name, foundBookByTitle);
                                        }
                                    }
                                    else if (choice == 5) {
                                        break;
                                    }
                                }
                            }
                            else if (c == 2){
                                reader.returnBook(scanner, name);
                            }
                            else if (c == 3) {
                                System.out.println("Author Name: ");
                                String authorName = scanner.nextLine();
                                List<Book> foundBooks = library.findBookByAuthor(authorName);
                                if(foundBooks.isEmpty()){
                                    System.out.println("Author not found");
                                }else{
                                    library.writeBooks(foundBooks);
                                }
                            }
                            else if (c == 4) {
                                if(reader.findReaderByName(name).getBooks() == null){
                                    System.out.println("You have never borrowed a book before.");
                                }else{
                                    for(Book book : reader.findReaderByName(name).getBooks()){
                                        System.out.println(book.getTitle() + " - " + book.getAuthor().getName());
                                    }
                                }

                            }
                            else if (c == 5) {
                                break;
                            }
                        }
                    }else if (o == 2) {
                        break;
                    }

                }
//EXIT
            }
            else if (option == 3) {
                System.out.println("Exiting...");
                System.out.println("Thank you for using Library System");
                break;
            }


        }
        scanner.close();
    }
}