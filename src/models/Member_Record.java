package models;

import java.util.Date;

public class Member_Record extends Person {
    private long memberId;
    private String type;
    private Date dateOfMembership;
    private int booksIssued;
    private int maxBookLimit;
    private String address;
    private String phoneNumber;

    public Member_Record(String name, long memberId, String type, Date dateOfMembership, int booksIssued, int maxBookLimit, String address, String phoneNumber) {
        super(name);
        this.memberId = memberId;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.booksIssued = booksIssued;
        this.maxBookLimit = maxBookLimit;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public long getMemberId() {
        return memberId;
    }
    public String getType() {
        return type;
    }
    public Date getDateOfMembership() {
        return dateOfMembership;
    }
    public int getBooksIssued() {
        return booksIssued;
    }
    public int getMaxBookLimit() {
        return maxBookLimit;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }




    @Override
    public String whoYouAre() {
        return "I am a Member, My name is: " + getName();
    }
}
