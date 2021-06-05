package exam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.service.Service;
import exam.vo.Enroll;

// 학생: 수강신청
public class EnrollmentController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String stuId = (String)session.getAttribute("id");
		String subId = request.getParameter("subId");
		
		if (stuId != null && subId != null)	Service.getInstance().enroll(stuId, subId);
		
		HttpUtil.forward(request, response, "/sMenu.jsp");
	}

}
