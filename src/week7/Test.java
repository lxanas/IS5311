package week7;

class MyDate
{
    private int year;
    private int month;
    private int day;

    private String test;


    public MyDate()
    {
    }

    public MyDate(int y, int m, int d)
    {
        year = y;
        month = m;
        day = d;
    }

    public boolean t()
    {
        if(this.test==null) return true;
        else return false;
    }
}

public class Test
{
    public static void main(String[] args)
    {
        MyDate a1=new MyDate(1,2,3);
        MyDate a=new MyDate();
        if(a.t())
        {
            System.out.println("NULLLLL");
        }
    }
}
