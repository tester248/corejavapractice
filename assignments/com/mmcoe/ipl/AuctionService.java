package com.mmcoe.ipl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuctionService {
	private List<Team> teams;
	private List<Player> players;

	public AuctionService() {
		teams = new ArrayList<Team>();
		players = new ArrayList<Player>();
	}

	public void addTeam(String name, double budget) {
		teams.add(new Team(name, budget));
	}

	public void addPlayer(String name, String role, double basePrice) {
		players.add(new Player(name, role, basePrice));
	}

	public List<Team> getTeams() {
		return teams;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void runAuction(Scanner sc) {
		System.out.println("\n--- Starting Auction ---");
		for (Player p : players) {
			System.out.println("\nPlayer: " + p.getName() + " (" + p.getRole() + ") Base: ₹" + p.getBasePrice() + " Cr");
			boolean sold = false;
			for (Team t : teams) {
				System.out.print(t.getName() + " - buy? (y/n): ");
				String ans = sc.nextLine();
				if (ans.equalsIgnoreCase("y")) {
					if (t.canBid(p.getBasePrice())) {
						t.deductBudget(p.getBasePrice());
						t.addPlayer(p);
						p.setSoldPrice(p.getBasePrice());
						p.setSoldTo(t);
						System.out.println("Sold to " + t.getName() + " for ₹" + p.getBasePrice() + " Cr");
						sold = true;
						break;
					} else {
						System.out.println("Insufficient budget.");
					}
				}
			}
			if (!sold) {
				System.out.println(p.getName() + " remained unsold.");
			}
		}
		System.out.println("\n=== Auction Over ===\n");
	}

	public String getSummary() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n--- Auction Summary ---\n");
		for (Team t : teams) {
			sb.append(t.getName()).append(" | Budget left: Rs.").append(t.getBudget()).append(" Cr\n");
			if (t.getSquad().isEmpty()) {
				sb.append("  No players bought.\n");
			} else {
				for (Player p : t.getSquad()) {
					sb.append("  ").append(p.getName()).append(" (").append(p.getRole())
						.append(") – ₹").append(p.getSoldPrice()).append(" Cr\n");
				}
			}
		}
		sb.append("\nUnsold players:\n");
		for (Player p : players) {
			if (!p.isSold()) {
				sb.append("  ").append(p.getName()).append(" (").append(p.getRole()).append(")\n");
			}
		}
		return sb.toString();
	}
}
