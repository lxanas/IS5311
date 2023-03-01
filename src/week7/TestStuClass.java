//package week7;
//
//class InClassStudent
//{
//    private String stuName, stuId;
//
//    public InClassStudent(String stuName, String stuId)
//    {
//        this.stuName = stuName;
//        this.stuId = stuId;
//    }
//
//    public String getStuName()
//    {
//        return stuName;
//    }
//
//    public void setStuName(String stuName)
//    {
//        this.stuName = stuName;
//    }
//
//    public String getStuId()
//    {
//        return stuId;
//    }
//
//    public void setStuId(String stuId)
//    {
//        this.stuId = stuId;
//    }
//
//    public void print()
//    {
//        System.out.println("Student name: " + this.stuName + ", student id: " + this.stuId);
//    }
//
//    public void print(double gpa)
//    {
//        System.out.println("Gpa of " + stuName + "(" + stuId + ") is " + gpa);
//    }
//
//    public void print(int numEnrolledCourses)
//    {
//        System.out.println(
//                stuName + "(" + stuId + ") enrolled " +
//                        numEnrolledCourses + " Courses"
//        );
//    }
//
//}
//
//public class TestStuClass
//{
//    public static void main(String[] args)
//    {
//        InClassStudent[] lst = new InClassStudent[10];
//        for (int i = 0; i < 10; i++)
//        {
//            lst[i] = new InClassStudent(String.valueOf(i), String.valueOf(i));
//        }
//
//        for (int i = 0; i < 10; i++)
//        {
//            lst[i].print();
//        }
//
//        lst[1].print(3.9);
//        lst[1].print(5);
//    }
//}
