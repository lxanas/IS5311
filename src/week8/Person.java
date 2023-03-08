package week8;

public class Person
{
    private String name, mobile, address;

    public Person(String name, String mobile, String address)
    {
        this.name = name;
        this.mobile = mobile;
        this.address = address;
    }

    public void print()
    {
        System.out.println("Name: "+name+" Mobile: "+mobile+" Address: "+address);
    }

    public String getName()
    {
        return name;
    }

    public String getMobile()
    {
        return mobile;
    }

    public String getAddress()
    {
        return address;
    }
}
