package com.mmcoe.stock;

public class Stock implements Holder, Broker, Exchange {
	private String ticker;
	private double price;
	private int availableShares;

	public Stock() {
	}

	public void viewQuote() {
		System.out.println("View Quote");
	}

	public void getQuote() {
		System.out.println("Get Quote");
	}

	public void setQuote() {
		System.out.println("Set Quote");
	}

	public String getTicker() {
		return ticker;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return ticker + " - $" + price + " [" + availableShares + " shares]";
	}
}
