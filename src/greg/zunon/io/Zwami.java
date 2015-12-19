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
	
	public static LocalDate toGreg(String zwami) {
		int
			year = 0,
			month = 1,
			day = 1;
		String 
			zYear = zwami.substring(0, 4);
		char
			zMonth = zwami.charAt(4),
			zDay = zwami.charAt(5);
		Zwami.newYear = "";
		
		zYear.chars().forEach(c -> {
			Zwami.newYear += Integer.toString(base32ToBase10((char)c)-1);
		});
		
		year = Integer.parseInt(Zwami.newYear);
		month = base32ToBase10(zMonth);
		day = base32ToBase10(zDay);
		
		LocalDate
			output = LocalDate.of(year, month, day);
		
		return output;
	}
	
	private static char base10ToBase32(int base10) {
		char
			base32 = 0;
		
		if (base10 > 31 || base10 < 1){
			throw new IllegalArgumentException();
		} else if (base10 > 9) {
			base32 = (char) ('A' + (base10 - 10));
		} else {
			base32 = (char) ('0' + base10);
		}
		
		return base32;
	}
	
	private static int base32ToBase10(char base32) {
		int
			base10;
		
		if(!(base32 <= '9' && base32 > '0') && !(base32 <= 'V' && base32 >= 'A')) {
			throw new IllegalArgumentException();
		} else if(base32 <= 'V' && base32 >= 'A') {
			base10 = Character.valueOf(base32) - 'A' + 10;
		} else {
			base10 = Character.valueOf(base32) - '0';
		}
		
		return base10;
	}
}
