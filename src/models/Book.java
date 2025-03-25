package models;

public class Book {
    private long bookId;
    private Author author;
    private String name;
    private int price;
    private String status;
    private int edition;
    private String dateOfPurchase;

    public Book(long bookId, Author author, String name, int price, String status, int edition, String dateOfPurchase) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
    }
    public long getBookId() {
        return bookId;
    }
    public Author getAuthor() {
        return author;
    }
    public String getTitle() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public String getStatus() {
        return status;
    }
    public int getEdition() {
        return edition;
    }
    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

}
