import java.util.Scanner;

public class Lab2Solution {
	public static void main(String[] args) {
		final double ir = 0.0235482;
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Java Lab 2: Fixed deposit calculator");
		System.out.print("How much for the fixed deposit? ");
		double initialAmount = Double.parseDouble(keyboard.nextLine());
		
		System.out.print("What is your name? ");
		String name = keyboard.nextLine();
		
		System.out.println("Dear " + name + ",");
		
		System.out.println("In withdrawal mode:");
		System.out.printf("You can receive $%,.4f per year\n", initialAmount*ir);
		System.out.printf("The total amount on completion is $%,.2f\n", initialAmount + 5*initialAmount*ir);
		
		System.out.println("In compond mode:");
		double accAmount = initialAmount;
		System.out.printf("The interest at year %d is $%,.4f\n", 1, accAmount*ir);
		accAmount *= 1 + ir;
		System.out.printf("The interest at year %d is $%,.4f\n", 2, accAmount*ir);
		accAmount *= 1 + ir;
		System.out.printf("The interest at year %d is $%,.4f\n", 3, accAmount*ir);
		accAmount *= 1 + ir;
		System.out.printf("The interest at year %d is $%,.4f\n", 4, accAmount*ir);
		accAmount *= 1 + ir;
		System.out.printf("The interest at year %d is $%,.4f\n", 5, accAmount*ir);
		accAmount *= 1 + ir;
		System.out.printf("The total amount on completion is $%,.2f\n", accAmount);
	}
}
