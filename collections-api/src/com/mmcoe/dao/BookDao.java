package com.mmcoe.dao;
import com.mmcoe.pojo.Book;
import java.util.List;
	
public interface BookDao {
	boolean save(Book b);
	
	Book find(int isbn);
	
	List<Book> list();
	
	boolean delete(int isbn);
	
	List<Book> findMyPrice(double min, double max);
}
