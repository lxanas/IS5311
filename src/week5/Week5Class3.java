package week5;

import java.util.Scanner;

public class Week5Class3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String raw = in.nextLine();
        String[] sentence = raw.split("\\.");
        for (int i = 0; i < sentence.length; i++)
        {
            System.out.println(sentence[i]);
        }
    }
}
