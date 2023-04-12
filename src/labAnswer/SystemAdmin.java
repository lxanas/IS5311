//package labAnswer;
//
//import week8.Credential;
//
//public class SystemAdmin extends Account {
//	@Override
//	public boolean login() {
//		Credential acc = enterUsernamePwd();
//		if (acc.check(new Credential("admin", "java"))) {
//			String[] info = {
//				"Chris Wong", "Male", "04/05/2022"
//			};
//			setAccInfo("admin", info);
//			return true;
//		} else
//			return false;
//	}
//
//	@Override
//	public void printMenu() {
//		System.out.println("\nWelcome to the admin system.");
//		System.out.println("1. Admin action one.");
//		System.out.println("2. Print account info.");
//	}
//
//	public boolean performAction(int actionNum) {
//		boolean actionPerformed = false;
//		switch (actionNum) {
//			case 1:
//				System.out.println("Perform admin action one.");
//				actionPerformed = true;
//				break;
//			case 2:
//				printAccInfo();
//				actionPerformed = true;
//		}
//		return actionPerformed;
//	}
//
//	@Override
//	public void printAccInfo() {
//		System.out.println("This is System Admin account");
//		super.printAccInfo();
//	}
//}