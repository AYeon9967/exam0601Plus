package exam.vo;

public class Enroll {
	private String subject;
	private String student;
	
	public Enroll() {	}
	
	public Enroll(String subject, String student) {
		this.subject = subject;
		this.student = student;
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}

}
