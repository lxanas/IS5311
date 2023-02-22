package week6;

public class Week6Class1
{
    public static void main(String[] args)
    {
        int a,b;
        a=computeArea(5,7);
        b=computeArea(10,20);
        System.out.println(a+b);
    }

    public static int computeArea(int width, int length)
    {
        return width*length;
    }
}
