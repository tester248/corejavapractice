package com.mmcoe.dao;

import java.util.ArrayList;
import java.util.List;

import com.mmcoe.pojo.Book;

public class BookDaoCollectionImpl implements BookDao {
	private List<Book> books;					
	
	public BookDaoCollectionImpl() {
		books = new ArrayList<Book>();
	}
	@Override
	public boolean save(Book b) {
		books.add(b);
		return true;
	}

	@Override
	public Book find(int isbn) {
		for ( Book b : books)
		{
			if (b.getIsbn() == isbn)
				return b;
		}
		return null;
	}

	@Override
	public List<Book> list() {
		return books;
	}

	@Override
	public boolean delete(int isbn) {
		for (Book b : books)
		{
			if(b.getIsbn() == isbn)
			{
				books.remove(b);
				return true;
			}	
		}
		return false;
	}
	@Override
	public List<Book> findByPrice(double min, double max) {
		List<Book> res = new ArrayList<Book>();
		for(Book b:books)
		{
			if(b.getPrice() >= min && b.getPrice() <= max)
				res.add(b);
		}
		return res;
	}
}
