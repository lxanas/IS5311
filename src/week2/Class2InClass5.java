package week2;

import java.util.Scanner;

public class Class2InClass5
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        double width, length;
        width = in.nextDouble();
        length = in.nextDouble();
        double area;
        area = width * length;
        System.out.printf("%.2f\n",area);
    }
}
