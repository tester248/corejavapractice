package com.mmcoe.ipl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Auction {
    private List<Team> teams = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

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
            teams.add(new Team(name, budget));
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
            players.add(new Player(name, role, base));
        }
    }

    private void runAuction(Scanner sc) {
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
    }

    private void summary() {
        System.out.println("\n--- Auction Summary ---");
        for (Team t : teams) {
            System.out.println(t.getName() + " | Budget left: ₹" + t.getBudget() + " Cr");
            if (t.getSquad().isEmpty()) {
                System.out.println("  No players bought.");
            } else {
                for (Player p : t.getSquad()) {
                    System.out.println("  " + p.getName() + " (" + p.getRole() + ") – ₹" + p.getSoldPrice() + " Cr");
                }
            }
        }
        System.out.println("\nUnsold players:");
        for (Player p : players) {
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
