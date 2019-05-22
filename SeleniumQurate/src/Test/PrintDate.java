package Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrintDate {

	public static void main(String[] args) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		LocalDateTime now = LocalDateTime.now();
		String systemdt = dtf.format(now);
		System.out.println(systemdt);

	}

}
