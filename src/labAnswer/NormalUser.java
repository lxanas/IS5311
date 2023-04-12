//package labAnswer;
//
//import week8.Credential;
//
//import java.util.Scanner;
//import java.io.File;
//import java.io.IOException;
//
//public class NormalUser extends Account {
//
//	private String regDate;
//
//	@Override
//	public boolean login() throws IOException {
//		Credential acc = enterUsernamePwd();
//		String accInfoLine = getMatchedAccInfo(acc);
//		if (accInfoLine == null)
//			return false;
//		setAccInfo(acc.getUsername(), accInfoLine);
//		return true;
//	}
//
//	public String getMatchedAccInfo(Credential acc) throws IOException {
//		File accFile = new File("accounts.txt");
//		Scanner fileReader = new Scanner(accFile);
//		boolean accMatch = false;
//		String accInfoLine = null;
//		while (fileReader.hasNext() && !accMatch) {
//			String username = fileReader.nextLine();
//			String password = fileReader.nextLine();
//			accInfoLine = fileReader.nextLine();
//
//			if (acc.check(new Credential(username, password))) {
//				accMatch = true;
//			}
//		}
//		if (accMatch)
//			return accInfoLine;
//		return null;
//	}
//
//	@Override
//	public void printMenu() {
//		System.out.println("\nWelcome to our service.");
//		System.out.println("1. User action one.");
//		System.out.println("2. Print account info.");
//	}
//
//	public boolean performAction(int actionNum) {
//		boolean actionPerformed = false;
//		switch (actionNum) {
//			case 1:
//				System.out.println("Perform user action one.");
//				actionPerformed = true;
//				break;
//			case 2:
//				printAccInfo();
//				actionPerformed = true;
//		}
//		return actionPerformed;
//	}
//
//	public void setAccInfo(String username, String accInfoLine) {
//		String[] accInfo = accInfoLine.split(",");
//		setAccInfo(username, accInfo);
//		regDate = accInfo[3];
//	}
//
//	@Override
//	public void printAccInfo() {
//		System.out.println("This is normal user account.");
//		super.printAccInfo();
//		System.out.println("Register date: " + regDate);
//	}
//}
