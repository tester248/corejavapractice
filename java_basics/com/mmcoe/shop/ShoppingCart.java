package com.mmcoe.shop;
import com.mmcoe.ds.LinkedList;

public class ShoppingCart implements Shopping {
	//private Product[] items;
	private LinkedList<Product> items;
	private double total;
	//private int itemCount;
	
	public ShoppingCart() {
		//items = new Product[3];
		items = new LinkedList<Product>();
		//itemCount = 0;
	}
	
	public void addItem(String name, double price) throws CartException {
		//if (itemCount < items.length) {
		if (items.size < 5)
		{
			Product p = new Product(name, price);
			//items[itemCount] = p;
			items.add(p);
			total += p.getPrice();
			//itemCount++;
		} else {
			throw new CartException("Cart is full");
		}
	}
	
	public void checkout() throws CartException {
		System.out.println("Items in cart:");
		//for (int i = 0; i < itemCount; i++) {
		for (int i = 0; i < items.size; i++)
			//System.out.println(items[i]);
			System.out.println(items.get(i));
		System.out.println("Cart Total: " + total);
		//items = new Product[5];
		items = new LinkedList<Product>();
		total = 0;
		//itemCount = 0;
	}
}
