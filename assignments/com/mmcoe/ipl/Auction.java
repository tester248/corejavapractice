package com.mmcoe.ipl;

import java.util.Scanner;

public class Auction {
    private static final int MAX_TEAMS = 10;
    private static final int MAX_PLAYERS = 100;
    private Team[] teams = new Team[MAX_TEAMS];
    private int teamCount = 0;
    private Player[] players = new Player[MAX_PLAYERS];
    private int playerCount = 0;

    private void addTeams(Scanner sc) {
        System.out.print("How many teams? ");
        int count = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            System.out.print("Team name: ");
            String name = sc.nextLine();
            System.out.print("Team budget (in Cr): ");
            double budget = sc.nextDouble();
            sc.nextLine();
            if (teamCount >= MAX_TEAMS) {
                System.out.println("Maximum number of teams reached.");
                break;
            }
            teams[teamCount++] = new Team(name, budget);
        }
    }

    private void addPlayers(Scanner sc) {
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
            if (playerCount >= MAX_PLAYERS) {
                System.out.println("Maximum number of players reached.");
                break;
            }
            players[playerCount++] = new Player(name, role, base);
        }
    }

    private void runAuction(Scanner sc) {
        System.out.println("\n--- Starting Auction ---");
        for (int pi = 0; pi < playerCount; pi++) {
            Player p = players[pi];
            System.out.println("\nPlayer: " + p.getName() + " (" + p.getRole() + ") Base: ₹" + p.getBasePrice() + " Cr");
            boolean sold = false;
            for (int ti = 0; ti < teamCount; ti++) {
                Team t = teams[ti];
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
    }

    private void summary() {
        System.out.println("\n--- Auction Summary ---");
        for (int ti = 0; ti < teamCount; ti++) {
            Team t = teams[ti];
            System.out.println(t.getName() + " | Budget left: ₹" + t.getBudget() + " Cr");
            if (t.getSquadCount() == 0) {
                System.out.println("  No players bought.");
            } else {
                for (int si = 0; si < t.getSquadCount(); si++) {
                    Player p = t.getPlayer(si);
                    System.out.println("  " + p.getName() + " (" + p.getRole() + ") – ₹" + p.getSoldPrice() + " Cr");
                }
            }
        }
        System.out.println("\nUnsold players:");
        for (int pi = 0; pi < playerCount; pi++) {
            Player p = players[pi];
            if (!p.isSold()) {
                System.out.println("  " + p.getName() + " (" + p.getRole() + ")");
            }
        }
    }

    public static void main(String[] args) {
        Auction auc = new Auction();
        Scanner sc = new Scanner(System.in);
        auc.addTeams(sc);
        auc.addPlayers(sc);
        auc.runAuction(sc);
        auc.summary();
        sc.close();
    }
}
