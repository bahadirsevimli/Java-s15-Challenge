package models;

public class Librarian extends Person {

    private String password;

    public Librarian(String name, String password) {
        super(name);
        this.password = password;
    }

    @Override
    public String whoYouAre() {
        return "I am Librarian, My name is: " + getName();
    }

    public String getPassword() {
        return password;
    }
}
