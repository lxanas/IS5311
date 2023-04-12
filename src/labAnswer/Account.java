package labAnswer;

import week8.Credential;
import week8.Global;

import java.io.*;

public abstract class Account {
	private String username;
	private String name;
	private String gender;
	private String dateOfBirth;

	public abstract boolean login() throws IOException;
	
	public abstract void printMenu();
	
	public abstract boolean performAction(int actionNum);
	
	public int promptForAction() {
		System.out.print("\nSelect an action: ");
		return Integer.parseInt(Global.keyboard.nextLine());
	}
	
	public void printAccInfo() {
		System.out.println("username: " + username);
		System.out.println("name: " + name);
		System.out.println("gender: " + gender);
		System.out.println("dateOfBirth: " + dateOfBirth);
	}

	public Credential enterUsernamePwd() {
		System.out.print("Enter your username: ");
		String username = Global.keyboard.nextLine();
		System.out.print("Enter your password: ");
		String password = Global.keyboard.nextLine();
		return new Credential(username, password);
	}

	public void setAccInfo(String _username, String[] accInfo) {
		username = _username;
		name = accInfo[0];
		gender = accInfo[1];
		dateOfBirth = accInfo[2];
	}

	public void start() {
		printMenu();
		
		while (!performAction(promptForAction())) {
			System.out.println("Invalid action number, please try again.");
		}
	}
}
