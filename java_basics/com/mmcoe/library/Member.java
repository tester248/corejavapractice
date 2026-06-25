package com.mmcoe.library;

public class Member {

    private String name;
    private Book borrowedBook;

    public Member(String name) {
        this.name = name;
    }

    public void borrowBook(Book book) {
        if (!book.isIssued()) {
            borrowedBook = book;
            book.issueBook();
            System.out.println(name + " borrowed " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is already issued.");
        }
    }

    public void returnBook() {
        if (borrowedBook != null) {
            System.out.println(name + " returned " + borrowedBook.getTitle());
            borrowedBook.returnBook();
            borrowedBook = null;
        }
    }

    public void status() {
        System.out.println("Member: " + name +
                " : Borrowed Book: " + (borrowedBook != null ? borrowedBook.getTitle() : "None"));
    }
}
