package exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import exam.vo.Enroll;
import exam.vo.Subject;

public class ExamDAO {
	
	private static ExamDAO dao = new ExamDAO();
	private ExamDAO() {}
	
	public static ExamDAO getInstance() {
		return dao;
	}
	
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "hello1248");
		} catch(Exception e) {
			System.out.print("MDAO: connect " + e);
		}
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch(Exception e) {
				System.out.print("Pstmt close error " + e);
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(Exception e) {
				System.out.print("Conn close error " + e);
			}
		}
	}
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch(Exception e) {
				System.out.print("Rs close error " + e);
			}
		}
		close(conn, pstmt);
	}

	public boolean login(String id, String pwd, String position) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = connect();
			if(position.equals("student")) {
				pstmt = conn.prepareStatement("select * from student where id=? and pwd=?;");
			} else {
				pstmt = conn.prepareStatement("select * from prof where id=? and pwd=?;");
			}
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			} else {
				result = false;
			}
		} catch(Exception e) {
			System.out.print("Login error " + e);
		} finally {
			close(conn, pstmt, rs);
		}	
		
		return result;
	}

	public Subject search(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Subject subject = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select id, name from subject where id=?;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				subject = new Subject();
				subject.setId(rs.getString(1));
				subject.setName(rs.getString(2));
			}
			
		} catch(Exception e) {
			System.out.print("Search error " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return subject;
	}

	public void enroll(String stuId, String subId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into enroll values(?, ?);");
			pstmt.setString(1, subId);
			pstmt.setString(2, stuId);
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("Enroll error " + e);
		} finally {
			close(conn, pstmt);
		}
		
	}

	public void insertSubject(Subject subject) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into subject values(?, ?, ?, ?);");
			pstmt.setString(1, subject.getId());
			pstmt.setString(2, subject.getName());
			pstmt.setString(3, subject.getCount());
			pstmt.setString(4, subject.getProf());
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.print("InsertSubject error " + e);
		} finally {
			close(conn, pstmt);
		}
	}

	public ArrayList<Subject> enrollSubjectList(String prof) {
		ArrayList<Subject> list = new ArrayList<Subject>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Subject subject = null;
		
		try {
			conn = connect();
			//pstmt = conn.prepareStatement("select * from subject where prof=?;");
			pstmt = conn.prepareStatement("select a.subject, b.name, b.count, count(*) as studentenroll from enroll a, subject b where a.subject = b.id and prof = ? group by subject;");
			pstmt.setString(1, prof);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				subject = new Subject();
				subject.setId(rs.getString(1));
				subject.setName(rs.getString(2));
				subject.setCount(rs.getString(3));
				subject.setProf(rs.getString(4));
				list.add(subject);
				}
		} catch(Exception e) {
				System.out.print("enrollSubjectList error " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}

	public ArrayList<Enroll> enrollCompleteList(String stud) {
		ArrayList<Enroll> list = new ArrayList<Enroll>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Enroll enroll = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select b.id, b.name from enroll a, subject b where a.subject = b.id and a.student=?;");
			pstmt.setString(1, stud);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				enroll = new Enroll();
				enroll.setSubject(rs.getString(1));
				enroll.setStudent(rs.getString(2));
				list.add(enroll);
				}
		} catch(Exception e) {
				System.out.print("enrollCompleteList error " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}

	public ArrayList<Enroll> regiestedStudentList(String num) {
		ArrayList<Enroll> list = new ArrayList<Enroll>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Enroll enroll = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select b.id, b.name from enroll a, student b where a.subject = ? and b.id and a.student;");
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				enroll = new Enroll();
				enroll.setSubject(rs.getString(1));
				enroll.setStudent(rs.getString(2));
				list.add(enroll);
				}
		} catch(Exception e) {
				System.out.print("regiestedStudentList error " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	
}
