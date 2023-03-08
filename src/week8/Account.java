package week8;// An abstract class Account
// This is abstract because we 
// have no idea how to print the
// menu and perform login authetication
// before knowing which type of account is.

import java.io.*;

public abstract class Account
{
    private String username;
    private String name;
    private String gender;
    private String dateOfBirth;

    // An abstract method for printing the menu according
    // to the user account type.
    public abstract void printMenu();

    /*****************************
     * ToDo 3:
     * Add your code here to define an abstract method
     * named performAction which takes an int parameter and
     * returns a boolean.
     *****************************/


    /*****************************
     * ToDo 8:
     * Add your code here to define an abstract method
     * named login which returns a boolean.
     *****************************/


    // A method that asks the user to input an action number,
    // and then return it as integer.
    // This method assumes the user input are integers.
    public int promptForAction()
    {
        /*****************************
         * ToDo 1:
         * Add your code here so that this method prompts
         * the user to input an action (integer),
         * wait for the user to input the action number
         * and return it.
         * --REMOVE THE return 1; BELOW WHEN YOU WORK ON THIS METHOD--
         ****************************/

        return 1;
    }

    // A method that asks the user input the username and password
    // return them as a String array with first element is username and
    // the second element is the password.
    public Credential enterUsernamePwd()
    {
        /*****************************
         * ToDo 2:
         * Add your code here that prompts the user to
         * input username and password.
         * Wait for the user input and then
         * return Credential object that keeps
         * the user inputs.
         * --REMOVE THE return null; BELOW WHEN YOU IMPLEMENT THIS METHOD--
         *****************************/


        return null;
    }


    /*****************************
     * ToDo 11:
     * Add your code here to implement the method named start which
     * is called from the LoginExercise class.
     *
     * This method first prints the menu for the account (call printMenu method).
     * Then asks the user to input an action number (call promptForAction method).
     * After that, perform the corresponding action (call performAction method).
     *
     * You can assume the user input is an integer (but may not be 1 or 2).
     * If performAction method returns false, it means the user input is not 1 and 2,
     * and thus no action is performed. In this case prompt the user
     * "Invalid action number, please try again." and ask the user input again.
     * Repeat this until an action is performed (performAction returns true).
     ****************************/


    // A method that prints the basic info of the user account.
    public void printAccInfo()
    {
        System.out.println("username: " + username);
        System.out.println("name: " + name);
        System.out.println("gender: " + gender);
        System.out.println("dateOfBirth: " + dateOfBirth);
    }

    public void setAccInfo(String _username, String[] accInfo)
    {
        username = _username;
        name = accInfo[0];
        gender = accInfo[1];
        dateOfBirth = accInfo[2];
    }
}
