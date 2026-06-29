package com.mmcoe.ipl;

public class Player {
	private String name;
	private String role;
	private double basePrice;
	private double soldPrice;
	private Team soldTo;

	public Player(String name, String role, double basePrice) {
		this.name = name;
		this.role = role;
		this.basePrice = basePrice;
		this.soldPrice = 0;
		this.soldTo = null;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public double getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}

	public Team getSoldTo() {
		return soldTo;
	}

	public void setSoldTo(Team soldTo) {
		this.soldTo = soldTo;
	}

	public boolean isSold() {
		return soldTo != null;
	}
}
