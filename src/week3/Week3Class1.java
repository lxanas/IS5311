package week3;

import java.util.Random;

public class Week3Class1
{
    public static void main(String[] args)
    {
        Random randomNum = new Random();
        int num=randomNum.nextInt(100);
        System.out.println("The random number is "+num);
        if(num<=50)
        {
            System.out.println("A small random number is generated");
        }
        else
        {
            System.out.println("A large random number is generated");
        }
    }
}
