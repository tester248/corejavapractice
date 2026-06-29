package com.mmcoe.ipl;

public class Bid {
	private Team team;
	private Player player;
	private double amount;

	public Bid(Team team, Player player, double amount) {
		this.team = team;
		this.player = player;
		this.amount = amount;
	}

	public Team getTeam() {
		return team;
	}

	public Player getPlayer() {
		return player;
	}

	public double getAmount() {
		return amount;
	}
}
