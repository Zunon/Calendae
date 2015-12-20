package gr.ae;

import java.time.LocalDate;
import java.util.Scanner;

public class CLI {
	public static void main(String[]args) {
		Scanner scr = new Scanner(System.in);
		System.out.println(
			"Welcome to Greg.io, the calendar converter\n"+
			"    1 - Gregorian to Zwami conversion\n"+
			"    2 - Zwami to Gregorian conversion\n"+
			"    3 - Exit"
			);
		int
			choice = 0;
		while(choice < 1 || choice > 3) {
			System.out.println("Input your choice:");
			choice = scr.nextInt();
			if(choice >= 1 && choice <= 3) {
				break;
			}
			System.out.println("Invalid input\n");
		}
		switch(choice) {
		case 1:
			gregToZwami(scr);
			break;
		case 2:
			zwamiToGreg(scr);
			break;
		case 3:
			scr.close();
			System.exit(0);
		}
	}

	private static void zwamiToGreg(Scanner scr) {
		System.out.println("Enter the Zwami date:[MCDYmd]");
		String zDate = scr.next("\\w+");
		System.out.println(zDate+" corresponds to "+Zwami.toGreg(zDate).toString()+"\n");
		CLI.main(null);
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
		
		System.out.println("That day in Zwami is: " + Zwami.toZwami(input)+"\n");
		CLI.main(null);
	}
	
	
}
