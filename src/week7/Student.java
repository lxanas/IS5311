package week7;

public class Student
{
    private static int numStudents = 0;
    private String stuName, stuId;

    public Student()
    {

    }

    public Student(String _stuName)
    {
        if (_stuName.length() >= 3)
        {
            this.stuName = _stuName;
        }
        else
        {
            System.out.println("Invalid student name");
        }
    }

    public Student(String _stuName, String _stuId)
    {
        if (_stuName.length() >= 3)
        {
            this.stuName = _stuName;
        }
        else
        {
            System.out.println("Invalid student name");
        }

        if (_stuId.length() == 8)
        {
            this.stuId = _stuId;

        }
        else
        {
            System.out.println("Invalid student id");
        }
    }

    public static int getNumStudents()
    {
        return numStudents;
    }

    public String getStuName()
    {
        if (stuName != null && stuName.length() >= 3)
            return stuName;
        else
            return "**Invalid name**";
    }

    public void setStuName(String _stuName)
    {
        if (_stuName.length() >= 3)
        {
            this.stuName = _stuName;
        }
        else
        {
            System.out.println("Invalid student name");
        }
        int flag = 0;
        if (stuName != null && stuName.length() >= 3)
        {
            flag++;
        }

        if (stuId != null && stuId.length() == 8)
        {
            flag++;
        }
        if (flag == 2) numStudents++;
    }

    public String getStuId()
    {

        if (stuId != null && stuId.length() == 8)
            return stuId;
        else
            return "**Invalid id**";
    }

    public void setStuId(String _stuId)
    {
        if (_stuId.length() == 8)
        {
            this.stuId = _stuId;
        }
        else
        {
            System.out.println("Invalid student id");
        }
        int flag = 0;
        if (stuName != null && stuName.length() >= 3)
        {
            flag++;
        }

        if (stuId != null && stuId.length() == 8)
        {
            flag++;
        }
        if (flag == 2) numStudents++;
    }

    public void enroll(Course course)
    {
        if (stuId != null && stuName != null)
        {
            if (stuId.length() == 8 && stuName.length() >= 3)
                course.add();
            else
                System.out.println("Student information is invalid, cannot enroll the course");

        }
        else
        {
            System.out.println("Student information is invalid, cannot enroll the course");
        }
    }
}
