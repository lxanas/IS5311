public class Student {
	private static int numStudents;
	private String stuName;
	private String stuId;
	
	public Student() {
	}
	
	public Student(String _stuName) {
		setStuName(_stuName);
	}
	
	public Student(String _stuName, String _stuId) {
		setStuName(_stuName);
		setStuId(_stuId);
	}
	
	public void setStuName(String _stuName) {
		if (isValidStuName(_stuName)) {
			if (!isValidStuName(stuName) && isValidStuId(stuId)) {
				numStudents++;
			}
			stuName = _stuName;
		} else {
			System.out.println("Invalid student name");
		}
	}
	
	public void setStuId(String _stuId) {
		if (isValidStuId(_stuId)) {
			if (!isValidStuId(stuId) && isValidStuName(stuName)) {
				numStudents++;
			}
			stuId = _stuId;
		} else {
			System.out.println("Invalid student id");
		}
	}
	
	public static int getNumStudents() {
		return numStudents;
	}
	
	public String getStuName() {
		if (isValidStuName(stuName))
			return stuName;
		else
			return "**Invalid name**";
	}

	public String getStuId() {
		if (isValidStuId(stuId))
			return stuId;
		else
			return "**Invalid id**";
	}
	
	public void enroll(Course course) {
		if (course != null && isValidStuName(stuName) && isValidStuId(stuId))
			course.add();
		else
			System.out.println("Student information is invalid, cannot enroll the course");
	}
	
	private boolean isValidStuName(String _stuName) {
		return _stuName != null && _stuName.length() > 2;
	}
	
	private boolean isValidStuId(String _stuId) {
		return _stuId != null && _stuId.length() == 8;
	}
}
