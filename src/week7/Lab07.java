package week7;

/**
 * This lab exerxcise lets students to
 * practice on building Java Application
 * with multiple classes.
 * <p>
 * Students should have better understanding
 * on the usage of method modifiers, overloadding,
 * data integrity, null reference, etc.
 */
public class Lab07
{

    public static void main(String[] args)
    {
        // Create Course instances according to courseInfo.
        String[] courseInfo = {
                "IS3230", "IS4340"
        };
        Course[] courses = new Course[courseInfo.length];
        for (int i = 0; i < courses.length; i++)
        {
            System.out.println("----Creating course " + (i + 1) + "----");
            courses[i] = new Course(courseInfo[i]);
        }

        // Create Student instances according to initStudentInfo.
        String[][] initStudentInfo = {
                {},
                {},
                {"Kit"},
                {"Man Kit"},
                {"LMK", "01234567"},
                {"Joe", "33121121"},
                {"Ho"},
                {}
        };
        Student[] students = new Student[initStudentInfo.length];
        for (int i = 0; i < students.length; i++)
        {
            System.out.println("----Creating student " + (i + 1) + "----");
            if (initStudentInfo[i].length == 0)
                students[i] = new Student();
            else if (initStudentInfo[i].length == 1)
                students[i] = new Student(initStudentInfo[i][0]);
            else
                students[i] = new Student(initStudentInfo[i][0], initStudentInfo[i][1]);
        }

        // Update student information (name and/or id) according to updateStudentInfo.
        String[][] updateStudentInfo = {
                {"Lau Man", "76543210"},
                {"Jessica", null},
                {"David", "1234"},
                {null, "12341234"},
                {null, "13524678"},
                {"Chris", "1234"},
                {null, "12345432"},
                {"Lo", "11221133"}
        };
        for (int i = 0; i < students.length; i++)
        {
            if (updateStudentInfo[i][0] != null || updateStudentInfo[i][1] != null)
                System.out.println("----Updating student " + (i + 1) + "----");
            if (updateStudentInfo[i][0] != null)
                students[i].setStuName(updateStudentInfo[i][0]);
            if (updateStudentInfo[i][1] != null)
                students[i].setStuId(updateStudentInfo[i][1]);
        }

        // Enroll students to courses evenly.
        // Tries to enroll about numStudents/numCourses students into each course.
        for (int i = 0; i < students.length; i++)
        {
            int index = i * courses.length / students.length;
            System.out.println("----student " + (i + 1) + " enrolls course " + (index + 1) + "----");
            students[i].enroll(courses[index]);
        }

        // Prints the number of courses and number of students.
        System.out.println("Num courses: " + Course.getNumCourses());
        System.out.println("Num valid students: " + Student.getNumStudents());

        // For each course, prints the number of students that are successfully enrolled.
        for (int i = 0; i < courses.length; i++)
            System.out.println("Num students in " + courses[i].getCourseCode() + ": " + courses[i].getNumEnrollments());

        // Prints the student name and id for each student.
        for (int i = 0; i < students.length; i++)
            System.out.println("student " + (i + 1) + ": name = " + students[i].getStuName() + ", id = " + students[i].getStuId());

    }
}



