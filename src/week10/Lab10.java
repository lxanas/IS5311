package week10;

import java.util.*;
import java.io.*;

public class Lab10
{
    private static Scanner keyboard = new Scanner(System.in);

    public static File getFileDescriptor()
    {
        System.out.print("Enter the file name: ");
        String userInput = keyboard.nextLine();
        File file = new File(userInput);
        return file;
    }

    public static int getNumLines() throws NumberFormatException
    {
        System.out.print("Enter the number of lines to be read: ");
        String userInput = keyboard.nextLine();
        int userInputInt = Integer.parseInt(userInput);
        return userInputInt;
    }

    public static ArrayList<String> readFile(File file, int linesToRead) throws FileNotFoundException, NoSuchElementException
    {
        ArrayList<String> lines = new ArrayList<String>();
        Scanner fileReader = new Scanner(file);
        for (int i = 0; i < linesToRead; i++)
        {
            String line = fileReader.nextLine();
            lines.add(line);
        }
        return lines;
    }

    public static void printList(ArrayList<String> list)
    {
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }

    public static void main(String[] args)
    {

        try
        {
			/*
			TODO 1:
			Add ONE try-catch statement so that
			1) The try block contains ALL given code inside the main method, including the statement "return ;".
			2) the program prints "File not found" if the
			   user input file doesn't exist
			3) the program prints "No more lines to read" if
			   the user input of the number of lines to be read
			   is greater than the number of lines in the file
			4) the program prints "Number of lines should be an
			   integer" if the user input for number of lines to
			   be read is not an integer.
			5) The program always prints "Exit try-catch block"
			   if the try-catch statement is reached.

		*/

            File file = getFileDescriptor();
            int linesToRead = getNumLines();
            ArrayList<String> lines = readFile(file, linesToRead);
            System.out.println("Lines without sorting");
            printList(lines);

            // TODO 2: Add a Java statement below for sorting lines in ascending order
            lines.sort(null);


            System.out.println("Lines sorted in ascending order");
            printList(lines);

            // TODO 3: Add a Java statement below for sorting lines in descending order
            lines.sort(Collections.reverseOrder());

            System.out.println("Lines sorted in descending order");
            printList(lines);

            return;
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        } catch (NoSuchElementException e)
        {
            System.out.println("No more lines to read");
        } catch (NumberFormatException e)
        {
            System.out.println("Number of lines should be an integer");
        } finally
        {
            System.out.println("Exit try-catch block");
        }
    }
}
