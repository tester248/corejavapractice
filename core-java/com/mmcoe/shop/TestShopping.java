package com.mmcoe.shop;

public class TestShopping {
	public static void main(String[] args) {
		Shopping cart = CartFactory.newCart();
		
		try {
			cart.addItem("Marker", 25);
			cart.addItem("Duster", 75);
			cart.addItem("Pen", 75);
			cart.addItem("Eraser", 75);
			cart.addItem("Notebook", 75);
			cart.checkout();
		} catch (CartException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
