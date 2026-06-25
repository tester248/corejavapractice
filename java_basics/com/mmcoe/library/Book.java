package com.mmcoe.library;

public class Book {

    private String title;
    private boolean issued;

    public Book(String title) {
        this.title = title;
        this.issued = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return issued;
    }

    public void issueBook() {
        issued = true;
    }

    public void returnBook() {
        issued = false;
    }

    public void status() {
        System.out.println("Book: " + title +
                " : Status: " + (issued ? "Issued" : "Available"));
    }
}