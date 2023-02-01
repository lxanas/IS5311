package week3;

import java.util.Scanner;

public class Week3Class2
{
    public static void main(String[] args)
    {
        String a = "Hello", b = "hello", c = "Bye", d = "bye";
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if (input.equals(a) || input.equals(b))
        {
            System.out.println("Nice to meet you");
        }
        else if (input.equals(c) || input.equals(d))
        {
            System.out.println("Stay cool");
        }
        else
        {
            System.out.println("I don’t understand what you are saying");
        }
    }
}
