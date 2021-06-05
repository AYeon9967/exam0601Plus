package exam.service;

import java.util.ArrayList;

import exam.dao.ExamDAO;
import exam.vo.Enroll;
import exam.vo.Subject;

public class Service {
	
	private static Service service = new Service();
	
	private Service() {}
	private ExamDAO dao = ExamDAO.getInstance();
	
	public static Service getInstance() {
		return service;
	}

	public boolean login(String id, String pwd, String position) {
		return dao.login(id, pwd, position);
	}

	public Subject search(String id) {
		return dao.search(id);
	}

	public void enroll(String stuId, String subId) {
		dao.enroll(stuId, subId);
	}

	public void insertSubject(Subject subject) {
		dao.insertSubject(subject);
		
	}

	public ArrayList<Subject> enrollSubjectList(String prof) {
		ArrayList<Subject> list = dao.enrollSubjectList(prof);
		return list;
	}

	public ArrayList<Enroll> enrollCompleteList(String stud) {
		ArrayList<Enroll> list = dao.enrollCompleteList(stud);
		return list;
	}

	public ArrayList<Subject> registedStudentList(String num) {
		ArrayList<Subject> list = dao.regiestedStudentList(num);
		return list;
	}

}
