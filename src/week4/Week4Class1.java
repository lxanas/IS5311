package week4;

import java.util.Scanner;

public class Week4Class1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int s, e;
        s = in.nextInt();
        e = in.nextInt();
        for (int i = 0; i < (e - s) / 3 - 1; i++)
        {
            s += 3;
            System.out.println(s);
        }
    }
}
