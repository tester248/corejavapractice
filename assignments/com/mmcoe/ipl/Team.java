package com.mmcoe.ipl;

public class Team {
	private static final int MAX_SQUAD = 15;
	private String name;
	private double budget;
	private Player[] squad;
	private int squadCount;

	public Team(String name, double budget) {
		this.name = name;
		this.budget = budget;
		this.squad = new Player[MAX_SQUAD];
		this.squadCount = 0;
	}

	public String getName() {
		return name;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int getSquadCount() {
		return squadCount;
	}

	public Player getPlayer(int index) {
		return squad[index];
	}

	public void addPlayer(Player p) {
		if (squadCount < MAX_SQUAD)
			squad[squadCount++] = p;
	}

	public boolean canBid(double amount) {
		return budget >= amount;
	}

	public void deductBudget(double amount) {
		budget -= amount;
	}
}
