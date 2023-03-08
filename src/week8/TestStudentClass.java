package week8;

public class TestStudentClass
{
    public static void main(String[] args)
    {
        Person a = new Person("alice", "12345678", "Africa");
        Student b = new Student("Xiaoming", "87654321", "Beijing", "2120221234", "2120221234@pku.edu.cn");
        a.print();
        b.print();
    }
}
