package week2;

import java.util.Scanner;

public class FixedDepositCalculator
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("How much for the fixed deposit? ");
        final double RATE = 0.0235482;
        double deposit = in.nextDouble();
        System.out.print("What is your name? ");
        in.nextLine();
        String name = in.nextLine();
        System.out.println("Dear " + name + ",");
        System.out.println("In withdrawal mode:");
        double wAmount;
        wAmount = deposit * RATE;
        double wTotalAmount = wAmount * 5 + deposit;
        System.out.printf("You can receive $%,4f per year\n", wAmount);
        System.out.printf("The total amount on completion is $%,2f\n", wTotalAmount);

        System.out.println("In compound mode:");
        double cTotalAmount = deposit;
        for (int i = 1; i < 6; i++)
        {
            double temp = cTotalAmount * RATE;
            System.out.printf("The interest at year %d is $%,4f\n", i, temp);
            cTotalAmount += temp;
        }
        System.out.printf("The total amount on completion is $%,2f\n",cTotalAmount);
    }
}
