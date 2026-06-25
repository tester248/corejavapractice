package com.mmcoe.library;

public class TestLibrary {

    public static void main(String[] args) {

        Book b1 = new Book("The Alchemist");
        Book b2 = new Book("Kite Runner");

        Member m1 = new Member("Krishna");
        Member m2 = new Member("George");

        System.out.println("Initial Status:");
        b1.status();
        m1.status();

        //issue book to member
        System.out.println("\nIssuing Book:");
        m1.borrowBook(b1);
        m2.borrowBook(b2);

        //print status of books then members
        System.out.println("\nAfter Issue:");
        b1.status();
        b2.status();
        m1.status();
        m2.status();

        //return one book
        System.out.println("\nReturning Book:");
        m1.returnBook();

        //status after return
        System.out.println("\nAfter Return:");
        b1.status();
        b2.status();
        m1.status();
        m2.status();
        
    }
}