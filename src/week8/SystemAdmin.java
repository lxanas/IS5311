package week8;/*
	The class for Admin account which is subclass of Account.
*/

public class SystemAdmin extends Account
{
	/*****************************
	 * ToDo 6:
	 * Add your code in the space below to override the performAction
	 * method. This method checks the given action number (integer)
	 * argument. 
	 * If the action number is 1, then print a line 
	 * "Perform admin action one.". 
	 * If the action number is 2, then call the printAccInfo method for 
	 * printing the account info.
	 * We assume the user input is an integer, but the user input may not 
	 * be 1 or 2. This method returns true if the user input is 1 or 2. 
	 * Otherwise, return false.
	 ****************************/



	/*****************************
	 * ToDo 9:
	 * Add your code in the space below to override the login 
	 * method. The method asks the user to 
	 * enter the username and passowrd (call enterUsernamePwd method), 
	 * then perform login authetication.
	 * There is only one admin account with 
	 * username admin and password java.
	 * Create a credential object with this username and password, 
	 * compare it with the credential object from the user input.
	 * If login sucess, set the account info (call setAccInfo method) 
	 * and return true. Otherwise, return false.
	*****************************/





	// Prints the menu for admin account.
	@Override
	public void printMenu() {
		System.out.println("\nWelcome to the admin system.");
		System.out.println("1. Admin action one.");
		System.out.println("2. Print account info.");
	}

	// A method that overrides the printAccInfo and prints that 
	// this is an admin account, no need to print any info.
	@Override
	public void printAccInfo() {
		System.out.println("This is system admin account");
		super.printAccInfo();
	}
}