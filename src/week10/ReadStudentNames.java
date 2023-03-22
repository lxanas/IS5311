package week10;

import java.util.*;
import java.io.*;

public class ReadStudentNames
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = in.nextLine();
        System.out.print("Enter number of student names to be read: ");
        String numStu = in.nextLine();
        int readNum = 0;
        try
        {
            File file = new File(fileName);
            Scanner infile = new Scanner(file);
            int numNamesToBeRead = Integer.parseInt(numStu);
            ArrayList<String> studentNames = new ArrayList<String>();

            for (int i = 0; i < numNamesToBeRead; i++)
            {
                String name = infile.nextLine();
                studentNames.add(name);
                readNum++;
            }
            studentNames.sort(null);

            System.out.println("Student names:");
            for (String name : studentNames)
            {
                System.out.println(name);
            }

        } catch (FileNotFoundException e)
        {
            System.out.println("The file doesn't exist");
        } catch (NumberFormatException e)
        {
            System.out.println("The number of student names to be read should be an integer");
        } catch (NoSuchElementException e)
        {
            System.out.println("Cannot read more than " + readNum + " student names");
        } finally
        {
            System.out.println("The end of the try-catch block");
        }
    }
}

