package models;

public class Book {
    private long bookId;
    private Author author;
    private String name;
    private int price;
    private int edition;
    private String dateOfPurchase;

    public Book(long bookId, Author author, String name, int price, int edition, String dateOfPurchase) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.price = price;

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
    public int getEdition() {
        return edition;
    }
    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public void setTitle(String title) {
        this.name = title;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setEdition(int edition) {
        this.edition = edition;
    }
    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }


}
