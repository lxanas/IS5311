package week3;

import java.util.Scanner;

public class ShipCharge
{
    public static void main(String[] args)
    {
        double weight, distance;
        int year, month;
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter the weight, in pounds: ");
        weight = in.nextFloat();
        in.nextLine();
        System.out.printf("Enter the distance, in miles: ");
        distance = in.nextFloat();
        in.nextLine();
        System.out.printf("Enter the year of the shipping order: ");
        year = in.nextInt();
        if(year<1000||year>3000) System.out.println("Invalid year");
        in.nextLine();
        System.out.printf("Enter the month of the shipping order: ");
        month = in.nextInt();
        if(month<1||month>12) System.out.println("Invalid month");
        double per;
        if (weight <= 2) per = 1.1;
        else if (weight <= 6) per = 2.2;
        else if (weight <= 10) per = 3.7;
        else per = 4.8;

        int times = (int)(distance / 500);
        double rate;
        if((year%4==0&&year%100!=0)||(year%400==0))
        {

        }
        double all=times*per;
        System.out.println("The shipping charges are "+all);


    }
}
