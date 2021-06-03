package exam.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.service.Service;
import exam.vo.Subject;

public class EnrollSubjectListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = Service.getInstance();
		
		HttpSession session = request.getSession();
		String prof = (String)session.getAttribute("id");
		
		ArrayList<Subject> list = service.enrollSubjectList(prof);
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/result/enrollSubjectListResult.jsp");

	}

}
