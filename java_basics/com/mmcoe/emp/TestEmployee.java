package com.mmcoe.emp;

import java_basics.Manager;

public class TestEmployee {

	public static void main(String[] args) {
		
		Manager m = new Manager(1500,800);		
		
		Clerk c = new Clerk(1200,400);
		
		showSalary(m);
		showSalary(c);
		
	}

	private static void showSalary(Manager m) {
		System.out.println("Manager Salary " + m.getSalary());
	}
	
	private static void showSalary(Clerk c) {
		System.out.println("Clerk Salary " + c.getSalary());
	}

}

