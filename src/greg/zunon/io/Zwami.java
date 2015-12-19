package greg.zunon.io;

import java.time.LocalDate;

public class Zwami {
	private static String newYear = "";
	public static String toZwami(LocalDate date) {
		int
			month = date.getMonth().getValue(),
			day = date.getDayOfMonth();
		char
			newMonth = base10ToBase32(month),
			newDay = base10ToBase32(day);
		String
			year =Integer.toString(date.getYear());
		
		Zwami.newYear = "";
		
		year.chars().forEach(c -> {
			Zwami.newYear += Character.toString((char)base10ToBase32(Character.getNumericValue(c)+1));
		});
		
		return Zwami.newYear+newMonth+newDay;
	}
	private static char base10ToBase32(int base10) {
		char
			output = 0;
		
		if (base10 > 31 || base10 < 1){
			throw new IllegalArgumentException();
		} else if (base10 > 9) {
			output = (char) ('A' + (base10 - 10));
		} else {
			output = (char) ('0' + base10);
		}
		
		return output;
	}
}
