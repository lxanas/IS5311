package week3;

import java.util.Scanner;

public class Week3Class3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int length = in.nextInt();
        if (width < 0 || length < 0)
        {
            System.out.println("Invalid width or length");
        }
        else if (width == length)
        {
            System.out.println("This is a square with are " + (width * length));
        }
        else
        {
            System.out.println("This is a rectangle with perimeter " + (width + length) * 2);
        }
    }
}
