package week8;

/**
	This is an exercise to practice on 
	inheritance. Three classes are build, 
	Account, NormalUser and Admin.
	Both NormalUserAcc and AdminAcc are 
	subclasses of Account.
*/

public class LoginExercise {
	public static void main(String[] args) throws Exception {
		// A reference variable account that is polymorphic.
		Account account = null;
		
		// Ask the user to select login as 
		// Normal User or SYstem Admin
		System.out.println("1. Login as Normal User");
		System.out.println("2. Login as System Admin");
		System.out.print("\nSelect an option: ");
		int loginOpt = Integer.parseInt(Global.keyboard.nextLine());
		
		// If the user selected to login as Normal User,
		// then account references a NormalUser object.
		// If the user selected to login as System Admin,
		// then account references a SystemAdmin object.
		// The reference variable account is polymorphic.
		switch (loginOpt) {
			case 1:
				account = new NormalUser();
				break;
			case 2:
				account = new SystemAdmin();
				break;
		}
		
		// Repeat ask the user login until the 
		// user login success.
//		while (!account.login()) {
//			System.out.println("Invalid username or password. Please try again.");
//		}
//
//		// Let the logged in account to start the use of the system.
//		account.start();

	}
}
