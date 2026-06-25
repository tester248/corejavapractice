package com.mmcoe.shop;

public interface Shopping {
	void addItem(String name, double price) throws CartException;
	void checkout() throws CartException;
}
