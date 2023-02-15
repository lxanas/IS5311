package week5;

import java.util.Scanner;

public class Week5Class2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int s;
        s = in.nextInt();
        int[] a = new int[s];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = 2 * i;
        }
        for (int i = a.length / 2; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
    }
}
