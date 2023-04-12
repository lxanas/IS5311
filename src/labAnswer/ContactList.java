/**
   A suggested solution to the contact list management system.
*/

import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class ContactList {
	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);

		File db = new File("contact-list.txt");

		int action = 0;
		do {
			System.out.println("**Welcome to the contact list management system**");
			System.out.println("1. Show all contacts");
			System.out.println("2. Enquire for a contact");
			System.out.println("3. Add contact");
			System.out.println("4. Exit\n");
			
			System.out.print("Please select an action: ");
			action = Integer.parseInt(keyboard.nextLine());
			
			switch (action) {
				case 1: {
					if (db.exists()) {
						Scanner fileReader = new Scanner(db);
						while (fileReader.hasNext()) {
							System.out.println(fileReader.nextLine());
						}
						fileReader.close();
					}
					break;
				}
				case 2: {
					System.out.print("Enter a contact name: ");
					String contactName = keyboard.nextLine();
					String currentName;
					int count = 1;
					if (db.exists()) {
						Scanner fileReader = new Scanner(db);
						boolean nameFound = false;
						while (fileReader.hasNext() && !nameFound) {
							currentName = fileReader.nextLine();
							if (count++ % 2 == 1 && contactName.equals(currentName)) {
								nameFound = true;
							}
						}
						
						if (nameFound) {
							String phoneNum = fileReader.nextLine();
							System.out.println("Contact name: " + contactName + ", Phone number: " + phoneNum);
						} else {
							System.out.println("Contact doesn't exist");
						}
						fileReader.close();
					} else {
						System.out.println("Contact doesn't exist");
					}
					break;
				}
				case 3: {
					String newName, newPhoneNum;
					
					System.out.print("Enter a new contact name: ");
					newName = keyboard.nextLine();
					
					System.out.print("Enter a new phone number: ");
					newPhoneNum = keyboard.nextLine();

					FileWriter fw = new FileWriter(db, true);
					fw.write(newName + "\n" + newPhoneNum + "\n");
					fw.close();
				}
			}
			
			if (action != 4) {
				System.out.print("Go back to main menu [Y/N]? ");
				boolean invalidInput = false;
				do {
					if (invalidInput) 
						System.out.print("Invalid input, please enter Y or N: ");
					String tmp = keyboard.nextLine();
					if (tmp.equalsIgnoreCase("N")) {
						System.exit(0);
					} else if (!tmp.equalsIgnoreCase("Y")) {
						invalidInput = true;
					} else {
						invalidInput = false;
					}
				} while (invalidInput);
			}
		} while (action != 4);
	}
}