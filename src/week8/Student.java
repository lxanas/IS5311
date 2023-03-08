package week8;

public class Student extends Person
{
    private String stuId, email;

    public Student(String name, String mobile, String address, String stuId, String email)
    {
        super(name, mobile, address);
        this.stuId = stuId;
        this.email = email;
    }

    public void print()
    {
        System.out.println("Name: " + getName() + " Mobile: " + getMobile() + " Address: " + getAddress() + " StuID: " + stuId + " Email: " + email);
    }
}
