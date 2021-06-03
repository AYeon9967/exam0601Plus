package exam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.service.Service;
import exam.vo.Subject;

public class InsertSubjectController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String sn = request.getParameter("sn");
		String prof = (String)session.getAttribute("id");

		if(id.isEmpty() || title.isEmpty() || sn.isEmpty()) {
			request.setAttribute("error", "Please put all blanks!");
			HttpUtil.forward(request, response, "/insertSubject.jsp)");
			return;
		}
		
		Subject subject = new Subject();
		subject.setId(id);
		subject.setName(title);
		subject.setCount(sn);
		subject.setProf(prof);
		
		Service service = Service.getInstance();
		service.insertSubject(subject);
		
		HttpUtil.forward(request, response, "pMenu.jsp");
		
	}

}
