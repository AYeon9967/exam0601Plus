package exam.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	HashMap<String, Controller> map = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Controller>();
		map.put("/login.do", new LoginController());
		map.put("/subjectSearch.do", new SearchController());
		map.put("/enrollment.do", new EnrollmentController());
		map.put("/enrollComplete.do", new EnrollCompleteController());
		map.put("/insertSubject.do", new InsertSubjectController());
		map.put("/enrollSubjectList.do", new EnrollSubjectListController());
		map.put("/registedStu.do", new RegistedStudentController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
		
		Controller cont = map.get(path);
		cont.execute(req, resp);
	}

}
