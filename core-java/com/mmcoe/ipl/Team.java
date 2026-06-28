package com.mmcoe.ipl;

import java.util.ArrayList;
import java.util.List;

public class Team {
	private String name;
	private double budget;
	private List<Player> squad;

	public Team(String name, double budget) {
		this.name = name;
		this.budget = budget;
		this.squad = new ArrayList<Player>();
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

	public List<Player> getSquad() {
		return squad;
	}

	public void addPlayer(Player p) {
		squad.add(p);
	}

	public boolean canBid(double amount) {
		return budget >= amount;
	}

	public void deductBudget(double amount) {
		budget -= amount;
	}
}
