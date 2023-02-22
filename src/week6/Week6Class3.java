package week6;

import java.util.Random;
import java.util.Scanner;

public class Week6Class3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int k, min, max;
        k = in.nextInt();
        min = in.nextInt();
        max = in.nextInt();
        int[] a;
        a = createT(k, min, max);
        for (int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }

    }

    public static int[] createT(int k, int min, int max)
    {
        Random random = new Random();
        int[] a = new int[k];
        for (int i = 0; i < k; i++)
        {
            a[i] = random.nextInt(max - min + 1) + min;
        }
        return a;
    }
}
