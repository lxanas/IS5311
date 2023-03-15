package week9;

import java.util.Scanner;

public class Reverse
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = in.nextLine();
        System.out.println("The reverse is: " + reverse(s));
    }

    public static String reverse(String s)
    {
        if (s.length() == 1)
        {
            return s;
        }
        else
        {
            return s.substring(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
        }
    }
}
