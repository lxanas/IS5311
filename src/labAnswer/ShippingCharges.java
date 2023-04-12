/**
   This program demonstrates a solution to the
   Shipping Charges programming challenge.
*/

import java.util.Scanner;

public class ShippingCharges {
	public static void main(String[] args) {
		final double DISCOUNT_1 = 0.8, DISCOUNT_2 = 0.9;
		final double PACKAGE_1_CHARGE = 4.80, PACKAGE_2_CHARGE = 3.70, PACKAGE_3_CHARGE = 2.20, PACKAGE_4_CHARGE = 1.10;
		
		double  weight,    // Weight
				distance,  // Distance to ship
				rate,      // Rate per 500 miles
				charges;   // The shipping charges
		int numChunks; // Number of 500 mile chunks

		Scanner keyboard = new Scanner(System.in);
		// Get the weight.
		System.out.print("Enter the weight, in pounds: ");
		weight = Double.parseDouble(keyboard.nextLine());

		// Get the distance.
		System.out.print("Enter the distance, in miles: ");
		distance = Double.parseDouble(keyboard.nextLine());
		
		if (distance < 500) {
			System.out.println("Our company does not provide shipping service for less than 500 miles");
			System.exit(0);
		}
		
		int year, month;
		System.out.print("Enter the year of the shipping order: ");
		year = Integer.parseInt(keyboard.nextLine());
		
		// Verify range of year
		if (year < 1000 || year > 3000) {
			System.out.println("Invalid year");
			System.exit(0);
		}
		
		System.out.print("Enter the month of the shipping order: ");
		month = Integer.parseInt(keyboard.nextLine());
		
		// Verify range of month
		if (month < 1 || month > 12) {
			System.out.println("Invalid month");
			System.exit(0);
		}
		
		// isLeap indicates whether it is leap year
		boolean isLeap = (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
		// isDiscountPeriod indicates whether it is Feb of leap year
		boolean isDiscountPeriod = isLeap && month == 2;
		
		// Get the number of 500 mile chunks.
		numChunks = (int)(distance / 500);
      
		// Get the shipping rate.
		if (weight > 10 && !isDiscountPeriod)
			rate = PACKAGE_1_CHARGE;
		else if (weight > 10 && isDiscountPeriod)
			rate = PACKAGE_1_CHARGE*DISCOUNT_1;
		else if (weight > 6 && !isDiscountPeriod)
			rate = PACKAGE_2_CHARGE;
		else if (weight > 6 && isDiscountPeriod)
			rate = PACKAGE_2_CHARGE*DISCOUNT_2;
		else if (weight > 2)
			rate = PACKAGE_3_CHARGE;
		else
			rate = PACKAGE_4_CHARGE;
      
		// Calculate the charges.
		charges = rate * numChunks;
			
		// Format and display the charges.
		System.out.printf("The shipping charges are $%,.2f\n", charges);
	}
}
