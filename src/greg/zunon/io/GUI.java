package greg.zunon.io;

import java.time.LocalDate;
import java.util.Scanner;

public class GUI {
	public static void main(String[]args) {
		try(Scanner scr = new Scanner(System.in)) {
			System.out.println(
				"Welcome to Greg.io, the calendar converter\n"+
				"    1 - Gregorian to Zwami conversion\n"+
				"    2 - Zwami to Gregorian conversion\n"
				);
			int
				choice = 0;
			while(choice < 1 || choice > 2) {
				System.out.println("Input your choice:");
				choice = scr.nextInt();
				if(choice >= 1 && choice <= 2) {
					break;
				}
				System.out.println("Invalid input");
			}
			switch(choice) {
			case 1:
				gregToZwami(scr);
				break;
			case 2:
				zwamiToGreg(scr);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void zwamiToGreg(Scanner scr) {
		// TODO Create method to convert from "MCDmd" to "dd.mm.yyyy"
		System.out.println("Work in Progress");
		GUI.main(null);
	}

	private static void gregToZwami(Scanner scr) {
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
	}
	
	
}
