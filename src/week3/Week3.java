package week3;

import java.util.Scanner;

public class Week3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int year=in.nextInt();
        if((year%4==0&&year%100!=0)||(year%400==0))
        {
            System.out.println("yes");
        }
    }
}
