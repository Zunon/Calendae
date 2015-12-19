package greg.zunon.io;

import java.time.LocalDate;
import java.util.Scanner;

public class GUI {
	public static void main(String[]args) {
		try(Scanner scr = new Scanner(System.in)) {
			System.out.println("Enter the year:[999+]");
			int
				year = scr.nextInt();
			
			System.out.println("Enter the month:[1 to 12 inclusive]");
			int
				month = scr.nextInt();
			
			System.out.println("Enter the day:[1 to 31 inclusive]");
			int
				dayOfMonth = scr.nextInt();
			
			LocalDate
				input = LocalDate.of(year, month, dayOfMonth);
			
			System.out.println("That day in Zwami is: "+Zwami.toZwami(input));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
