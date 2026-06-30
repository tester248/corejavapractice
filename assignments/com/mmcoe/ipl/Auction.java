package com.mmcoe.ipl;

import java.util.Scanner;

public class Auction {
	private AuctionService service;
	private Scanner sc;

	public Auction() {
		service = new AuctionService();
		sc = new Scanner(System.in);
	}

	private void addTeams() {
		System.out.print("How many teams? ");
		int count = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < count; i++) {
			System.out.print("Team name: ");
			String name = sc.nextLine();
			System.out.print("Team budget (in Cr): ");
			double budget = sc.nextDouble();
			sc.nextLine();
			service.addTeam(name, budget);
			System.out.println(name + " added.\n");
		}
	}

	private void addPlayers() {
		System.out.print("How many players? ");
		int count = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < count; i++) {
			System.out.print("Player name: ");
			String name = sc.nextLine();
			System.out.print("Role (BAT/BOWL/AR/WK): ");
			String role = sc.nextLine();
			System.out.print("Base price (in Cr): ");
			double base = sc.nextDouble();
			sc.nextLine();
			service.addPlayer(name, role, base);
			System.out.println(name + " added.\n");
		}
	}

	private void showMenu() {
		int choice;
		do {
			System.out.println("=== IPL Auction System ===");
			System.out.println("1. Add Teams");
			System.out.println("2. Add Players");
			System.out.println("3. Start Auction");
			System.out.println("4. Show Summary");
			System.out.println("5. Exit");
			System.out.print("Choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			System.out.println();
			switch (choice) {
				case 1 -> addTeams();
				case 2 -> addPlayers();
				case 3 -> service.runAuction(sc);
				case 4 -> System.out.println(service.getSummary());
				case 5 -> System.out.println("Goodbye!");
				default -> System.out.println("Invalid choice.\n");
			}
		} while (choice != 5);
	}

	public void close() {
		sc.close();
	}

	public static void main(String[] args) {
		Auction auction = new Auction();
		auction.showMenu();
		auction.close();
	}
}
