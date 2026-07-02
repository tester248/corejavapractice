package com.mmcoe.service;
import java.util.Scanner;

import com.mmcoe.dao.BookDao;
import com.mmcoe.dao.BookDaoJdbcImpl;
import com.mmcoe.pojo.Book;

public class TestBookService {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDao dao = new BookDaoJdbcImpl();
        BookService service = new BookServiceImpl(dao);

        while (true) {
            System.out.println("\n=== Book Management System ===");
            System.out.println("1. Save Book");
            System.out.println("2. Find Book by ISBN");
            System.out.println("3. List All Books");
            System.out.println("4. Find Books by Price Range");
            System.out.println("5. Delete Book by ISBN");
            System.out.println("6. List Books Sorted by Title");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ISBN: ");
                    int isbn = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    service.save(new Book(isbn, title, author, price));
                    System.out.println("Book saved successfully.");
                    break;

                case 2:
                    System.out.print("Enter ISBN to find: ");
                    int findIsbn = sc.nextInt();
                    sc.nextLine();
                    try {
                        Book b = service.find(findIsbn);
                        System.out.println(b);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("All Books:");
                    for (Book b : service.list()) {
                        System.out.println(b);
                    }
                    break;

                case 4:
                    System.out.print("Enter min price: ");
                    double min = sc.nextDouble();
                    System.out.print("Enter max price: ");
                    double max = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Books in price range [" + min + ", " + max + "]:");
                    for (Book b : service.findByPrice(min, max)) {
                        System.out.println(b);
                    }
                    break;

                case 5:
                    System.out.print("Enter ISBN to delete: ");
                    int deleteIsbn = sc.nextInt();
                    sc.nextLine();
                    try {
                        service.delete(deleteIsbn);
                        System.out.println("Book deleted successfully.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Books sorted by title:");
                    for (Book b : service.listOrderByTitle()) {
                        System.out.println(b);
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}