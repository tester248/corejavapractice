package com.mmcoe.service;

import com.mmcoe.dao.BookDaoCollectionImpl;
import com.mmcoe.pojo.Book;
import com.mmcoe.service.BookService;
import com.mmcoe.service.BookServiceImpl;
import com.mmcoe.dao.*;
public class TestBookService {
	public static void main(String[] args) {
		
		BookDao dao=new BookDaoCollectionImpl();
		BookService service=new BookServiceImpl(dao);
		
		service.save(new Book(1,"The Alchemist","Paulo Coelho",250));
		service.save(new Book(2,"xyz","abc",350));
		service.save(new Book(3,"C programming","abcd",500));
		
		for(Book b:service.list())
			System.out.println(b);
		
		try {
			System.out.println(service.find(3));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		for(Book b:service.findByPrice(200, 300))
			System.out.println(b);
		
		try {
			service.delete(15);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		service.listOrderByTitle().forEach(System.out::println);
	}
}