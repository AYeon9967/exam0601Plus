package exam.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.service.Service;
import exam.vo.Enroll;

// 학생: 수강신청 확인
public class EnrollCompleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = Service.getInstance();
		
		HttpSession session = request.getSession();
		String stud = (String)session.getAttribute("id");
		
		ArrayList<Enroll> list = service.enrollCompleteList(stud);
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/result/enrollCompleteListResult.jsp");

	}

}
