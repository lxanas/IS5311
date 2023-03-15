package week9;

import java.util.Scanner;

public class Harmonic
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = in.nextInt();
        System.out.println("The harmonic sum is " + harmonic(n));
    }

    public static double harmonic(int n)
    {
        if (n == 1)
        {
            return 1;
        }
        else
        {
            return 1.0 / n + harmonic(n - 1);
        }
    }
}
