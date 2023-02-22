package week6;

public class Week6Class2
{
    public static void main(String[] args)
    {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        System.out.println(a[8]);
        modify(a, 8, 8);
        System.out.println(a[8]);
    }

    public static void modify(int[] a, int k, int v)
    {
        a[k] = v;
    }
}
