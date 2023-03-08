package week7;

public class Course
{
    private int numEnrollments;
    private static int numCourses = 0;
    private String courseCode;

    public Course(String _courseCode)
    {
        this.courseCode = _courseCode;
        numEnrollments = 0;
        addNumCourse();
    }

    public static int getNumCourses()
    {
        return numCourses;
    }

    public int getNumEnrollments()
    {
        return numEnrollments;
    }

    public String getCourseCode()
    {
        return courseCode;
    }

    public static void addNumCourse()
    {
        numCourses++;
    }

    public void setCourseCode(String _courseCode)
    {
        this.courseCode = _courseCode;
    }

    public void add()
    {
        numEnrollments++;
    }
}
