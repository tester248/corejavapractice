package misc;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LocalDateDemo {
	
	public static void main(String[] args) {
		LocalDate d1 = LocalDate.now();
		System.out.println(d1);
		
		LocalDate d2 = LocalDate.of(2012, 02, 13);
		System.out.println(d2);
		
		LocalDate d3 = LocalDate.parse("2018-05-19");
		System.out.println(d3);
		
		System.out.println(d1.plusDays(1));
		System.out.println(d1.minus(1, ChronoUnit.MONTHS));
		System.out.println(d2.getDayOfWeek());
		System.out.println(d3.getDayOfMonth());
		System.out.println(d2.isLeapYear());
		
		// Calculate age based on dob
		LocalDate dob = LocalDate.of(2000, 6, 15);
		LocalDate today = LocalDate.now();
		int age = today.getYear() - dob.getYear();
		if (today.getDayOfYear() < dob.getDayOfYear())
			age--;
		System.out.println("Age: " + age);
		
		// Compare dates
		System.out.println("d1 before d2? " + d1.isBefore(d2));
		System.out.println("d1 after d3? " + d1.isAfter(d3));
		
		// Days between two dates
		System.out.println("Days between d2 and d3: " + ChronoUnit.DAYS.between(d2, d3));
		
		// First and last day of month
		System.out.println("First day of current month: " + d1.withDayOfMonth(1));
		System.out.println("Last day of current month: " + d1.withDayOfMonth(d1.lengthOfMonth()));
	}
}
